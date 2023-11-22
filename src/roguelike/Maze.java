package roguelike;

import java.util.concurrent.ThreadLocalRandom;


public class Maze {
    private Location[] rooms;
    private int start = 0;
    private int portal = 0;
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
                }
            }
        }
        for (Location room : rooms) {
            room.fillWithEnemies();
        }
    }





}

