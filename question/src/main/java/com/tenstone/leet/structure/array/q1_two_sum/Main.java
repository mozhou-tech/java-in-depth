package com.tenstone.leet.structure.array.q1_two_sum;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * <p>
 * 无重复字符的最长子串
 * Created by liuyuancheng on 2021/7/3  <br/>
 */
@Slf4j
public class Main {

    /**
     * 图解
     * https://leetcode-cn.com/problems/two-sum/solution/jie-suan-fa-1-liang-shu-zhi-he-by-guanpengchn/
     */
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            // 由于哈希查找的时间复杂度为 O(1)O(1)，所以可以利用哈希容器 map 降低时间复杂度
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                    return new int[]{map.get(target - nums[i]), i};
                }
                map.put(nums[i], i);
            }
            throw new IllegalArgumentException("No two sum solution");
        }
    }


    public static void main(String[] args) {
        Assertions.assertArrayEquals(new Solution().twoSum(new int[]{2, 7, 11, 15}, 9), new int[]{0, 1});
        Assertions.assertArrayEquals(new Solution().twoSum(new int[]{3, 2, 4}, 6), new int[]{1, 2});
        Assertions.assertArrayEquals(new Solution().twoSum(new int[]{3, 3, 6}, 6), new int[]{0, 1});
    }
}
