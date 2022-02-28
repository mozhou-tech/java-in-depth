package com.tenstone.leet.swordoffer;

import org.junit.jupiter.api.Assertions;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by liuyuancheng on 2022/2/28  <br/>
 * 第一个只出现一次的字符
 * https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 *
 * @author liuyuancheng
 */
public class Q50_FirstUniqChar {
    static class Solution {
        public char firstUniqChar(String s) {
            Map<Character, Integer> charsCount = new LinkedHashMap<>();
            for (int i = 0; i < s.length(); i++) {
                // merge() 方法会先判断指定的 key 是否存在，如果不存在，则添加键值对到 hashMap 中。
                charsCount.merge(s.charAt(i), 1, Integer::sum);
            }
            // 此处对于LinkedHashMap，entrySet是有序的
            for (Map.Entry<Character, Integer> next : charsCount.entrySet()) {
                if (next.getValue() == 1) {
                    return next.getKey();
                }
            }
            return ' ';
        }
    }

    public static void main(String[] args) {
        final char uniqChar = new Solution().firstUniqChar("abaccdeff");
        Assertions.assertEquals(uniqChar, 'b');
    }
}
