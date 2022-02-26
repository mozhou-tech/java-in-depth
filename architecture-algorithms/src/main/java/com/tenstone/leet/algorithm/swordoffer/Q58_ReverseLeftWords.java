package com.tenstone.leet.algorithm.swordoffer;

import org.junit.jupiter.api.Assertions;

/**
 * Created by liuyuancheng on 2022/2/26  <br/>
 * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 * 左旋字符串
 *
 * @author liuyuancheng
 */
public class Q58_ReverseLeftWords {

    static class Solution {
        public String reverseLeftWords(String s, int n) {
            char[] returning = new char[s.length()];
            for (int i = 0; i < returning.length; i++) {
                if (i < n) {
                    returning[returning.length - n + i] = s.charAt(i);
                } else {
                    returning[i - n] = s.charAt(i);
                }
            }
            return new String(returning);
        }
    }

    public static void main(String[] args) {
        final String result = new Solution().reverseLeftWords("abcdefg", 2);
        Assertions.assertEquals(result, "cdefgab");
    }

}
