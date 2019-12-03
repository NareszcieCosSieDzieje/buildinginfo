package pl.put.poznan.buildinginfo.logic;

import com.google.gson.Gson;

public class JSONparser {

    /**
     * Funkcja parsująca obiekty z pliku do instancji klass, w tym przypadku jest to klasa budynku.
     * @param buildingData nazwa pliku .json z danymi o budynku
     * @return building
     */
    public static Building getObject(String buildingData)
    {
        Gson gson = new Gson();
        return gson.fromJson(buildingData, Building.class);
    }
}
