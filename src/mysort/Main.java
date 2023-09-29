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

    public static double[] randArr (int len) {
        return ThreadLocalRandom.current().doubles(len).toArray();
    }

    public static void main(String[] args) {
        double[] arr = randArr(10);

        System.out.println("Array Before Sort");
        Arrays.stream(arr).mapToObj(v -> v + " ").forEach(System.out::print);
        System.out.println();

        Sorts.radix(arr);

        System.out.println("Array After Sort");
        Arrays.stream(arr).mapToObj(v -> v + " ").forEach(System.out::print);
        System.out.println();
//        double x = arr[0];
//        long mantis = Sorts.getMantissa(x);
//        System.out.println(x);
//        System.out.println(mantis);
//
//        System.out.println(Arrays.toString(arr));
//        List<Long> mantisses = Arrays.stream(arr).mapToObj(Sorts::getMantissa).toList();
//        System.out.println(mantisses);
    }
}