package pl.put.poznan.buildinginfo.repository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.put.poznan.buildinginfo.logic.Building;

@Component
public class DataBaseSeeder implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        //initialze database and populate with buildings
        for(int i = 0; i < 5; i++){
            Building b = new Building();

        }

    }
}
