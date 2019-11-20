package main.java.pl.put.poznan.buildinginfo.logic;

import java.util.ArrayList;

public class Floor extends Location {
        private ArrayList<Room> roomArrayList;


        Floor(){
            //TODO: stuff that makes this piece of code work
        }


        public float getSquareArea(){
            float floorSquareArea = 0;
            for(Room r: this.roomArrayList){
                floorSquareArea += r.getArea();
            }
            return floorSquareArea;
        }

        public float getCubicArea(){
            float floorCubicArea = 0;
            for(Room r: this.roomArrayList){
                floorCubicArea += r.getCube();
            }
            return floorCubicArea;
        }



        public Room getRoom(Object... args){
            String name = args.length > 0 ? (String)args[0] : null;
            String id   = args.length > 1 ? (String)args[1] : null;
            for(Room r: this.roomArrayList){
                if (r.getName() == name || r.getId() == id) {
                    return r;
                }
            }
            return null;
        }

        public float getLightPerSquareArea(){
            float lightPerSquareArea = 0;
            for(Room r: this.roomArrayList){
                lightPerSquareArea += r.getLightPerSquareArea();
            }
            return lightPerSquareArea;

        }

        public float getHeatPerCubicArea(){
            float heatPerSquareArea = 0;
            for(Room r: this.roomArrayList){
                heatPerSquareArea += r.getHeatPerCubicArea();
            }
            return heatPerSquareArea;

        }
}
