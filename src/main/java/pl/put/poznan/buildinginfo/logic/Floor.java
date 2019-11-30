package pl.put.poznan.buildinginfo.logic;

import java.util.ArrayList;

public class Floor extends Location {

    private ArrayList<Room> roomArrayList;

    Floor() {
        super();
        this.roomArrayList = new ArrayList<Room>(1000);
    }

    Floor(String name) {
        super(name);
        this.roomArrayList = new ArrayList<Room>(1000);
        //TODO: stuff that makes this piece of code work
    }

    public void setRoomArrayList(ArrayList<Room> roomArrayList) {
        this.roomArrayList = roomArrayList;
    }

    public ArrayList<Room> getRoomArrayList() {
        return roomArrayList;
    }

    public float getSquareArea() {
        float floorSquareArea = 0;
        for (Room r : this.roomArrayList) {
            floorSquareArea += r.getArea();
        }
        return floorSquareArea;
    }


    public float getCubicArea() {
        float floorCubicArea = 0;
        for (Room r : this.roomArrayList) {
            floorCubicArea += r.getCube();
        }
        return floorCubicArea;
    }


    public Room getRoom(Object... args) {
        String id = args.length > 0 ? (String) args[0] : null;
        String name = args.length > 1 ? (String) args[1] : null;
        for (Room r : this.roomArrayList) {
            if (r.getName().equals(name) || r.getId().equals(id)) {
                return r;
            }
        }
        return null;
    }
    public float getLight(){
        float light = 0;
        for (Room r: this.roomArrayList) {
            light += r.getLight();
        }
        return light;
    }

    public float getHeat(){
        float heat = 0;
        for (Room r: this.roomArrayList) {
            heat += r.getHeat();
        }
        return heat;
    }


    public ArrayList<Room> getOvearHeatingRooms(float parameter) {
        ArrayList<Room> overHeatingRooms = new ArrayList<Room>();
        for (Room r : this.roomArrayList) {
            if (r.getHeatPerCubicArea() > parameter) {
                overHeatingRooms.add(r);
            }
        }
        return overHeatingRooms;
    }


}
