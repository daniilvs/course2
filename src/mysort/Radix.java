//package mysort;
//
//import static java.lang.Math.toIntExact;
//
//public class Radix extends SortingAlgorithm{
//    private static long getMantissa(double x) {
//        long bits = Double.doubleToLongBits(x);
//        return bits & 0x000fffffffffffffL;
//    }
//
//
//    private static void counting(double[] arr, long exp) {
//        double[] out = new double[arr.length];
//        int[] count = new int[10];
//        for (double v : arr) {
//            long mant = getMantissa(v);
//            int index = toIntExact((mant / exp) % 10);
//            count[index]++;
//        }
//        for (int i = 1; i < 10; i++) {
//            count[i] += count[i - 1];
//        }
//        for (int i = arr.length - 1; i >= 0; i--) {
//            long mant = getMantissa(arr[i]);
//            int index = toIntExact((mant / exp) % 10);
//            out[count[index] - 1] = arr[i];
//            count[index]--;
//        }
//        System.arraycopy(out, 0, arr, 0, arr.length);
//    }
//
//    private static double getMax(double[] arr)
//    {
//        double max = arr[0];
//        for (int i = 1; i < arr.length; i++)
//            if (arr[i] > max)
//                max = arr[i];
//        return max;
//    }
//
//    @Override
//    public void radix(double[] arr) {
//        double max = getMax(arr);
//        long mant = getMantissa(max);
//        for (long exp = 1; mant / exp >= 1; exp *= 10) {
//            counting(arr, exp);
//        }
//    }
//
//}
