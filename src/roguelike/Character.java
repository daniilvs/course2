package roguelike;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import com.google.gson.Gson;


public class Character {
    protected String name;
    protected int hp;
    protected int shield;
    protected int rate;
    protected String dice;
    protected Item[] inventory;
    private static final FileReader frEnemies;
    private static final FileReader frItems;

    static {
        try {
            frEnemies = new FileReader("src/roguelike/resources/enemies.json");
            frItems = new FileReader("src/roguelike/resources/items.json");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private static Gson g = new Gson();
    private static Character[] enemyArray = g.fromJson(frEnemies, Character[].class);
    private static Item[] itemArray = g.fromJson(frItems, Item[].class);

    public Character() {
    }

    public Character(String name, int hp, int shield, int rate, String dice) {
        this.name = name;
        this.hp = hp;
        this.shield = shield;
        this.rate = rate;
        this.dice = dice;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", shield=" + shield +
                ", rate=" + rate +
                ", dice='" + dice + '\'' +
                ", inventory=" + Arrays.toString(inventory) +
                '}';
    }

    static public Character createEnemy() {
        Character enemy = new Character() {};
        while (enemy.name == null) {
            int i = ThreadLocalRandom.current().nextInt(enemyArray.length);
            int rate = enemyArray[i].rate;
            if (Dice.dice(rate)) {
                enemy.name = enemyArray[i].name;
                enemy.hp = (enemyArray[i].hp + Dice.d4());
                enemy.shield = (enemyArray[i].shield + Dice.d4());
                enemy.dice = enemyArray[i].dice;
            }
        }
        enemy.fillWithLoot();
        return enemy;
    }


    private void fillWithLoot() {
        int size = Dice.d4();
        this.inventory = new Item[size];
        int index = 0;
        while (index < size) {
            int i = ThreadLocalRandom.current().nextInt(itemArray.length);
            int rate = itemArray[i].rate;
            if (Dice.dice(rate)) {
                this.inventory[index] = itemArray[i];
                index++;
            }
        }
    }

    public static void main(String[] args) {
        var res = createEnemy();
        System.out.println(res);
    }
}
