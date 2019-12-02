package pl.put.poznan.buildinginfo.logic;

import com.google.gson.Gson;

import java.io.*;
import java.util.Random;

public class DataGenerator {

    public static Building generateBuilding(String name) throws IOException {
        Building building = new Building(name);
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
        handleCreatingBuildingFile(building);
        return building;
    }

    public static void handleCreatingBuildingFile(Building building) throws IOException {
        Gson g = new Gson();
        String jsonString = g.toJson(building);
        StringBuilder file_name = new StringBuilder("src/main/resources/");
        file_name.append(building.getName());
        file_name.append(".json");

        File file = new File(file_name.toString());
        if (file.createNewFile()){
            System.out.println("File is created!");
        }
        else{
            System.out.println("File already exists.");
        }
        FileWriter writer = new FileWriter (file);
        writer.write(jsonString);
        writer.close();
    }

}
