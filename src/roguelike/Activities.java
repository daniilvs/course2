package roguelike;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Activities {
    static public void enter(Location room) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fin = new BufferedReader(new FileReader(room.description));
        String line;
        while ((line = fin.readLine()) != null) System.out.println(line);

    }

    static public void lookForDoors(Location room) {

    }

    static public int lookForEnemies(Location room) {
        int res;
        if (room.enemies.size() > 1) {
            res = (room.enemies.containsKey("Мимик")) ? 2 : 1;
        } else {
            res = (room.enemies.containsKey("Мимик")) ? 3 : 0;
        }
//        0 - none
//        1 - no mimik
//        2 - with mimik
//        3 - only mimik
        return res;
    }


    static public boolean sneak() {
        return Dice.d4() == Dice.d4();
    }

    static public void fight(Character mc, Character opponent) throws Exception {
        while (true) {
            int myHit = mc.attack(opponent);
            if (myHit == 0) {
                System.out.println("Вы промахнулись!");
            } else {
                System.out.printf("Вы нанесли противнику [%s] [%d]урона\n", opponent.name, myHit);
            }
            if (opponent.hp < 1) {
                System.out.printf("Вы победили [%s]\n", opponent.name);
            }
//          КАК ДОБАВИЬТ СЮДА ТАЙМАУТ БЕЗ КОНКУРЕНТНОСТИ
        }
    }


    static public void changeRoom(Character mc, Location room) {
        String res;
        int back = mc.previousLocation;
        int[] ways = new int[room.doorsTo.length - 1];
        int index = 0;
        for (int w : room.doorsTo) {
            if (w != back) {
                ways[index] = w;
                index++;
            }
        }
        if (ways.length > 0) {
            Arrays.sort(ways);
            System.out.printf("Перед вами есть несколько дверей, если точнее - %d. Какую выберите? (номер двери)\n", ways.length);
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            if (choice > 0 & choice < ways.length) {
                mc.move(ways[choice - 1]);
            } else {
                System.out.println("Подумай еще");
            }
        } else {
            System.out.println("Перед вами тупик. Вернуться назад? (да/нет)");

        }
    }

}
