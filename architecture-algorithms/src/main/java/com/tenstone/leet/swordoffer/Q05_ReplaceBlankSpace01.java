package com.tenstone.leet.swordoffer;

import org.junit.jupiter.api.Assertions;

/**
 * Created by liuyuancheng on 2022/2/26  <br/>
 * 替换空格
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 *
 *
 * @author liuyuancheng
 */
public class Q05_ReplaceBlankSpace01 {


    /**
     * 切记别把简单的事情搞复杂了
     */
    static class Solution {
        public String replaceSpace(String s) {
            int length = s.length();
            StringBuilder returning = new StringBuilder();
            for (int i = 0; i < length; i++) {
                if (s.charAt(i) == ' ') {
                    returning.append("%20");
                } else {
                    returning.append(s.charAt(i));
                }
            }
            return returning.toString();
        }
    }

    public static void main(String[] args) {
        final String s = new Solution().replaceSpace("We are happy.");
        Assertions.assertEquals("We%20are%20happy.", s);
    }
}
