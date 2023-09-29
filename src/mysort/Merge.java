package mysort;

import java.util.Arrays;

public class Merge extends SortingAlgorithm{
    private static void merge(double[] arr, int begin, int middle, int end) {
        double[] left = Arrays.copyOfRange(arr, begin, middle);
        double[] right = Arrays.copyOfRange(arr, middle, end);
        int li = 0, ri = 0;
        for (int i = begin; i < end; i++) {
            if (li < left.length && (ri == right.length || left[li] <= right[ri])) {
                arr[i] = left[li++];
            }
            else {
                arr[i] = right[ri++];
            }
        }
    }

    private static void mergeSort(double[] arr, int begin, int end) {
        if (end - begin <= 1) return;
        int middle = (begin + end) / 2;
        mergeSort(arr, begin, middle);
        mergeSort(arr, middle, end);
        merge(arr, begin, middle, end);
    }

    @Override
    public void sortAsc(double[] arr) {
        mergeSort(arr, 0, arr.length);
    }
}
