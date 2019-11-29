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

    public void setId(String id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
