package com.tenstone.leet.algorithm.swordoffer;

import org.junit.jupiter.api.Assertions;

/**
 * Created by liuyuancheng on 2022/2/26  <br/>
 * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 * 左旋字符串
 *
 * @author liuyuancheng
 */
public class Q58_ReverseLeftWords02 {

    static class Solution {
        public String reverseLeftWords(String s, int n) {
            char[] chars = s.toCharArray();
            return new String(chars, n, chars.length - n) + new String(chars, 0, n);
        }
    }

    public static void main(String[] args) {
        final String result = new Solution().reverseLeftWords("abcdefg", 2);
        Assertions.assertEquals("cdefgab", result);
    }

}
