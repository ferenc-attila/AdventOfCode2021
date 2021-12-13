package twentytwentyone.day02;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class PositionsWithAimsTest {

    @Test
    void getMultipliedPositionsWithAimsTest() {
        PositionsWithAims positionsWithAims = new PositionsWithAims();
        Path path = Path.of("src/test/resources/02_postionsTest.txt");
        assertEquals(900, positionsWithAims.getMultipliedPositionsWithAims(path));
    }
}