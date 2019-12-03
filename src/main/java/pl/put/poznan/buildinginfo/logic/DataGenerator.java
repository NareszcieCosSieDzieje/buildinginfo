package pl.put.poznan.buildinginfo.logic;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Random;

/**
 * Klasa odpowiedzialna za generowanie nowych danych, tworzy nowe budynki piętra i pokoje.
 */
public class DataGenerator {

    private final static Logger log = LoggerFactory.getLogger(DataGenerator.class);

    /**
     *Metoda generująca nowy budynek z parametrem name, który będzie nazwą dla danego budynku
     *Budynek tworzony jest za pomocą konstruktora z parametrem, następnie za pomocą random generatora liczb
     *dodawane są piętra oraz pokoje do list. Piętra są dodawane do listy pięter budynku, a pokoje do listy pokoi piętra.
     * @param name  nazwa budynku
     * @return new building
     * @throws IOException
     *
     */
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

    /**
     * Funkcja, która obsługuje zapis nowo stworzonego budynku do pliku w formacie .json,
     * funkcja tworzy plik na podstawie nazwy budnynku, w folderze resources.
     * Sprawdza, czy taki budynek już istnieje, jeżeli tak, zwraca komunikat, jezeli nie, tworzy nowy plik
     * @param building stworzony budynek
     * @throws IOException
     *
     */
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
