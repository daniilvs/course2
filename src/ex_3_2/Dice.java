package ex_3_2;

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
}
