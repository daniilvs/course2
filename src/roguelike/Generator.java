package roguelike;

import java.util.Arrays;
import java.util.Random;

public class Generator {
    int portal = 0;
    public void createMaze(int quantity) {
        Location[] rooms = new Location(quantity)[quantity];
        int[][] matrix = new int[quantity][quantity];
        Random rand = new Random();
        for (int i = 0; i < quantity; i++) {
            for (int j = 0; j < quantity; j++) {
                if (i == j) {
                    matrix[i][j] = -1;
                } else if ((rand.nextInt() % 2) == 0) {
                    matrix[i][j] = 1;
                    matrix[j][i] = 1;
                } else {
                    matrix[i][j] = 0;
                    matrix[j][i] = 0;
                }
            }
        }

        for (int i = 0; i < quantity; i++) {
            for (int j = 0; j < quantity; j++) {
                if ((i != j) & ((rand.nextInt() % 2) == 0)) {
                    rooms[i]
                }

            }
        }

    }

    public void createEnemies() {

    }
}
