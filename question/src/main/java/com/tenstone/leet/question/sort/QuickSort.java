package com.tenstone.leet.question.sort;

/**
 * 快排
 * Created by liuyuancheng on 2022/1/5  <br/>
 * https://www.geeksforgeeks.org/quick-sort/
 *
 * @author liuyuancheng
 */
public class QuickSort {

    // A utility function to swap two elements
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Function to print an array
    static void printArray(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // This function take last element as pivot
    static int partition(int[] arr, int low, int high) {
        // pivot 中心点
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                // Increment index of smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    /**
     * 快速排序
     *
     * @param arr 准备排序的数组
     * @param low Starting Index
     * @param high Ending Index
     */
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);

        }
    }

    // driver code
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 15};
        int n = arr.length;
        quickSort(arr, 0, n - 1);
        System.out.println("Sorted array: ");
        printArray(arr, n);
    }
}
