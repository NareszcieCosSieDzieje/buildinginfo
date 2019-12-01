package pl.put.poznan.buildinginfo.logic;

import java.util.ArrayList;


public class Building extends Location{

    private ArrayList<Floor> floorArrayList;

    public Building(){
        super();
        this.floorArrayList = new ArrayList<Floor>(100);
    }

    public Building(String name){
        super(name);
        this.floorArrayList = new ArrayList<Floor>(100);
    }

    public ArrayList<Floor> getFloorArrayList() {
        return floorArrayList;
    }

    public void setFloorArrayList(ArrayList<Floor> floorArrayList) {
        this.floorArrayList = floorArrayList;
    }

    public float getTotalSquareArea(){
        float totalSquareArea = 0;
        for(Floor f: this.floorArrayList){
            totalSquareArea += f.getSquareArea();
        }
        return totalSquareArea;
    }

    public float getFloorSquareArea(Object... args) {
        String id = args.length > 0 ? (String)args[0] : null;
        String name   = args.length > 1 ? (String)args[1] : null;
        for (Floor f : this.floorArrayList) {
            if (f.getName().equals(name) || f.getId().equals(id) ) {
                return f.getSquareArea();
            }
        }
        return -1; //TODO: Sprawdz to potem
    }

    public float getRoomSquareArea(Object... args) {

        String id = args.length > 0 ? (String)args[0] : null;
        String name   = args.length > 1 ? (String)args[1] : null;
        for (Floor f : this.floorArrayList) {
            Room r = f.getRoom(id);
            if(r != null) {
                return r.getArea();
            }
        }
        return -1;

    }
    public float getTotalCubicArea(){
        float totalCubicArea = 0;
        for(Floor f: this.floorArrayList){
            totalCubicArea += f.getCubicArea();
        }
        return totalCubicArea;
    }

    public float getFloorCubicArea(Object... args){
        String id = args.length > 0 ? (String)args[0] : null;
        String name   = args.length > 1 ? (String)args[1] : null;
        for (Floor f : this.floorArrayList) {
            if (f.getName().equals(name) || f.getId().equals(id) )  {
                return f.getCubicArea();
            }
        }
        return -1; //TODO: Sprawdz to potem
    }

    public float getRoomCubicArea(Object... args) {
        String id = args.length > 0 ? (String)args[0] : null;
        String name   = args.length > 1 ? (String)args[1] : null;
        for (Floor f : this.floorArrayList) {
            Room r = f.getRoom(id);
            if(r != null) {
                return r.getCube();
            }
        }
        return -1;
    }

    public float getTotalLight(){
        float totalLight = 0;
        for(Floor f: this.floorArrayList){
            totalLight += f.getLight();
        }
        totalLight = totalLight/this.getTotalSquareArea();
        return totalLight;
    }


    public float getFloorLight(String id) {
        for (Floor f : this.floorArrayList) {
            if (f.getId().equals(id))  {
                return f.getLight()/f.getSquareArea();
            }
        }
        return -1;
    }
    public float getRoomLight(String id) {
        for (Floor f : this.floorArrayList) {
            Room r = f.getRoom(id);
            if(r != null) {
                return r.getLight()/r.getArea();
            }
        }
        return -1;
    }
    public float getTotalHeat(){
        float totalHeat = 0;
        for(Floor f: this.floorArrayList){
            totalHeat += f.getLight();
        }
        totalHeat = totalHeat/this.getTotalSquareArea();
        return totalHeat;
    }
    public float getFloorHeat(String id) {
        for (Floor f : this.floorArrayList) {
            if (f.getId().equals(id))  {
                return f.getHeat()/f.getCubicArea();
            }
        }
        return -1;
    }
    public float getRoomHeat(String id) {
        for (Floor f : this.floorArrayList) {
            Room r = f.getRoom(id);
            if(r != null) {
                return r.getHeat()/r.getCube();
            }
        }
        return -1;
    }


    public ArrayList<Room> getOverheatingRooms(float parameter){
        ArrayList<Room> overHeatingRooms = new ArrayList<Room>();
        for(Floor f: this.floorArrayList){
            overHeatingRooms.addAll(f.getOvearHeatingRooms(parameter));
        }
        return overHeatingRooms;
    }


}

