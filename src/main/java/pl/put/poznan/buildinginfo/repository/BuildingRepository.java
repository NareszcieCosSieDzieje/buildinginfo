package pl.put.poznan.buildinginfo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.put.poznan.buildinginfo.logic.Building;

@Repository
public interface BuildingRepository extends MongoRepository<Building, String> {
}
