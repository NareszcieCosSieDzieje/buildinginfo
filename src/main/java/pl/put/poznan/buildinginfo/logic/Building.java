package pl.put.poznan.buildinginfo.logic;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "Buildings")
@TypeAlias("Building")
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
        String name = args.length > 0 ? (String)args[0] : null;
        String id   = args.length > 1 ? (String)args[1] : null;
        for (Floor f : this.floorArrayList) {
            if (f.getName().equals(name) || f.getId().equals(id) ) {
                return f.getSquareArea();
            }
        }
        return -1; //TODO: Sprawdz to potem
    }

    public float getRoomSquareArea(Object... args) {
        String name = args.length > 0 ? (String)args[0] : null;
        String id   = args.length > 1 ? (String)args[1] : null;
        for (Floor f : this.floorArrayList) {
            Room r = f.getRoom();
            if (r.getName().equals(name) || r.getId().equals(id) ) {
               return r.getArea();
            }
        }
        return -1;
    }

    public float getFloorCubicArea(Object... args){
        String name = args.length > 0 ? (String)args[0] : null;
        String id   = args.length > 1 ? (String)args[1] : null;
        for (Floor f : this.floorArrayList) {
            if (f.getName().equals(name) || f.getId().equals(id) )  {
                return f.getCubicArea();
            }
        }
        return -1; //TODO: Sprawdz to potem
    }

    public float getRoomCubicArea(Object... args) {
        String name = args.length > 0 ? (String)args[0] : null;
        String id   = args.length > 1 ? (String)args[1] : null;
        for (Floor f : this.floorArrayList) {
            Room r = f.getRoom();
            if (r.getName().equals(name) || r.getId().equals(id) ) {
                return r.getCube();
            }
        }
        return -1;
    }


    public float getFloorLightPerSquareArea() {
        float totaLightperSquareArea = 0;
        for(Floor f: this.floorArrayList){
            totaLightperSquareArea += f.getLightPerSquareArea();
        }
        return totaLightperSquareArea;
    }


    public float getFloorHeatPerCubicArea() {
        float totaHeatperCubicArea = 0;
        for(Floor f: this.floorArrayList){
            totaHeatperCubicArea += f.getHeatPerCubicArea();
        }
        return totaHeatperCubicArea;
    }


    //TODO: obiekt zwracany, arraylist czy string złożony z room.toString?
    public ArrayList<Room> getOverheatingRooms(float parameter){
        ArrayList<Room> overHeatingRooms = new ArrayList<Room>();
        for(Floor f: this.floorArrayList){
            overHeatingRooms.addAll(f.getOvearHeatingRooms(parameter));
        }
        return overHeatingRooms;
    }


}

