package ex_3_2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;
import com.google.gson.Gson;


public class Character implements Actables{
    protected String name;
    protected int hp;
    protected int damage;
    protected int rate;
    protected Dice dice;
    protected int currentLocation = -1;
    protected int previousLocation;
    protected HashMap<String, Item> inventory = new HashMap<String, Item>();
    private static final FileReader frEnemies;
    private static final FileReader frItems;

    static {
        try {
            frEnemies = new FileReader("src/ex_3_2/resources/enemiesList.json");
            frItems = new FileReader("src/ex_3_2/resources/items.json");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private static Gson g = new Gson();
    private static Character[] enemyArray = g.fromJson(frEnemies, Character[].class);
    private static HashMap<String, Character> enemiesList = new HashMap<String, Character>();
    static {
        for (Character e : enemyArray) {
            enemiesList.put(e.name, e);
        }
    }

    private static Item[] itemArray = g.fromJson(frItems, Item[].class);
    private static HashMap<String, Item> itemsList = new HashMap<String, Item>();
    {
        for (Item i : itemArray) {
            itemsList.put(i.name, i);
        }
    }

    public Character() {}

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", damage=" + damage +
                ", rate=" + rate +
                ", dice='" + dice + '\'' +
                ", inventory=" + Arrays.toString(inventory.keySet().toArray()) +
                '}';
    }

    static public Character createEnemy() {
        Character enemy = new Character() {};
        while (enemy.name == null) {
            int i = ThreadLocalRandom.current().nextInt(enemyArray.length);
            int rate = enemyArray[i].rate;
            if (Dice.dice(rate)) {
                enemy.name = enemyArray[i].name;
                enemy.hp = (enemyArray[i].hp + Dice.D4.roll() + 1);
                enemy.dice = enemyArray[i].dice;
            }
        }
        enemy.fillWithLoot();
        return enemy;
    }


    private void fillWithLoot() {
        int size = Dice.D4.roll();
        int index = 0;
        while (index < size) {
            int i = ThreadLocalRandom.current().nextInt(itemArray.length);
            int rate = itemArray[i].rate;
            if (Dice.dice(rate)) {
                this.inventory.put(itemArray[i].name, itemArray[i]);
                index++;
            }
        }
    }

    static public Character createMainCharacter() {
        Character mc = new Character();
        mc.hp = 10 + Dice.D6.roll() + 1;
//        Dice.valueOf("D4");
        mc.dice = Dice.D6;
        return mc;
    }

//    public void useItem(String name) throws Exception {
//        Item item = inventory.get(name);
//        if (item.quantity > 1) {
//            item.quantity--;
//        } else {
//            inventory.remove(name);
//        }
//        String diceClassName = "roguelike.Dice";
//        Class<?> diceClass = Class.forName(diceClassName);
//        Object roll = diceClass.newInstance();
//        String method = item.dice;
//        Method rollTheDice = roll.getClass().getMethod(method, String.class);
//        int number = (int) rollTheDice.invoke(roll) + 1;
//        damage += (item.dmgBuff + number);
//        hp += (item.hpBuff + number);
//    }

//    public int attack(Character opponent) throws Exception {
//        String diceClassName = "roguelike.Dice";
//        Class<?> diceClass = Class.forName(diceClassName);
//        Object roll = diceClass.newInstance();
//        Dice method = dice;
//        Method rollTheDice = roll.getClass().getMethod(method, String.class);
//        int number = (int) rollTheDice.invoke(roll);
//        if (number == 0) {
//            return 0;
//        }
//        int dmg = damage + number + 1;
//        opponent.hp -= dmg;
//        return dmg;
//    }

    public void move(int dest) {
        previousLocation = currentLocation;
        currentLocation = dest;
    }

    public void loot(Character opponent) {
        opponent.inventory.forEach((name, item) -> {
            if (inventory.containsKey(name)) {
                inventory.get(name).quantity++;
            } else {
                inventory.put(name, item);
            }
        });
        Item item = opponent.inventory.get(name);
        opponent.inventory.remove(name);
        inventory.put(name, item);
    }

    public boolean isDead() {
        return hp < 1;
    }

    public void twentySeven() {
        hp = 0;
    }

    public static void main(String[] args) {
        var res = createEnemy();
        System.out.println(res);
    }
}
