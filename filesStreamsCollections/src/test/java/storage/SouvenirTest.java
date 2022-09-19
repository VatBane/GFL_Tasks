package storage;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public class SouvenirTest {
    @Test
    void getSouvenirsTest() throws IOException, ParseException {
        Storage.getSouvenirs();
    }
}
