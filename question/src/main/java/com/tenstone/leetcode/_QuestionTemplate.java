package com.tenstone.leetcode;

import org.junit.jupiter.api.Assertions;

/**
 * Created by liuyuancheng on 2021/7/8  <br/>
 */
public class _QuestionTemplate {

    static class Solution {
        public int removeElement(int[] nums, int val) {
            return 0;
        }
    }

    public static void main(String[] args) {
        Assertions.assertEquals(new _QuestionTemplate.Solution()
                .removeElement(new int[]{3, 2, 2, 3}, 3), 2);
    }
}
