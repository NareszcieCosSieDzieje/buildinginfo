package pl.put.poznan.buildinginfo.logic;

import java.util.Random;
import java.util.UUID;

public abstract class Location {
    private String id;
    private String name;

    public Location(String name) {
        if (name == null) {
            name = this.generateRandomName();
        }
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }

    public Location() {
        this(null);
    }

    public void setId(String id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private String generateRandomName() {
        Random generator = new Random();
        String name = "";
        boolean upper;
        char letter;
        for(int i = 0; i < 10; i++) {
            upper = generator.nextBoolean();
            if (upper) {
                letter = (char)(generator.nextInt(26) + 65);
            } else {
                letter = (char)(generator.nextInt(26) + 97);
            }
            name += letter;
        }
        return name;
    }
}
