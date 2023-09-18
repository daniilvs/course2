package mysort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    private final Map<Integer, Integer> NUMBER_OF_ITERS = new HashMap<Integer, Integer>() {{
        put(100, 1000);
        put(1000, 100);
        put(10000, 100);
        put(100000, 100);
        put(1000000, 10);
    }};

//    Map<Integer, Double> CLOCKS = new HashMap<Integer, Double>() {{
//        put(100, 0.0);
//        put(1000, 0.0);
//        put(10000, 0.0);
//        put(100000, 0.0);
//        put(1000000, 0.0);
//    }};

    public static double[] randArr (int len) {
        return ThreadLocalRandom.current().doubles(len).toArray();
    }

    public <T> void timeit (Callable<T> func) {
        int nums = 100;
        int[] iters = new int[]{ 1000, 100, 100, 100, 10 };
        for (int i = 0; i < 5; i++) {
            Map<Integer, Double> clocks = new HashMap<Integer, Double>() {{
                put(100, 0.0);
                put(1000, 0.0);
                put(10000, 0.0);
                put(100000, 0.0);
                put(1000000, 0.0);
            }};
            for (int j = iters[i]; j > 0; j--) {
                double[] sample = randArr(nums);
                final long st = System.currentTimeMillis();
                Sorts.func(sample);
                final long
            }
        };
    }

    public static void main(String[] args) {
        double[] arr = randArr(10);

        System.out.println("Array Before bubble Sort");
        Arrays.stream(arr).mapToObj(v -> v + " ").forEach(System.out::print);
        System.out.println();

        Sorts.bubble(arr);

        System.out.println("Array After bubble Sort");
        Arrays.stream(arr).mapToObj(v -> v + " ").forEach(System.out::print);
        System.out.println();
    }
}