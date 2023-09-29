package mysort;

public class Heap extends SortingAlgorithm {

    private static void heapify(double[] arr, int start, int length) {
        int left = 2 * start + 1, right = left + 1, max = start;
        if (left < length && arr[left] > arr[max]) {
            max = left;
        }
        if (right < length && arr[right] > arr[max]) {
            max = right;
        }
        if (max != start) {
            swap(arr, max, start);
            heapify(arr, max, length);
        }
    }

    private static void buildHeap(double[] arr) {
        for (int start = arr.length / 2 - 1; start >= 0; start--) {
            heapify(arr, start, arr.length);
        }
    }
    @Override
    public void sortAsc(double[] arr) {
        buildHeap(arr);
        for (int j = arr.length - 1; j >= 1; j--) {
            swap(arr, 0, j);
            heapify(arr, 0, j);
        }
    }
}
