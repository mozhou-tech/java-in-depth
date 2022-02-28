package com.tenstone.leet.swordoffer;

import org.junit.jupiter.api.Assertions;

/**
 * Created by liuyuancheng on 2022/2/28  <br/>
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 *
 * @author liuyuancheng
 */
public class Q04_FindNumberIn2DArray02_ {


    static class Solution {
        /**
         * 高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
         * 这个时基于while循环 线性搜索
         *
         * @param matrix
         * @param target
         */
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            // 先考虑基础情况
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }
            // 要记住，这种情况下使用while,可以动态的自增行和列（例如二维数组遍历等）
            int rows = matrix.length;
            int columns = matrix[0].length;
            int row = 0, col = columns - 1;
            // while通过代码灵活控制指针走向
            while (col >= 0 && row < rows) {
                int num = matrix[row][col];
                if (num == target) {
                    return true;
                }
                if (num < target) {
                    row++;
                } else {
                    col--;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[][] matrix;
        matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        Assertions.assertTrue(new Solution().findNumberIn2DArray(matrix, 5));
        Assertions.assertFalse(new Solution().findNumberIn2DArray(matrix, 20));

        matrix = new int[][]{};
        Assertions.assertFalse(new Solution().findNumberIn2DArray(matrix, 1));
        matrix = new int[][]{{-1, 3}};
        Assertions.assertTrue(new Solution().findNumberIn2DArray(matrix, 3));
        matrix = new int[][]{{-1}, {-1}};
        Assertions.assertFalse(new Solution().findNumberIn2DArray(matrix, -3));
        matrix = new int[][]{{5}, {6}};
        Assertions.assertTrue(new Solution().findNumberIn2DArray(matrix, 6));
        matrix = new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        Assertions.assertTrue(new Solution().findNumberIn2DArray(matrix, 1));
        Assertions.assertFalse(new Solution().findNumberIn2DArray(matrix, 0));
        Assertions.assertFalse(new Solution().findNumberIn2DArray(matrix, 27));
    }
}
