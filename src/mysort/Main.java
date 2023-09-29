package mysort;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Main {

//    private final Map<Integer, Integer> NUMBER_OF_ITERS = new HashMap<Integer, Integer>() {{
//        put(100, 1000);
//        put(1000, 100);
//        put(10000, 100);
//        put(100000, 100);
//        put(1000000, 10);
//    }};
//
//    Map<Integer, Double> CLOCKS = new HashMap<Integer, Double>() {{
//        put(100, 0.0);
//        put(1000, 0.0);
//        put(10000, 0.0);
//        put(100000, 0.0);
//        put(1000000, 0.0);
//    }};

//
    public static void main(String[] args) {
        new Benchmark().tester(new Bubble(), new Insertion());
    }
}