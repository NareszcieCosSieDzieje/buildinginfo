package pl.put.poznan.buildinginfo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.put.poznan.buildinginfo.logic.DataGenerator;

import java.io.IOException;

@SpringBootApplication(scanBasePackages = {"pl.put.poznan.buildinginfo.rest"})
public class BuildingInfoApplication {
	//private static Logger log = LoggerFactory.getLogger(BuildingInfoApplication.class);
	public static void main(String[] args) throws IOException {
		//log.info("Creating Spring Project");
		DataGenerator dataGenerator = new DataGenerator();
		for(int i=2;i<10;i++){
			String name = "dom" + i;
			dataGenerator.generateBuilding(name);
		}
		SpringApplication.run(BuildingInfoApplication.class, args);
	}
}


