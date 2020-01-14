package pl.put.poznan.buildinginfo.logic;

import java.util.ArrayList;

/**
 * klasa reprezentująca piętra budynków
 */
public class Floor extends Location {

    /**
     * Lista pokoi na danym piętrze
     */
    private ArrayList<Room> roomArrayList;

    /**
     * Konstruktor bezparametrowy generujący randomowe dane
     */
    Floor() {
        super();
        this.roomArrayList = new ArrayList<Room>(1000);
    }

    /**
     * Konstruktor zparametryzowany generujący rank dane o pokojach
     * @param name nazwa danego piętra
     */
    public Floor(String name) {
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

    /**
     * zwracanie kubatury piętra
     * @return
     */
    public float getCubicArea() {
        float floorCubicArea = 0;
        for (Room r : this.roomArrayList) {
            floorCubicArea += r.getCube();
        }
        return floorCubicArea;
    }

    /**
     * zwracanie danego pokoju na piętrze
     * @param args orgumenty potrzebne do identyfikacji pokoju id i nazwa
     * @return
     */
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

    /**
     * zwraca oświetlenie pietra
     * @return
     */
    public float getLight(){
        float light = 0;
        for (Room r: this.roomArrayList) {
            light += r.getLight();
        }
        return light;
    }

    /**
     * zwracanie ciepłoty piętra
     * @return
     */
    public float getHeat(){
        float heat = 0;
        for (Room r: this.roomArrayList) {
            heat += r.getHeat();
        }
        return heat;
    }

    /**
     * zwraca przegrzane pokoje za określane za pomocą parametru
     * @param parameter graniczna wartość ogrzania pokoju
     * @return
     */
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
