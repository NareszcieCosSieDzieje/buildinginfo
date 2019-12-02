package pl.put.poznan.buildinginfo.rest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pl.put.poznan.buildinginfo.logic.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
public class BuildingInfoController {
        @RequestMapping(method = RequestMethod.GET, path = "/total-square-area/{buildingFilename}")
    public float totalSquareArea(@PathVariable String buildingFilename) {
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        return building.getTotalSquareArea();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/floor-square-area/{buildingFilename}/{floorid}")
    public float floorSquareArea(@PathVariable String buildingFilename, @PathVariable String floorid) {
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        return building.getFloorSquareArea(floorid);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/room-square-area/{buildingFilename}/{roomid}")
    public float roomSquareArea(@PathVariable String buildingFilename, @PathVariable String roomid) {
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        return building.getRoomSquareArea(roomid);
    }


    @RequestMapping(method = RequestMethod.GET, path = "/total-cubic-area/{buildingFilename}")
    public float totalCubicArea(@PathVariable String buildingFilename) {
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        return building.getTotalCubicArea();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/floor-cubic-area/{buildingFilename}/{floorid}")
    public float floorCubicArea(@PathVariable String buildingFilename, @PathVariable String floorid) {
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        return building.getFloorCubicArea(floorid);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/room-cubic-area/{buildingFilename}/{roomid}")
    public float roomCubicArea(@PathVariable String buildingFilename, @PathVariable String roomid) {
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        return building.getRoomCubicArea(roomid);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/total-light/{buildingFilename}")
    public float totalLight(@PathVariable String buildingFilename) {
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        return building.getTotalLight();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/floor-light/{buildingFilename}/{floorid}")
    public float floorLight(@PathVariable String buildingFilename, @PathVariable String floorid) {
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        return building.getFloorLight(floorid);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/room-light/{buildingFilename}/{roomid}")
    public float roomLight(@PathVariable String buildingFilename, @PathVariable String roomid) {
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        return building.getRoomLight(roomid);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/total-heat/{buildingFilename}")
    public float totalHeat(@PathVariable String buildingFilename) {
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        return building.getTotalHeat();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/floor-heat/{buildingFilename}/{floorid}")
    public float floorHeat(@PathVariable String buildingFilename, @PathVariable String floorid) {
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        return building.getFloorHeat(floorid);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/room-heat/{buildingFilename}/{roomid}")
    public float roomHeat(@PathVariable String buildingFilename, @PathVariable String roomid) {
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        return building.getRoomHeat(roomid);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/overheating-rooms/{buildingFilename}/{parameter}")
    public ArrayList<Room> roomHeat(@PathVariable String buildingFilename, @PathVariable float parameter) {
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        return building.getOverheatingRooms(parameter);
    }

    @RequestMapping(value = "/createBuilding", method = RequestMethod.POST)
    public ResponseEntity<String> createBuilding(@RequestBody Building building) throws IOException {
        DataGenerator.handleCreatingBuildingFile(building);
        return new ResponseEntity<>("Stworzono!", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/createBuildingByName", method = RequestMethod.POST)
    public ResponseEntity<Building> createBuilding(@RequestBody String name) throws IOException {
        Building building = DataGenerator.generateBuilding(name);
        return new ResponseEntity<>(building, HttpStatus.CREATED);
    }
}
