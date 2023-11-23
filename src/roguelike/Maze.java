package roguelike;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class Maze {
    private Location[] rooms;
    private List<File> descriptions;
    {
        File dir = new File("src/roguelike/resources/descriptions");
        File[] arrFiles = dir.listFiles();
        assert arrFiles != null;
        descriptions = Arrays.asList(arrFiles);
    }
    private int start = 0;
    private int portal = 0;
    protected Character mc;

    public void buildMaze(int quantity) {
        rooms = new Location[quantity];
        for (int i = 0; i < quantity; i++) {
            rooms[i] = new Location(quantity);
        }
//        int[][] matrix = new int[quantity][quantity];
//        for (int i = 0; i < quantity; i++) {
//            for (int j = 0; j < quantity; j++) {
//                if (i == j) {
//                    matrix[i][j] = -1;
//                } else if ((rand.nextInt() % 2) == 0) {
//                    matrix[i][j] = 1;
//                    matrix[j][i] = 1;
//                } else {
//                    matrix[i][j] = 0;
//                    matrix[j][i] = 0;
//                }
//            }
//        }
        for (int i = 0; i < quantity; i++) {
            for (int j = 0; j < quantity; j++) {
                if ((i != j) & ((ThreadLocalRandom.current().nextInt(2)) == 0)) {
                    rooms[i].doorsTo[j] = j + 1;
                    rooms[j].doorsTo[i] = i + 1;
                }
            }
        }
        for (Location room : rooms) {
            room.fillWithEnemies();
            room.addDescription(descriptions);
        }

        start = ThreadLocalRandom.current().nextInt(rooms.length);
        portal = ThreadLocalRandom.current().nextInt(rooms.length);
        while (portal == start) {
            portal = ThreadLocalRandom.current().nextInt(rooms.length);
        }
        rooms[portal].exit = 1;
        mc = Character.createMainCharacter();
        mc.currentLocation = start;
    }


}

