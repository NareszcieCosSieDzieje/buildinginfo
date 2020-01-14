package pl.put.poznan.buildinginfo.app;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import pl.put.poznan.buildinginfo.logic.Room;

import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class MockTests {


    @Test
    void MockTests(){
        //sprawdzenie, czy wywołana metoda podała dobre wartości.
        Room room = mock(Room.class);
        room.setCube(30.0f);
        float cube = 30.0f;
        Mockito.verify(room).setCube(cube);
    }
}
