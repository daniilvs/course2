package mysort;
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
}
