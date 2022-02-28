package com.tenstone.leet.swordoffer;

import org.junit.jupiter.api.Assertions;

/**
 * Created by liuyuancheng on 2022/2/28  <br/>
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * 二维数组中的查找
 * 数组越界大问题！！！！
 *
 * @author liuyuancheng
 */
public class Q04_FindNumberIn2DArray_ {


    static class Solution {
        /**
         * 高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
         * 对角线搜索（审题要清楚！！！ M*N的矩阵）
         * 暴力查找也是一种方法！！！
         *
         * @param matrix
         * @param target
         */
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            boolean flag = false;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == target) {
                        flag = true;
                        break;
                    }
                }
            }
            return flag;
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
