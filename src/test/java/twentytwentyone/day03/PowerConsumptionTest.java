package twentytwentyone.day03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PowerConsumptionTest {

    PowerConsumption powerConsumption = new PowerConsumption();
    Path path = Path.of("src/test/resources/03_diagnostic.txt");

    @BeforeEach
    void init() {
        powerConsumption.readDiagnostic(path);
    }

    @Test
    void getGammaRateTest() {
        assertEquals("10110", powerConsumption.getGammaRate());
    }

    @Test
    void getEpsilonRateTest() {
        String gamma = powerConsumption.getGammaRate();
        assertEquals("01001", powerConsumption.getEpsilonRate(gamma));
    }

    @Test
    void getPowerConsumptionTest() {
        assertEquals(198, powerConsumption.getPowerConsumption());
    }
}