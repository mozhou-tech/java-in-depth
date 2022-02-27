package com.tenstone.leet.algorithm.swordoffer;

import org.junit.jupiter.api.Assertions;

/**
 * Created by liuyuancheng on 2022/2/27  <br/>
 * 统计一个数字在排序数组中出现的次数。
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 *
 * @author liuyuancheng
 */
public class Q53_CountRepeatInArray {

    /**
     * 迭代并计数
     */
    static class Solution {

        public int count = 0;

        public int search(int[] nums, int target) {
            for (int num : nums) {
                if (num == target) {
                    count++;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        final int repeat = new Solution().search(new int[]{5, 7, 7, 8, 8, 10}, 8);
        Assertions.assertEquals(2, repeat);
    }

}
