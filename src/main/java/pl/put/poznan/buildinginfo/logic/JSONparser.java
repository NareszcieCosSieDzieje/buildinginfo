package pl.put.poznan.buildinginfo.logic;

import com.google.gson.Gson;

public class JSONparser {

    public static Building getObject(String buildingData)
    {
        Gson gson = new Gson();
        return gson.fromJson(buildingData, Building.class);
    }
}
