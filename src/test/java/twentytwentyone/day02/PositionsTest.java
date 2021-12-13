package twentytwentyone.day02;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class PositionsTest {

    @Test
    void getMultipliedPositionsTest() {
        Positions positions = new Positions();
        Path path = Path.of("src/test/resources/02_postionsTest.txt");
        assertEquals(150, positions.getMultipliedPositions(path));
    }
}