package mysort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    private final int[] number_of_elements = { 100, 1000, 10000, 100000, 1000000};
    private final int[] number_of_iterartions = { 1000, 100, 100, 100, 10};

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

    public static double[] randArr (int len) {
        return ThreadLocalRandom.current().doubles(len).toArray();
    }

    public <T extends Callable<T>> void timeit (Callable<T> func) {

        for (int i = 0; i < 5; i++) {
            Map<Integer, Double> clocks = new HashMap<Integer, Double>() {{
                put(100, 0.0);
                put(1000, 0.0);
                put(10000, 0.0);
                put(100000, 0.0);
                put(1000000, 0.0);
            }};
            int average = 0;
            for (int j = number_of_iterartions[i]; j > 0; j--) {
                double[] sample = randArr(number_of_elements[j]);
                long st = System.currentTimeMillis();
                Sorts.bubble(sample);
                final long time = st - System.currentTimeMillis();
                average += time;
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