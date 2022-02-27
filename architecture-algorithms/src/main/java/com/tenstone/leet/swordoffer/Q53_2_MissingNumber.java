package com.tenstone.leet.swordoffer;

import org.junit.jupiter.api.Assertions;

/**
 * Created by liuyuancheng on 2022/2/27  <br/>
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 * https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
 *
 * @author liuyuancheng
 */
public class Q53_2_MissingNumber {

    static class Solution {
        public int missingNumber(int[] nums) {
            // base case
            if (nums.length > 0 && nums[0] != 0) {
                return 0;
            }
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i + 1] != nums[i] + 1) {
                    return nums[i] + 1;
                }
            }
            // base case
            return nums[nums.length - 1] + 1;
        }
    }

    public static void main(String[] args) {
        int miss = new Solution().missingNumber(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9});
        Assertions.assertEquals(8, miss);

        miss = new Solution().missingNumber(new int[]{0});
        Assertions.assertEquals(1, miss);

        miss = new Solution().missingNumber(new int[]{1});
        Assertions.assertEquals(0, miss);
    }

}
