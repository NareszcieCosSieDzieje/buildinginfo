package pl.put.poznan.buildinginfo.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BuildingInfoController {
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }


    /*
    @RequestMapping("/getTotalSquareArea", method=GET)

    @RequestMapping("/getRoomSquareArea", method=GET)
    @RequestMapping("/getRoomCubicArea", method=GET)
    @RequestMapping("/getFloorSquareArea", method=GET)
    @RequestMapping("/getFloorCubicArea", method=GET)
    @RequestMapping("/getFloorLightPerSquareArea", method=GET)
    @RequestMapping("/getFloorHeatPerCubicArea", method=GET)
    @RequestMapping("/getOverheatingRooms", method=GET)


    */


}
