package com.tenstone.leet.question.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by liuyuancheng on 2022/1/5  <br/>
 * https://www.geeksforgeeks.org/merge-sort/?ref=lbp
 *
 * @author liuyuancheng
 */
@Slf4j
public class MergeSort {
    private static AtomicInteger loop = new AtomicInteger(0);

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]

    /**
     * 归并操作的工作原理如下：
     * 第一步：申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
     * 第二步：设定两个指针，最初位置分别为两个已经排序序列的起始位置
     * 第三步：比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
     * 重复步骤3直到某一指针超出序列尾
     * 将另一序列剩下的所有元素直接复制到合并序列尾
     */

    void merge(int[] arr, int l, int m, int r) {
        // find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }
        // Merge the temp arrays
        // Initial indexes of first and second subarrays
        int i = 0;
        int j = 0;
        // Initial index of merged subarray array
        // 遍历的起始位置，就是合并的起始位置
        int k = l;
        // 比较两个子数组的大小，较小的那个复制给arr[k]
        // 直至两个子数组中的一个遍历结束
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        // 【重点】子数组中剩下的元素放置到arr的下一个位置（剩下的1个一定是最大的值）
        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l...r] using
    // merge()
    void sort(int[] arr, int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    // a utility function to print array of size n
    static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13};
        System.out.print("Given Array: ");
        printArray(arr);
        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);
        System.out.print("Sorted Array: ");
        printArray(arr);
    }
}
