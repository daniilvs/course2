package roguelike;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Location {

    protected File description;
    protected HashMap<String, Character> enemies = new HashMap<String, Character>();
    protected String[] loot;
    protected int[] doorsTo;
    protected int exit = 0;


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
            Character e = Character.createEnemy();
            enemies.put(e.name, e);
        }
    }
    public void addDescription(List<File> lst) {
        int range = lst.size();
        int i = ThreadLocalRandom.current().nextInt(range);
        description = lst.get(i);
        lst.remove(i);
    }
}
