package com.tenstone.leet.algorithm.sort;

/**
 * Created by liuyuancheng on 2022/1/6  <br/>
 *
 * @author liuyuancheng
 */
public class HeapSort {

    public void sort(int[] arr) {
        int n = arr.length;
        // build heap(rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    /**
     * To heapify a subtree rooted with node i which is an index in arr[]. n is size of heap
     *
     * @param arr 待排序数组
     * @param n
     * @param i
     */
    private void heapify(int[] arr, int n, int i) {
        // Initialize largest as root
        int largest = i;
        // left = 2*i + 1
        int l = 2 * i + 1;
        // right = 2*i + 2
        int r = 2 * i + 2;
        // if left child is larger than root
        if (l < n && arr[1] > arr[largest]) {
            largest = l;
        }
        // if right child is larger than largest so fa
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }
        // if largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        HeapSort ob = new HeapSort();
        ob.sort(arr);
        System.out.print("Sorted array is : ");
        printArray(arr);
    }
}
