package mysort;

import static java.lang.Math.toIntExact;

public class Radix extends SortingAlgorithm{
    private static long getDigit(double value, int num) {
        long x = Double.doubleToLongBits(value);
        return (x >>> (8 * num)) & 0xFF;
    }

    private static void counting(double[] arr, int exp) {
        double[] out = new double[arr.length];
        int[] count = new int[0xFF];
        for (double v : arr) {
            int index = toIntExact(getDigit(v, exp));
            count[index]++;
        }
        for (int i = 1; i < 0xFF; i++) {
            count[i] += count[i - 1];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            int index = toIntExact(getDigit(arr[i], exp));
            out[count[index] - 1] = arr[i];
            count[index]--;
        }
        System.arraycopy(out, 0, arr, 0, arr.length);
    }

    @Override
    public void sortAsc(double[] arr) {
        for (int i = 0; i < 8; i++) {
            counting(arr, i);
        }
    }
}
