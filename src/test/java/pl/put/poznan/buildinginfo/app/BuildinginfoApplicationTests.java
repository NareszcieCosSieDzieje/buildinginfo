package pl.put.poznan.buildinginfo.app;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert.*;
import pl.put.poznan.buildinginfo.logic.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class BuildinginfoApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	void checkFloorArea(){
		Room room = new Room();
		room.setArea(30.0f);
		Floor floor = new Floor("testowy");
		List<Room> rooms = new ArrayList<>();
		for(int i = 0; i < 5; i++) rooms.add(room);
		floor.setRoomArrayList((ArrayList<Room>) rooms);
		Assert.assertEquals(floor.getSquareArea(),150.0f,0.1);
	}
	@Test
	void checkFloorCube(){
		Room room = new Room();
		room.setCube(40.0f);
		Floor floor = new Floor("testowy");
		List<Room> rooms = new ArrayList<>();
		for(int i = 0; i < 5; i++) rooms.add(room);
		floor.setRoomArrayList((ArrayList<Room>) rooms);
		Assert.assertEquals(floor.getCubicArea(),200.0f,0.1);
	}
	@Test
	void generatinData() throws IOException {
		//sprawdzanie czy generuje dobrze dane
		DataGenerator dataGenerator = new DataGenerator();
		Building building = dataGenerator.generateBuilding("testowy");
		Assert.assertNotNull(building.getFloorArrayList());
	}
	@Test
	void generatingFile(){
		//sprawdzanie, czy dobrze sprawdza ścieżki dostępu do plików
		String building = new ReadBuildingFile().toString("dom1");
		Assert.assertNotNull(building);
	}


}
