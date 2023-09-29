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
//
//    public static void insertion(double[] arr) {
//        for (int i = 1; i < arr.length; i++) {
//            double current = arr[i];
//            int j = i - 1;
//            for (; j >= 0; j--) {
//                if (arr[j] > current) arr[j+1] = arr[j];
//                else break;
//            }
//            arr[j+1] = current;
//        }
//    }
//
//    public static void selection(double[] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            int lowest = i;
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[j] < arr[lowest]) {
//                    lowest = j;
//                }
//            }
//            swap(arr, lowest, i);
//        }
//    }
//
//    public static void memerge(double[] arr) {
//        int size = arr.length;
//        if (size > 1) {
//            int mid = size / 2;
//            double[] left = Arrays.copyOfRange(arr, 0, mid);
//            double[] right = Arrays.copyOfRange(arr, mid, arr.length);
//            memerge(left);
//            memerge(right);
//            int i, j, k;
//            i = j = k = 0;
//            while (i < left.length && j < right.length) {
//                if (left[i] <= right[j]) {
//                    arr[k] = left[i];
//                    i++;
//                }
//                else {
//                    arr[k] = right[j];
//                    j++;
//                }
//                k++;
//            }
//            while (i < left.length) {
//                arr[k] = left[i];
//                i++;
//                k++;
//            }
//            while (j < right.length) {
//                arr[k] = right[j];
//                j++;
//                k++;
//            }
//        }
//    }
//
//    private static void merge(double[] arr, int begin, int middle, int end) {
//        double[] left = Arrays.copyOfRange(arr, begin, middle);
//        double[] right = Arrays.copyOfRange(arr, middle, end);
//        int li = 0, ri = 0;
//        for (int i = begin; i < end; i++) {
//            if (li < left.length && (ri == right.length || left[li] <= right[ri])) {
//                arr[i] = left[li++];
//            }
//            else {
//                arr[i] = right[ri++];
//            }
//        }
//    }
//
//    private static void mergeSort(double[] arr, int begin, int end) {
//        if (end - begin <= 1) return;
//        int middle = (begin + end) / 2;
//        mergeSort(arr, begin, middle);
//        mergeSort(arr, middle, end);
//        merge(arr, begin, middle, end);
//    }
//
//    public static void merge(double[] arr) {
//        mergeSort(arr, 0, arr.length);
//    }
//
//    private static void heapify(double[] arr, int start, int length) {
//        int left = 2 * start + 1, right = left + 1, max = start;
//        if (left < length && arr[left] > arr[max]) {
//            max = left;
//        }
//        if (right < length && arr[right] > arr[max]) {
//            max = right;
//        }
//        if (max != start) {
//            swap(arr, max, start);
//            heapify(arr, max, length);
//        }
//    }
//
//    private static void buildHeap(double[] arr) {
//        for (int start = arr.length / 2 - 1; start >= 0; start--) {
//            heapify(arr, start, arr.length);
//        }
//    }
//
//    public static void heap(double[] arr) {
//        buildHeap(arr);
//        for (int j = arr.length - 1; j >= 1; j--) {
//            swap(arr, 0, j);
//            heapify(arr, 0, j);
//        }
//    }
//
//    private static int partition(double[] arr, int min, int max) {
//        double x = arr[max];
//        int left = min, right = max;
//        while (left <= right) {
//            while (arr[left] < x) {
//                left++;
//            }
//            while (arr[right] > x) {
//                right--;
//            }
//            if (left <= right) {
//                swap(arr, left, right);
//                left++;
//                right--;
//            }
//        }
//        return right;
//    }
//
//    private static void quickSort(double[] arr, int min, int max) {
//        if (min < max) {
//            int border = partition(arr, min, max);
//            quickSort(arr, min, border);
//            quickSort(arr, border + 1, max);
//        }
//    }
//
//    public static void quick(double[] arr) {
//        quickSort(arr, 0, arr.length - 1);
//    }
//
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
//    public static void radix(double[] arr) {
//        double max = getMax(arr);
//        long mant = getMantissa(max);
//        for (long exp = 1; mant / exp >= 1; exp *= 10) {
//            counting(arr, exp);
//        }
//    }

//    public static void quick(double[] arr) {
//        if (arr.length <= 1) {
//            return;
//        }
//        else {
//            double pivot = arr[arr.length - 1];
//            int i = 0, j = 0;
//            double[] left = new double[arr.length], right = new double[arr.length];
//            Arrays.stream(Arrays.copyOfRange(arr, 0, arr.length - 1)).forEach(
//                    (elem) ->  { if (elem < pivot) {
//            left[i] = elem;
//            i++;
//                    }
//            });
//        }
//    }

}
