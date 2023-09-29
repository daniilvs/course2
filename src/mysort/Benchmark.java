package mysort;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Benchmark {

    private static double[] randArr (int len) { return ThreadLocalRandom.current().doubles(len).toArray(); }
    private final int[] number_of_elements = { 100, 1000 }; //, 10000, 100000, 1000000
    private final int[] number_of_iterartions = { 10, 100, 100, 100, 10 };

    public void tester (SortingAlgorithm ... algorithms) {
        for (var alg : algorithms) {
            Map<Integer, Long> clocks = new HashMap<Integer, Long>();
            for (int i = 0; i < number_of_elements.length; i++) {
                long average = 0;
                for (int j = number_of_iterartions[i]; j > 0; j--) {
                    double[] sample = randArr(number_of_elements[i]);
                    long st = System.currentTimeMillis();
                    alg.sortAsc(sample);
                    final long time = System.currentTimeMillis() - st;
                    average += time;
                }
                average /= number_of_iterartions[i];
                clocks.put(number_of_elements[i], average);
            }
            String headerOutput = String.format("Average times for %s sort are:", alg.getClass().getSimpleName());
            System.out.println(headerOutput);
            for (Map.Entry<Integer, Long> entry : clocks.entrySet()) {
                String timeOutput = String.format("- for %s elements: %d ms",entry.getKey().toString(), entry.getValue());
                System.out.println(timeOutput);
            }
        }
    }
}
