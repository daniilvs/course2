package mysort;

public class Main {

    public static void main(String[] args) {
        new Benchmark().tester(new Bubble(), new Insertion(), new Selection(),
                new Heap(), new Merge(), new Memerge(), new Quick(), new Radix());
    }

}