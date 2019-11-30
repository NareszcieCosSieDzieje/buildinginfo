package pl.put.poznan.buildinginfo.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.put.poznan.buildinginfo.logic.Building;
import pl.put.poznan.buildinginfo.logic.JSONparser;
import pl.put.poznan.buildinginfo.logic.ReadBuildingFile;


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



}
