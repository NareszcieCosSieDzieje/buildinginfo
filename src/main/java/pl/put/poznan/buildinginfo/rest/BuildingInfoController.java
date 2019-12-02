package pl.put.poznan.buildinginfo.rest;

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


@RestController
public class BuildingInfoController {

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
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        return building.getTotalSquareArea();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/floor-square-area/{buildingFilename}/{floorid}")
    public  ResponseEntity<Float> floorSquareArea(@PathVariable String buildingFilename, @PathVariable String floorid) {
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        Float res = building.getFloorSquareArea(floorid);
        return ExceptionHandler.checkValue(res);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/room-square-area/{buildingFilename}/{roomid}")
    public ResponseEntity<Float> roomSquareArea(@PathVariable String buildingFilename, @PathVariable String roomid) {
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        Float res = building.getRoomSquareArea(roomid);
        return ExceptionHandler.checkValue(res);
    }


    @RequestMapping(method = RequestMethod.GET, path = "/total-cubic-area/{buildingFilename}")
    public float totalCubicArea(@PathVariable String buildingFilename) {
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        return building.getTotalCubicArea();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/floor-cubic-area/{buildingFilename}/{floorid}")
    public ResponseEntity<Float> floorCubicArea(@PathVariable String buildingFilename, @PathVariable String floorid) {
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        Float res = building.getFloorCubicArea(floorid);
        return ExceptionHandler.checkValue(res);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/room-cubic-area/{buildingFilename}/{roomid}")
    public ResponseEntity<Float> roomCubicArea(@PathVariable String buildingFilename, @PathVariable String roomid) {
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        Float res = building.getRoomCubicArea(roomid);
        return ExceptionHandler.checkValue(res);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/total-light/{buildingFilename}")
    public float totalLight(@PathVariable String buildingFilename) {
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        return building.getTotalLight();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/floor-light/{buildingFilename}/{floorid}")
    public ResponseEntity<Float> floorLight(@PathVariable String buildingFilename, @PathVariable String floorid) {
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        Float res = building.getFloorLight(floorid);
        return ExceptionHandler.checkValue(res);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/room-light/{buildingFilename}/{roomid}")
    public ResponseEntity<Float> roomLight(@PathVariable String buildingFilename, @PathVariable String roomid) {
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        Float res = building.getRoomLight(roomid);
        return ExceptionHandler.checkValue(res);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/total-heat/{buildingFilename}")
    public float totalHeat(@PathVariable String buildingFilename) {
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        return building.getTotalHeat();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/floor-heat/{buildingFilename}/{floorid}")
    public ResponseEntity<Float> floorHeat(@PathVariable String buildingFilename, @PathVariable String floorid) {
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        Float res = building.getFloorHeat(floorid);
        return ExceptionHandler.checkValue(res);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/room-heat/{buildingFilename}/{roomid}")
    public ResponseEntity<Float> roomHeat(@PathVariable String buildingFilename, @PathVariable String roomid) {
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        Float res = building.getRoomHeat(roomid);
        return ExceptionHandler.checkValue(res);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/overheating-rooms/{buildingFilename}/{parameter}")
    public ArrayList<Room> roomHeat(@PathVariable String buildingFilename, @PathVariable float parameter) {
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        return building.getOverheatingRooms(parameter);
    }

    /*
    @RequestMapping(value = "/add_building", method = RequestMethod.POST)
    public ResponseEntity<List<Building>> addBuilding(@RequestBody List<Building> buildings) {
        //wez json liste budynkow sprawdz czy okej dane/ dodaj id?? i to co ok to zapisz a to co nie to zwroc

        return new ResponseEntity<List<Car>>(cars, HttpStatus.OK);
    }*/
}
        //puty zwracaja dane pokazujac jakie id maja rzeczy
