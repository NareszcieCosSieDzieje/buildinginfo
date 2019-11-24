package pl.put.poznan.buildinginfo.logic;

import java.util.ArrayList;

public class Floor extends Location {
        private ArrayList<Room> roomArrayList;


        Floor(){
            this.roomArrayList = new ArrayList<Room>(1000);
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
                if (r.getName().equals(name) || r.getId().equals(id) ) {
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
            float heatPerCubicArea = 0;
            for(Room r: this.roomArrayList){
                heatPerCubicArea += r.getHeatPerCubicArea();
            }
            return heatPerCubicArea;
        }


        public ArrayList<Room> getOvearHeatingRooms(float parameter){
            ArrayList<Room> overHeatingRooms = new ArrayList<Room>();
            for(Room r: this.roomArrayList){
                if(r.getHeatPerCubicArea() > parameter){
                    overHeatingRooms.add(r);
                }
            }
            return overHeatingRooms;
        }


}
