package twentytwentyone.day02;

import utilities.ReadTextFile;

import java.nio.file.Path;
import java.util.List;

public class PositionsWithAims {

    private ReadTextFile readTextFile = new ReadTextFile();

    public int getMultipliedPositionsWithAims(Path path) {
        int verticalPosition = 0;
        int horizontalPosition = 0;
        int aim = 0;
        List<String> moves = readTextFile.readTextFile(path);
        for (int i = 0; i < moves.size(); i++) {
            if (moves.get(i).startsWith("forward")) {
                horizontalPosition += Integer.parseInt(moves.get(i).split(" ")[1]);
                verticalPosition += aim * Integer.parseInt(moves.get(i).split(" ")[1]);
            }
            if (moves.get(i).startsWith("down")) {
                aim += Integer.parseInt(moves.get(i).split(" ")[1]);
            }
            if (moves.get(i).startsWith("up")) {
                aim -= Integer.parseInt(moves.get(i).split(" ")[1]);
            }
        }
        return verticalPosition * horizontalPosition;
    }

    public static void main(String[] args) {
        PositionsWithAims positionsWithAims = new PositionsWithAims();
        Path path = Path.of("src/main/resources/02_positions.txt");
        System.out.println(positionsWithAims.getMultipliedPositionsWithAims(path));
    }
}
