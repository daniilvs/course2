package ex_3_1;

public abstract class SortingAlgorithm {
    public static void swap(double[] arr, int i, int j)
    {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public abstract void sortAsc(double[] arr);
}
