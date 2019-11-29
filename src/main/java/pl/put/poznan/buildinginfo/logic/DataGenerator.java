package pl.put.poznan.buildinginfo.logic;

import java.util.Random;

public class DataGenerator {

    public Building generateBuilding(){
        Building building = new Building();
        Random generator = new Random();

        int floors = generator.nextInt(10) + 1;
        int rooms = generator.nextInt(20) + 1;
        for (int i = 0; i < floors; i++) {
            Floor floor = new Floor();
            for (int j = 0; j < rooms; j++) {
                Room room = new Room();
                floor.getRoomArrayList().add(room);
            }
            building.getFloorArrayList().add(floor);
        }

        return building;

        //jakis data loader do typow budynkow np.: kamienica, blok, wieżowiec, dom wolnostojący
    }

}
