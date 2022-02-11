package com.tenstone.leet.algorithm.sort;

/**
 * 快排
 * Created by liuyuancheng on 2022/1/5  <br/>
 * https://www.geeksforgeeks.org/quick-sort/
 *
 * 1. 从数列中挑出一个元素，称为 "基准"（pivot）;
 *
 * 2. 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
 * 在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 *
 * 3. 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序；
 *
 * @author liuyuancheng
 */
public class QuickSort {

    /**
     * 交换元素的工具函数
     *
     * @param arr
     * @param i
     * @param j
     */
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

    /**
     * 分区并把元素移动到基准的左右两侧
     *
     * @param arr 待排序的数组
     * @param low 起始位置
     * @param high 结束位置
     *
     * @return 返回数组结束点
     */
    static int partition(int[] arr, int low, int high) {
        // 最后一个元素作为排序基准
        int pivot = arr[high];
        // 较小元素的索引，并指示目前找到的正确的基准位置（统计基准左侧应当存在的元素数量）
        // Index of smaller element and indicates the right position of pivot found so far
        int i = (low - 1);
        // 从起始位开始与基准进行比较
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                // Increment index of smaller element
                i++;
                // 只要j位置的数比基准小，则令其余i位置的数交换
                // i腾出数组偏移，放置所有小于基准的数；遍历完后i+1则是基准的新位置
                swap(arr, i, j);
            }
        }
        // 将最高位（基准）和参考值交换
        // 如果i+1 = 基准元素新位置，把high换过去
        swap(arr, i + 1, high);
        // 返回目前基准所在的位置，即当前分片最后一个位置
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
        // 递归直至low < high可以认为所有的元素都有序了（原来的数组已经分的不能再分）
        if (low < high) {
            // 对数组分组，按基准分成左右两部分
            int pi = partition(arr, low, high);
            // 排序左边一部分
            quickSort(arr, low, pi - 1);
            // 排序右边一部分
            quickSort(arr, pi + 1, high);
        }
    }

    // driver code
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 15};
        int n = arr.length;
        quickSort(arr, 0, n - 1);
        System.out.print("Sorted array: ");
        printArray(arr, n);
    }
}
