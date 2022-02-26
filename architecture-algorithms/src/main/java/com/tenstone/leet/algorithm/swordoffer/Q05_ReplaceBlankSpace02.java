package com.tenstone.leet.algorithm.swordoffer;

import org.junit.jupiter.api.Assertions;

/**
 * Created by liuyuancheng on 2022/2/26  <br/>
 * 替换空格
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 *
 * @author liuyuancheng
 */
public class Q05_ReplaceBlankSpace02 {

    static class Solution {
        public String replaceSpace(String s) {
            int length = s.length();
            char[] array = new char[length * 3];
            int size = 0;
            for (int i = 0; i < length; i++) {
                char c = s.charAt(i);
                if (c == ' ') {
                    array[size++] = '%';
                    array[size++] = '2';
                    array[size++] = '0';
                } else {
                    array[size++] = c;
                }
            }
            return new String(array, 0, size);
        }
    }

    public static void main(String[] args) {
        final String s = new Solution().replaceSpace("We are happy.");
        Assertions.assertEquals("We%20are%20happy.", s);
    }
}
