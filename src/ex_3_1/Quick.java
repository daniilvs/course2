package ex_3_1;

public class Quick extends SortingAlgorithm{
    private static int partition(double[] arr, int min, int max) {
        double x = arr[max];
        int left = min, right = max;
        while (left <= right) {
            while (arr[left] < x) {
                left++;
            }
            while (arr[right] > x) {
                right--;
            }
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return right;
    }

    private static void quickSort(double[] arr, int min, int max) {
        if (min < max) {
            int border = partition(arr, min, max);
            quickSort(arr, min, border);
            quickSort(arr, border + 1, max);
        }
    }

    @Override
    public void sortAsc(double[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

}
