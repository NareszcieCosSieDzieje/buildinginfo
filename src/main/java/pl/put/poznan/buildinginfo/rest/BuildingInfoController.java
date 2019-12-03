package pl.put.poznan.buildinginfo.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pl.put.poznan.buildinginfo.logic.*;
import java.io.IOException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.put.poznan.buildinginfo.logic.Building;
import pl.put.poznan.buildinginfo.logic.JSONparser;
import pl.put.poznan.buildinginfo.logic.ReadBuildingFile;
import pl.put.poznan.buildinginfo.logic.Room;

import java.util.ArrayList;
import java.util.List;


@RestController
public class BuildingInfoController {
    private Logger log = LoggerFactory.getLogger(BuildingInfoController.class);

    static class ExceptionHandler{

        public static ResponseEntity<Float> checkValue(Float value){
            if (value == -1){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else{
                return new ResponseEntity<>(value, HttpStatus.OK);
            }
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/total-square-area/{buildingFilename}")
    public float totalSquareArea(@PathVariable String buildingFilename) {
        log.info("Counting Total Square Area " + buildingFilename);
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        return building.getTotalSquareArea();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/floor-square-area/{buildingFilename}/{floorid}")
    public  ResponseEntity<Float> floorSquareArea(@PathVariable String buildingFilename, @PathVariable String floorid) {
        log.info("Counting Floor Area: " + floorid);
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        Float res = building.getFloorSquareArea(floorid);
        return ExceptionHandler.checkValue(res);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/room-square-area/{buildingFilename}/{roomid}")
    public ResponseEntity<Float> roomSquareArea(@PathVariable String buildingFilename, @PathVariable String roomid) {
        log.info("Counting Room Square Area: " + roomid);
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        Float res = building.getRoomSquareArea(roomid);
        return ExceptionHandler.checkValue(res);
    }


    @RequestMapping(method = RequestMethod.GET, path = "/total-cubic-area/{buildingFilename}")
    public float totalCubicArea(@PathVariable String buildingFilename) {
        log.info("Counting Total Cubic Area: " + buildingFilename);
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        return building.getTotalCubicArea();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/floor-cubic-area/{buildingFilename}/{floorid}")
    public ResponseEntity<Float> floorCubicArea(@PathVariable String buildingFilename, @PathVariable String floorid) {
        log.info("Counting Floor Cubic Area: " + floorid );
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        Float res = building.getFloorCubicArea(floorid);
        return ExceptionHandler.checkValue(res);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/room-cubic-area/{buildingFilename}/{roomid}")
    public ResponseEntity<Float> roomCubicArea(@PathVariable String buildingFilename, @PathVariable String roomid) {
        log.info("Counting Room Cubic Area: " + roomid);
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        Float res = building.getRoomCubicArea(roomid);
        return ExceptionHandler.checkValue(res);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/total-light/{buildingFilename}")
    public float totalLight(@PathVariable String buildingFilename) {
        log.info("Show Total Light in the building:" +buildingFilename);
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        return building.getTotalLight();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/floor-light/{buildingFilename}/{floorid}")
    public ResponseEntity<Float> floorLight(@PathVariable String buildingFilename, @PathVariable String floorid) {
        log.info("Show Floor Light in the building:" + floorid);
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        Float res = building.getFloorLight(floorid);
        return ExceptionHandler.checkValue(res);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/room-light/{buildingFilename}/{roomid}")
    public ResponseEntity<Float> roomLight(@PathVariable String buildingFilename, @PathVariable String roomid) {
        log.info("Show Room Light in the building:" + roomid);
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        Float res = building.getRoomLight(roomid);
        return ExceptionHandler.checkValue(res);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/total-heat/{buildingFilename}")
    public float totalHeat(@PathVariable String buildingFilename) {
        log.info("Show Total Heat in the building:" + buildingFilename);
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        return building.getTotalHeat();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/floor-heat/{buildingFilename}/{floorid}")
    public ResponseEntity<Float> floorHeat(@PathVariable String buildingFilename, @PathVariable String floorid) {
        log.info("Show Floor Heat in the building:" + floorid);
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        Float res = building.getFloorHeat(floorid);
        return ExceptionHandler.checkValue(res);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/room-heat/{buildingFilename}/{roomid}")
    public ResponseEntity<Float> roomHeat(@PathVariable String buildingFilename, @PathVariable String roomid) {
        log.info("Show Room Heat in the building: " + roomid);
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        Float res = building.getRoomHeat(roomid);
        return ExceptionHandler.checkValue(res);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/overheating-rooms/{buildingFilename}/{parameter}")
    public ArrayList<Room> roomHeat(@PathVariable String buildingFilename, @PathVariable float parameter) {
        log.info("Overheating Romms in building:" +buildingFilename);
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        return building.getOverheatingRooms(parameter);
    }

    @RequestMapping(value = "/createBuilding", method = RequestMethod.POST)
    public ResponseEntity<String> createBuilding(@RequestBody Building building) throws IOException {
        log.info("Creating new building" + building.getName());
        DataGenerator.handleCreatingBuildingFile(building);
        return new ResponseEntity<>("Stworzono!", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/createBuildingByName", method = RequestMethod.POST)
    public ResponseEntity<Building> createBuilding(@RequestBody String name) throws IOException {
        log.info("Creating Building by name:" + name);
        Building building = DataGenerator.generateBuilding(name);
        return new ResponseEntity<>(building, HttpStatus.CREATED);
    }
}
