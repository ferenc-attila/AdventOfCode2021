package firstday;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MeasurementTest {

    @Test
    void countIncreasesTest() {
        Measurement measurement = new Measurement();

        assertEquals(7, measurement.countIncreases(Path.of("src/test/resources/measurementTest.txt")));
        assertEquals(5, measurement.countIncreasesSumOfThree(Path.of("src/test/resources/measurementTest.txt")));
    }
}