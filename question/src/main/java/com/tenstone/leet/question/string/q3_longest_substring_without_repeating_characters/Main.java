package com.tenstone.leet.question.string.q3_longest_substring_without_repeating_characters;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * <p>
 * 无重复字符的最长子串
 * Created by liuyuancheng on 2021/7/3  <br/>
 */
@Slf4j
public class Main {

    static class Solution {

        /**
         * 滑动窗口法
         *
         * 以这个字符串为例：abcabcbb，当i等于3时，也就是指向了第二个a, 此时我就需要查之前有没有出现过a, 如果出现了是在哪一个位置出现的。
         * 然后通过last[index] 查到等于1, 也就是说，如果start 依然等于0的话，那么当前窗口就有两个a了，也就是字符串重复了，所以我们需要移动当前窗口的start指针，
         * 移动到什么地方呢？移动到什么地方，窗口内就没有重复元素了呢？ 对了，就是a上一次出现的位置的下一个位置，就是1 + 1 = 2。当start == 2,
         * 当前窗口就没有了重复元素，那么以当前字符为结尾的最长无重复子串就是bca,然后再和之前的res取最大值。然后i指向后面的位置，按照同样思路计算。
         *
         * @param s
         * @return
         */
        public int lengthOfLongestSubstring(String s) {
            int[] last = new int[128];   // 记录字符上一次出现的位置
            for (int i = 0; i < 128; i++) {
                last[i] = -1;
            }
            int maxLength = 0, start = 0; // 窗口开始位置
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i);
                start = Math.max(start, last[index] + 1);
                maxLength = Math.max(maxLength, i - start + 1);
                last[index] = i;
            }
            return maxLength;
        }
    }

    public static void main(String[] args) {
        Assertions.assertEquals(new Solution().lengthOfLongestSubstring("abcabcbb"), 3);
        Assertions.assertEquals(new Solution().lengthOfLongestSubstring("pwwkew"), 3);
        Assertions.assertEquals(new Solution().lengthOfLongestSubstring("bbbbbb"), 1);
        Assertions.assertEquals(new Solution().lengthOfLongestSubstring(""), 0);
        Assertions.assertEquals(new Solution().lengthOfLongestSubstring("bwf"), 3);
        Assertions.assertEquals(new Solution().lengthOfLongestSubstring("aab"), 2);
    }
}
