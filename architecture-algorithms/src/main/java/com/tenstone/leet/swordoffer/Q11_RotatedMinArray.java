package com.tenstone.leet.swordoffer;

import org.junit.jupiter.api.Assertions;

/**
 * Created by liuyuancheng on 2022/2/28  <br/>
 * 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 *
 * @author liuyuancheng
 */
public class Q11_RotatedMinArray {

    static class Solution {
        public int minArray(int[] numbers) {
            // 逆序搜索
            for (int i = numbers.length - 1; i >= 0; i--) {
                // 处理数组未进行喜欢转的情况
                if (i == 0) {
                    return numbers[0];
                }
                if (numbers[i] < numbers[i - 1]) {
                    return numbers[i];
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        int min = new Solution().minArray(new int[]{3, 4, 5, 1, 2});
        Assertions.assertEquals(min, 1);
        min = new Solution().minArray(new int[]{1, 3, 5});
        Assertions.assertEquals(min, 1);
    }
}
