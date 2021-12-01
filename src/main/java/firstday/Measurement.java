package firstday;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Measurement {

    public static void main(String[] args) {
        Measurement measurement = new Measurement();
        System.out.println(measurement.countIncreases(Path.of("src/main/resources/measurements.txt")));
        System.out.println(measurement.countIncreasesSumOfThree(Path.of("src/main/resources/measurements.txt")));
    }

    public int countIncreases(Path path) {
        List<String> contentOfFile = readTextFile(path);
        List<Integer> measurements = createMeasurementsList(contentOfFile);
        int count = 0;
        for (int i = 1; i < measurements.size(); i++) {
            if (measurements.get(i) > measurements.get(i - 1)) {
                count++;
            }
        }
        return count;
    }

    public int countIncreasesSumOfThree(Path path) {
        List<String> contentOfFile = readTextFile(path);
        List<Integer> measurements = createMeasurementsList(contentOfFile);
        int count = 0;
        for (int i = 2; i < measurements.size() - 1; i++) {
            if ((measurements.get(i - 1) + measurements.get(i) + measurements.get(i + 1)) > (measurements.get(i) + measurements.get(i - 1) + measurements.get(i - 2))) {
                count++;
            }
        }
        return count;
    }

    private List<String> readTextFile(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("Unable to read file!", ioe);
        }
    }

    private List<Integer> createMeasurementsList(List<String> stringListOfIntegers) {
        List<Integer> measurements = new ArrayList<>();
        for (String row : stringListOfIntegers) {
            measurements.add(Integer.parseInt(row));
        }
        return measurements;
    }
}
