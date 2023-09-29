package mysort;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class benchmark {

    private static double[] randArr (int len) { return ThreadLocalRandom.current().doubles(len).toArray(); }
    private final int[] number_of_elements = { 100, 1000, 10000, 100000, 1000000 };
    private final int[] number_of_iterartions = { 1000, 100, 100, 100, 10 };

        private final Map<Integer, Integer> NUMBER_OF_ITERS = new HashMap<Integer, Integer>() {{
        put(100, 1000);
        put(1000, 100);
        put(10000, 100);
        put(100000, 100);
        put(1000000, 10);
    }};

    Map<Integer, Double> CLOCKS = new HashMap<Integer, Double>() {{
        put(100, 0.0);
        put(1000, 0.0);
        put(10000, 0.0);
        put(100000, 0.0);
        put(1000000, 0.0);
    }};

    public void tester (SortingAlgorithm ... algorithms) {

        for (int i = 0; i < 5; i++) {
            Map<Integer, Double> clocks = new HashMap<Integer, Double>() {{
                put(100, 0.0);
                put(1000, 0.0);
                put(10000, 0.0);
                put(100000, 0.0);
                put(1000000, 0.0);
            }};
            long average = 0;
            for (int j = number_of_iterartions[i]; j > 0; j--) {
                double[] sample = randArr(number_of_elements[j]);
                long st = System.currentTimeMillis();
                SortingAlgorithm.bubble(sample);
                final long time = st - System.currentTimeMillis();
                average += time;
            }

        };
    }

}
