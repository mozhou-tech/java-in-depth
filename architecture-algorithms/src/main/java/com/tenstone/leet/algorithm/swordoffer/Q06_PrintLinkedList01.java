package com.tenstone.leet.algorithm.swordoffer;

import org.junit.jupiter.api.Assertions;

import java.util.Objects;
import java.util.Stack;

/**
 * Created by liuyuancheng on 2022/2/25  <br/>
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 *
 * @author liuyuancheng
 */
public class Q06_PrintLinkedList01 {

    static class ListNode {
        ListNode next;
        int val;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode addNext(int val) {
            if (Objects.isNull(this.next)) {
                this.next = new ListNode(val);
                return this.next;
            } else {
                return this;
            }
        }
    }

    static class Solution {

        private Stack<Integer> stack = new Stack<>();

        /**
         * 适合LIFO栈的倒序结构，考虑递归
         *
         * @param head
         * @return
         */
        public int[] reversePrint(ListNode head) {
            ListNode current = head;
            while (Objects.nonNull(current)) {
                stack.push(current.val);
                current = current.next;
            }
            int[] returning = new int[stack.size()];
            for (int i = 0; i < returning.length; i++) {
                returning[i] = stack.pop();
            }
            return returning;
        }

    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.addNext(3).addNext(2).addNext(5);
        final int[] result = new Solution().reversePrint(root);
        int[] ref = new int[]{5, 2, 3, 1};
        for (int i = 0; i < ref.length; i++) {
            Assertions.assertEquals(result[i], ref[i]);
        }
    }
}
