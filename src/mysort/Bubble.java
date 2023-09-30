package mysort;

public class Bubble extends SortingAlgorithm {
    @Override
    public void sortAsc(double[] arr) {
        int size = arr.length;
        boolean swapped = false;
        for (int i = size - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapped = true;
                    swap(arr, j+1, j);
                }
            }
            if (!swapped) {
                return;
            }
        }
    }
}
