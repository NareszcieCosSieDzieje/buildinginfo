package pl.put.poznan.buildinginfo.logic;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "Buildings")
public abstract class Location {
    @Id
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
    // settery

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
