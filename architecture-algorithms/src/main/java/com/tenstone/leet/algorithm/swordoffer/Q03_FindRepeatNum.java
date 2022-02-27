package com.tenstone.leet.algorithm.swordoffer;

import org.junit.jupiter.api.Assertions;

import java.util.*;

/**
 * Created by liuyuancheng on 2022/2/27  <br/>
 * 数组中重复的数字
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字
 * <p>
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 *
 * @author liuyuancheng
 */
public class Q03_FindRepeatNum {

    /**
     * 利用set不存在重复值的特性
     */
    static class Solution {
        public int findRepeatNumber(int[] nums) {
            final Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                if(set.contains(num)){
                    return num;
                }
                set.add(num);
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        final int repeatNumber = new Solution().findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3});
        Assertions.assertTrue(Arrays.asList(2, 3).contains(repeatNumber));
    }

}
