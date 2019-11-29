package pl.put.poznan.buildinginfo.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BuildingInfoApplication {
	private static Logger log = LoggerFactory.getLogger(BuildingInfoApplication.class);
	public static void main(String[] args) {
		log.info("Creating Spring Project");
		SpringApplication.run(BuildingInfoApplication.class, args);
	}

}


