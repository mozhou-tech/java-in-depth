package com.tenstone.leet.algorithm.array.q26_remove_duplicates_from_sorted_array;

import org.junit.jupiter.api.Assertions;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 0 <= nums.length <= 3 * 104
 * -104 <= nums[i] <= 104
 * nums 已按升序排列
 * <p>
 * Created by liuyuancheng on 2021/7/6  <br/>
 */
public class Main {

    static class Solution {
        /**
         * 双指针
         * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/shuang-zhi-zhen-shan-chu-zhong-fu-xiang-dai-you-hu/
         * @param nums
         * @return
         */
        public int removeDuplicates(int[] nums) {
            // 使用双指针
            if(nums == null || nums.length == 0) {
                return 0;
            }
            int p = 0;
            int q = 1;
            while(q < nums.length){
                if(nums[p] != nums[q]){
                    nums[p + 1] = nums[q];
                    p++;
                }
                q++;
            }
            return p + 1;
        }
    }

    public static void main(String[] args) {
        var t1 = new Main.Solution()
                .removeDuplicates(new int[]{1, 1, 2});
        Assertions.assertEquals(t1, 2);
        var t2 = new Main.Solution()
                .removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
        Assertions.assertEquals(t2, 5);
        Object a = "2";
        Assertions.assertEquals(a,"2");
        Assertions.assertTrue(a.equals(new String("2")));
    }
}
