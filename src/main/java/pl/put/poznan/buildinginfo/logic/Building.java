package main.java.pl.put.poznan.buildinginfo.logic;

import java.util.ArrayList;

public class Building extends Location{

    private ArrayList<Floor> floorArrayList;

    public Building(){
        //super(); nadrzedna klasa implicit

    }

    public Building(ArrayList<Floor> floors){
        //dunno

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
            if (f.getName() == name || f.getId() == id) {
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
            if (r.getName() == name || r.getId() == id) {
               return r.getArea();
            }
        }
        return -1;
    }

    public float getFloorCubicArea(Object... args){
        String name = args.length > 0 ? (String)args[0] : null;
        String id   = args.length > 1 ? (String)args[1] : null;
        for (Floor f : this.floorArrayList) {
            if (f.getName() == name || f.getId() == id) {
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
            if (r.getName() == name || r.getId() == id) {
                return r.getCube();
            }
        }
        return -1;
    }

    public float getFloorLightPerSquareArea(){
        return -1;
    }

    public float getFloorHeatPerCubicArea(){
        return -1;
    }

}
