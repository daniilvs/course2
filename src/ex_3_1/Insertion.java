package ex_3_1;

public class Insertion extends SortingAlgorithm{
    @Override
    public void sortAsc(double[] arr) {
        for (int i = 1; i < arr.length; i++) {
            double current = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > current) arr[j+1] = arr[j];
                else break;
            }
            arr[j+1] = current;
        }
    }
}
