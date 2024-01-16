package ex_3_1;

import java.util.Arrays;

public class Memerge extends SortingAlgorithm{
    @Override
    public void sortAsc(double[] arr) {
        int size = arr.length;
        if (size > 1) {
            int mid = size / 2;
            double[] left = Arrays.copyOfRange(arr, 0, mid);
            double[] right = Arrays.copyOfRange(arr, mid, arr.length);
            sortAsc(left);
            sortAsc(right);
            int i, j, k;
            i = j = k = 0;
            while (i < left.length && j < right.length) {
                if (left[i] <= right[j]) {
                    arr[k] = left[i];
                    i++;
                }
                else {
                    arr[k] = right[j];
                    j++;
                }
                k++;
            }
            while (i < left.length) {
                arr[k] = left[i];
                i++;
                k++;
            }
            while (j < right.length) {
                arr[k] = right[j];
                j++;
                k++;
            }
        }
    }
}
