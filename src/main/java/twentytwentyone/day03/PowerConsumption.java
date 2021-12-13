package twentytwentyone.day03;

import utilities.ReadTextFile;

import java.nio.file.Path;
import java.util.List;

public class PowerConsumption {

    private List<String> diagnostic;
    private ReadTextFile readTextFile = new ReadTextFile();

    public static void main(String[] args) {
        PowerConsumption powerConsumption = new PowerConsumption();
        powerConsumption.readDiagnostic(Path.of("src/main/resources/03_diagnosticReport.txt"));
        System.out.println(powerConsumption.getPowerConsumption());
    }

    public int getPowerConsumption() {
        return (Integer.parseInt(getGammaRate(), 2)) * (Integer.parseInt(getEpsilonRate(getGammaRate()),2));
    }

    public String getEpsilonRate (String gamma) {
        StringBuilder epsilon = new StringBuilder();
        for (char c : gamma.toCharArray()) {
            if (c == '0') {
                epsilon.append('1');
            } else {
                epsilon.append('0');
            }
        }
        return epsilon.toString();
    }

    public String getGammaRate () {
        StringBuilder binaryGamma = new StringBuilder();
        for (int i = 0; i < diagnostic.get(0).length(); i++) {
            binaryGamma.append(getBitOfGamma(i));
        }
        return binaryGamma.toString();
    }

    public char getBitOfGamma (int index) {
        int numberOfZero = 0;
        int numberOfOne = 0;
        for (String actual : diagnostic) {
            if (actual.charAt(index) == '0') {
                numberOfZero++;
            } else if (actual.charAt(index) == '1') {
                numberOfOne++;
            }
        }
        if (numberOfOne > numberOfZero) {
            return '1';
        } else {
            return '0';
        }
    }

    public void readDiagnostic (Path path) {
        diagnostic = readTextFile.readTextFile(path);
    }
}
