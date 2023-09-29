package mysort;

public class Selection extends SortingAlgorithm{
    @Override
    public void sortAsc(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int lowest = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[lowest]) {
                    lowest = j;
                }
            }
            swap(arr, lowest, i);
        }
    }
}
