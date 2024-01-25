package ex_3_1;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;


public class Main {

    public static void main(String[] args) {
        new Benchmark().tester(new Bubble(), new Insertion(), new Selection(),
                new Heap(), new Merge(), new Memerge(), new Quick(), new Radix());
//        double[] sample = ThreadLocalRandom.current().doubles(10).toArray();
//        Bubble sort = new Bubble();
//        System.out.println(Arrays.toString(sample));
//        sort.sortAsc(sample);
//        System.out.println(Arrays.toString(sample));
    }

}