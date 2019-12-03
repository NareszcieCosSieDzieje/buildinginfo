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

/**
 * Klasa obsługująca Controller dla Resta
 */
@RestController
public class BuildingInfoController {
    private Logger log = LoggerFactory.getLogger(BuildingInfoController.class);


    /**
     * klasa wewnętrzna sprawdzająca poprawność danych podanych.
     */
    static class ExceptionHandler{

        /**
         * funkcja sprawdza, czy dane podane na wejściu są poprawne, jeżeli tak daje odpowiedź serwerowi, ze tak, jeżeli nie,
         * daje odpowiedź o nieznalezieniu danych i zwraca status NOT_FOUND.
         * @param value wartość sprawdzana
         * @return HttpStatus
         *
         */
        public static ResponseEntity<Float> checkValue(Float value){
            if (value == -1){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else{
                return new ResponseEntity<>(value, HttpStatus.OK);
            }
        }
    }

    /**
     * Funkcja zwraca dla budynku o nazwie podanej w parametrze, pole powierzchni.
     * @param buildingFilename nazwa pliku w którym znajdują się dane o budynku
     * @return buildingSquareArea
     *
     */

    @RequestMapping(method = RequestMethod.GET, path = "/total-square-area/{buildingFilename}")
    public float totalSquareArea(@PathVariable String buildingFilename) {
        log.info("Counting Total Square Area " + buildingFilename);
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        return building.getTotalSquareArea();
    }

    /**
     *Funkcja zwraca dla budynku o nazwie podanej w parametrze i piętra o danym id pole powierzchni piętra.
     * @param buildingFilename nazwa pliku w którym znajdują się dane o budynku
     * @param floorid id sprawdzanego obiektu
     * @return floorSquareArea
     *
     */
    @RequestMapping(method = RequestMethod.GET, path = "/floor-square-area/{buildingFilename}/{floorid}")
    public  ResponseEntity<Float> floorSquareArea(@PathVariable String buildingFilename, @PathVariable String floorid) {
        log.info("Counting Floor Area: " + floorid);
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        Float res = building.getFloorSquareArea(floorid);
        return ExceptionHandler.checkValue(res);
    }

    /**
     *Funkcja zwraca dla budynku o nazwie podanej w parametrze i pokoju o danym id pole powierzchni pokoju.
     * @param buildingFilename nazwa pliku w którym znajdują się dane o budynku
     * @param roomid id sprawdzanego obiektu
     * @return roomSquareArea
     *
     */
    @RequestMapping(method = RequestMethod.GET, path = "/room-square-area/{buildingFilename}/{roomid}")
    public ResponseEntity<Float> roomSquareArea(@PathVariable String buildingFilename, @PathVariable String roomid) {
        log.info("Counting Room Square Area: " + roomid);
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        Float res = building.getRoomSquareArea(roomid);
        return ExceptionHandler.checkValue(res);
    }

    /**
     *Funkcja zwraca dla budynku o nazwie podanej w parametrze, kubaturę budynku.
     * @param buildingFilename nazwa pliku w którym znajdują się dane o budynku
     * @return buildingCubicArea
     *
     */
    @RequestMapping(method = RequestMethod.GET, path = "/total-cubic-area/{buildingFilename}")
    public float totalCubicArea(@PathVariable String buildingFilename) {
        log.info("Counting Total Cubic Area: " + buildingFilename);
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        return building.getTotalCubicArea();
    }

    /**
     * Funkcja zwraca dla budynku o nazwie podanej w parametrze i piętra o danym id kubaturę piętra.
     * @param buildingFilename nazwa pliku w którym znajdują się dane o budynku
     * @param floorid id sprawdzanego obiektu
     * @return floorCubicArea
     *
     */
    @RequestMapping(method = RequestMethod.GET, path = "/floor-cubic-area/{buildingFilename}/{floorid}")
    public ResponseEntity<Float> floorCubicArea(@PathVariable String buildingFilename, @PathVariable String floorid) {
        log.info("Counting Floor Cubic Area: " + floorid );
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        Float res = building.getFloorCubicArea(floorid);
        return ExceptionHandler.checkValue(res);
    }

    /**
     * Funkcja zwraca dla budynku o nazwie podanej w parametrze i pokoju o danym id kubaturę pokoju.
     * @param buildingFilename nazwa pliku w którym znajdują się dane o budynku
     * @param roomid id sprawdzanego obiektu
     * @return roomCubicArea
     *
     */
    @RequestMapping(method = RequestMethod.GET, path = "/room-cubic-area/{buildingFilename}/{roomid}")
    public ResponseEntity<Float> roomCubicArea(@PathVariable String buildingFilename, @PathVariable String roomid) {
        log.info("Counting Room Cubic Area: " + roomid);
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        Float res = building.getRoomCubicArea(roomid);
        return ExceptionHandler.checkValue(res);
    }

    /**
     *  Funkcja która oblicza i zwraca oświetlenie dla całego budynku o nazwie podanej w parametrze
     * @param buildingFilename nazwa pliku w którym znajdują się dane o budynku
     * @return zwracanie oswietlenia budynku
     *
     */
    @RequestMapping(method = RequestMethod.GET, path = "/total-light/{buildingFilename}")
    public float totalLight(@PathVariable String buildingFilename) {
        log.info("Show Total Light in the building:" +buildingFilename);
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        return building.getTotalLight();
    }

