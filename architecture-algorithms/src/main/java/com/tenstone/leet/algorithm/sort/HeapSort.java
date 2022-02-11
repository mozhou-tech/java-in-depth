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
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // 交换arr[0]和arr[i]的位置（arr[0]为最大值）
            // 将最大值放到数组最后的位置
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // 堆的大小减1（最大值将不被重排序），剩下的并重新排序
            heapify(arr, i, 0);
        }
    }

    /**
     * To heapify a subtree rooted with node i which is an index in arr[]. n is size of heap
     *
     * @param arr 待排序数组
     * @param n   堆的大小
     * @param i   heap中的一个节点
     */
    private void heapify(int[] arr, int n, int i) {
        // Initialize largest as root
        int largest = i;
        // left = 2 * i + 1 （Node i的左树）
        int l = 2 * i + 1;
        // right = 2 * i + 2 （Node i的右树）
        int r = 2 * i + 2;
        // 选择根节点为最大值
        // if left child is larger than root
        if (l < n && arr[1] > arr[largest]) {
            largest = l;
        }
        // if right child is larger than largest so fa
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }
        // 如果largest不是所在子树的最大值，则把最大数放在子树的root位置
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            // Recursively heapify the affected sub-tree
            // 递归影响子树
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
