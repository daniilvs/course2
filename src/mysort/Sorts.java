package mysort;

import java.util.Arrays;

public class Sorts {
    public static void bubble(double[] arr) {
        int size = arr.length;
        boolean swapped = false;
        for (int i = size - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapped = true;
                    double temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
            if (!swapped) {
                return;
            }
        }
    }

    public static void insertion(double[] arr) {
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

    public static void selection(double[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int lowest = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[lowest]) {
                    lowest = j;
                }
            }
            double temp = arr[lowest];
            arr[lowest] = arr[i];
            arr[i] = temp;
        }
    }

    public static void memerge(double[] arr) {
        int size = arr.length;
        if (size > 1) {
            int mid = size / 2;
            double[] left = Arrays.copyOfRange(arr, 0, mid);
            double[] right = Arrays.copyOfRange(arr, mid, 0);
            memerge(left);
            memerge(right);
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

    public static void merge(double[] arr) {
        mergeSort(arr, 0, arr.length);
    }

    private static void heapify(double[] arr, int start, int length) {
        int left = 2 * start + 1;
        int right = left + 1;
        int max = start;
        if (left < length && arr[left] > arr[max]) {
            max = left;
        }
        if (right < length && arr[right] > arr[max]) {
            max = right;
        }
        if (max != start) {
            double temp = arr[max];
            arr[max] = arr[start];
            arr[start] = temp;
            heapify(arr, max, length);
        }
    }

    private static void buildHeap(double[] arr) {
        for (int start = arr.length / 2 - 1; start >= 0; start--) {
            heapify(arr, start, arr.length);
        }
    }

    public static void heap(double[] arr) {
        buildHeap(arr);
        for (int j = arr.length - 1; j >= 1; j--) {
            double temp = arr[0];
            arr[0] = arr[j];
            arr[j] = temp;
            heapify(arr, 0, j);
        }
    }

    public static void quick(double[] arr) {
        if (arr.length <= 1) {
            return;
        }
        else {
            double pivot = arr[arr.length - 1];
            double[] left, right;
            left = new double[arr.length];
            right = new double[arr.length];
            Arrays.stream(Arrays.copyOfRange(arr, 0, arr.length - 1)).forEach(
                    (elem) ->  { if (elem < pivot) {
            left.append(elem);
                    }
            });
        }
    }

}
