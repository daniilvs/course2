package roguelike;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Location {
    private List<File> descriptions;
    {
        File dir = new File("src/roguelike/resources/descriptions");
        File[] arrFiles = dir.listFiles();
        assert arrFiles != null;
        descriptions = Arrays.asList(arrFiles);
    }
    File description;
    ArrayList<Character> enemies = new ArrayList<Character>();
    String[] loot;
    int[] doorsTo;

    public Location(int quantity) {
        this.doorsTo = new int[quantity];
    }

    @Override
    public String toString() {
        return "Location{" +
                "doorsTo=" + Arrays.toString(doorsTo) +
                '}';
    }
    public void fillWithEnemies() {
        int i = ThreadLocalRandom.current().nextInt(3);
        for (; i > 0; i--) {
            this.enemies.add(Character.createEnemy());
        }
    }
}
