package com.tenstone.leet.algorithm.swordoffer;

import org.junit.jupiter.api.Assertions;

import java.util.Objects;
import java.util.Stack;

/**
 * Created by liuyuancheng on 2022/2/25  <br/>
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * @author liuyuancheng
 */
public class Q26_ReverseLinkedList02 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
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

    /**
     * 递归+回溯
     */
    static class Solution {

        private Stack<ListNode> stack = new Stack<>();

        public ListNode reverseList(ListNode head) {
            return null;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addNext(2).addNext(3).addNext(4).addNext(5);
        ListNode reversedHead = new Solution().reverseList(head);
        ListNode current = reversedHead;
        int[] expected = new int[]{5, 4, 3, 2, 1};
        int i = 0;
        while (Objects.nonNull(current)) {
            Assertions.assertEquals(current.val, expected[i]);
            i++;
            current = current.next;
        }
    }
}
