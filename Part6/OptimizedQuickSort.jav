import java.util.Arrays;

public class OptimizedQuickSort {
    
    private static final int INSERTION_SORT_THRESHOLD = 10;

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length == 0) return;
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            if (high - low + 1 <= INSERTION_SORT_THRESHOLD) {
                insertionSort(arr, low, high);
            } else {
                int pivotIndex = partition(arr, low, high);
                quickSort(arr, low, pivotIndex - 1);
                quickSort(arr, pivotIndex + 1, high);
            }
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = medianOfThree(arr, low, high);
        int i = low; 
        int j = high - 1;

        while (true) {
            while (arr[++i] < pivot) {} 
            while (arr[--j] > pivot) {} 
            
            if (i >= j) break;
            swap(arr, i, j);
        }
        swap(arr, i, high - 1); 
        return i;
    }


    private static int medianOfThree(int[] arr, int low, int high) {
        int center = (low + high) / 2;

        if (arr[low] > arr[center]) swap(arr, low, center);
        if (arr[low] > arr[high])   swap(arr, low, high);
        if (arr[center] > arr[high]) swap(arr, center, high);

        swap(arr, center, high - 1);
        return arr[high - 1];
    }

    private static void insertionSort(int[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= low && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] data = { 24, 9, 29, 14, 19, 27, 50, 1, 5, 20, 100, 3 };
        System.out.println("Original: " + Arrays.toString(data));
        
        quickSort(data);
        
        System.out.println("Sorted:   " + Arrays.toString(data));
    }
}