    /**
     *  Funkcja zwracająca oświetlenie łączne dla całego piętra o podanym ID w budynku o nazwie podanej w parametrze
     * @param buildingFilename nazwa pliku w którym znajdują się dane o budynku
     * @param floorid id sprawdzanego obiektu
     * @return oświetlenie łączne piętra
     *
     */
    @RequestMapping(method = RequestMethod.GET, path = "/floor-light/{buildingFilename}/{floorid}")
    public ResponseEntity<Float> floorLight(@PathVariable String buildingFilename, @PathVariable String floorid) {
        log.info("Show Floor Light in the building:" + floorid);
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        Float res = building.getFloorLight(floorid);
        return ExceptionHandler.checkValue(res);
    }

    /**
     * Zwracanie poziomu oświetlenia pokoju o id przekazaym w parametrze w budynku o nazwie buildingFileName
     * @param buildingFilename nazwa pliku w którym znajdują się dane o budynku
     * @param roomid id sprawdzanego obiektu
     * @return oświetlenie pokoju
     *
     */
    @RequestMapping(method = RequestMethod.GET, path = "/room-light/{buildingFilename}/{roomid}")
    public ResponseEntity<Float> roomLight(@PathVariable String buildingFilename, @PathVariable String roomid) {
        log.info("Show Room Light in the building:" + roomid);
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        Float res = building.getRoomLight(roomid);
        return ExceptionHandler.checkValue(res);
    }

    /**
     *  Funkcja podaje i zwraca poziom ogólny ogrzania budynku podanego w parametrze
     * @param buildingFilename nazwa pliku w którym znajdują się dane o budynku
     * @return Poziom ogrzania budynku
     *
     */
    @RequestMapping(method = RequestMethod.GET, path = "/total-heat/{buildingFilename}")
    public float totalHeat(@PathVariable String buildingFilename) {
        log.info("Show Total Heat in the building:" + buildingFilename);
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        return building.getTotalHeat();
    }

    /**
     * funkcja oblicza poziom ogrzania całego piętra o danym ID, które znajduje się w Budynku o danej nazwie
     * @param buildingFilename nazwa pliku w którym znajdują się dane o budynku
     * @param floorid id sprawdzanego obiektu
     * @return poziom ogrzania piętra
     *
     */
    @RequestMapping(method = RequestMethod.GET, path = "/floor-heat/{buildingFilename}/{floorid}")
    public ResponseEntity<Float> floorHeat(@PathVariable String buildingFilename, @PathVariable String floorid) {
        log.info("Show Floor Heat in the building:" + floorid);
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        Float res = building.getFloorHeat(floorid);
        return ExceptionHandler.checkValue(res);
    }

    /**
     *  Sprawdzanie poziomu ogrzania pokoju, parametrami funkcji są nazwa budynku oraz id pokoju.
     * @param buildingFilename nazwa pliku w którym znajdują się dane o budynku
     * @param roomid id sprawdzanego obiektu
     * @return poziom ogrzania pokoju
     *
     */
    @RequestMapping(method = RequestMethod.GET, path = "/room-heat/{buildingFilename}/{roomid}")
    public ResponseEntity<Float> roomHeat(@PathVariable String buildingFilename, @PathVariable String roomid) {
        log.info("Show Room Heat in the building: " + roomid);
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        Float res = building.getRoomHeat(roomid);
        return ExceptionHandler.checkValue(res);
    }

    /**
     * Sprawdzanie po nazwie budynku, ilości pokoi, które są przegrzane, za pomocą parametru, który podawany jest na wejściu.
     * @param buildingFilename nazwa pliku w którym znajdują się dane o budynku
     * @param parameter wartość, ktora oznacza poziom przegrzania pokoju
     * @return lista przegrzanych pokoi
     *
     */
    @RequestMapping(method = RequestMethod.GET, path = "/overheating-rooms/{buildingFilename}/{parameter}")
    public ArrayList<Room> roomHeat(@PathVariable String buildingFilename, @PathVariable float parameter) {
        log.info("Overheating Romms in building:" +buildingFilename);
        String buildingString = new ReadBuildingFile().toString(buildingFilename);
        Building building = JSONparser.getObject(buildingString);
        return building.getOverheatingRooms(parameter);
    }

    /**
     * Tworzenie budynku bez parametrów, po stworzeniu budynku zwracany jest status HTTPStatus.Created.
     * @param building budynek
     * @return HttpStatus
     * @throws IOException
     *
     */
    @RequestMapping(value = "/createBuilding", method = RequestMethod.POST)
    public ResponseEntity<String> createBuilding(@RequestBody Building building) throws IOException {
        log.info("Creating new building" + building.getName());
        DataGenerator.handleCreatingBuildingFile(building);
        return new ResponseEntity<>("Stworzono!", HttpStatus.CREATED);
    }

    /**
     *  Tworzenie budynku z paramentrem nazwy budynku, jeżeli wszystko się powiedzie zwraca status CREATED.
     * @param name nazwa budynku
     * @return building, HTTPStatus
     * @throws IOException
     *
     */
    @RequestMapping(value = "/createBuildingByName", method = RequestMethod.POST)
    public ResponseEntity<Building> createBuilding(@RequestBody String name) throws IOException {
        log.info("Creating Building by name:" + name);
        Building building = DataGenerator.generateBuilding(name);
        return new ResponseEntity<>(building, HttpStatus.CREATED);
    }
}
