package pl.put.poznan.buildinginfo.logic;

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

    public void setId(String id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
