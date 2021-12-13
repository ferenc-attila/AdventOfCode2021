package twentytwentyone.day02;

import utilities.ReadTextFile;

import java.nio.file.Path;
import java.util.List;

public class Positions {

    private ReadTextFile readTextFile = new ReadTextFile();

    public int getMultipliedPositions(Path path) {
        int verticalPosition = 0;
        int horizontalPosition = 0;
        List<String> moves = readTextFile.readTextFile(path);
        for (String move : moves) {
            if (move.startsWith("forward")) {
                horizontalPosition += Integer.parseInt(move.split(" ")[1]);
            }
            if (move.startsWith("down")) {
                verticalPosition += Integer.parseInt(move.split(" ")[1]);
            }
            if (move.startsWith("up")) {
                verticalPosition -= Integer.parseInt(move.split(" ")[1]);
            }
        }
        return verticalPosition * horizontalPosition;
    }

    public static void main(String[] args) {
        Positions positions = new Positions();
        Path path = Path.of("src/main/resources/02_positions.txt");
        System.out.println(positions.getMultipliedPositions(path));
    }
}
