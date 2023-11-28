package roguelike;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public enum Dice {
    D4(4), D6(6), D8(8), D12(12), D16(16);
    public static final Random RANDOM = new Random();
    public final int bound;

    Dice(int bound) {
        this.bound = bound;
    }

    public int roll() {
        return RANDOM.nextInt(bound) + 1;
        
    }

    @org.jetbrains.annotations.NotNull
    static public Boolean dice(int rate) {
        return rate > ThreadLocalRandom.current().nextInt(rate + 1);
    }

    static public int d4() {
        return ThreadLocalRandom.current().nextInt(4+1);
    }

    static public int d6() {
        return ThreadLocalRandom.current().nextInt(6+1);
    }

    static public int d8() {
        return ThreadLocalRandom.current().nextInt(8+1);
    }

    static public int d12() {
        return ThreadLocalRandom.current().nextInt(12+1);
    }

    static public int d16() {
        return ThreadLocalRandom.current().nextInt(16+1);
    }

}
