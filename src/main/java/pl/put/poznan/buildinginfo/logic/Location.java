package main.java.pl.put.poznan.buildinginfo.logic;

import java.util.UUID;

public abstract class Location {
    private String id;
    private String name;
    public Location(){
        this("RANDOMLY_GENERATED");
    }

    public Location(String name){
        this.name = name;
        this.id = UUID.randomUUID().toString();
        //Metoda generowania/sprawdzania nazw>
    }
    //gettery
    // settery

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
