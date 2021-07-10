package com.tenstone.leet.question.linked_list.q2_add_two_numbers;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 * <p>
 * 两数相加
 * Created by liuyuancheng on 2021/7/3  <br/>
 */
@Slf4j
public class Main {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
        ListNode(int x, ListNode next){
            this.val = x;
            this.next = next;
        }
        @Override
        public String toString(){
            StringBuilder stringBuilder = new StringBuilder("");
            ListNode crr = this;
            while (Objects.nonNull(crr.next)){
                stringBuilder.append(val);
                crr = crr.next;
            }
            return stringBuilder.toString();
        }
    }

    static class Solution {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummyNode = new ListNode(0), curr, q, p;
            // 是否进位
            int carry = 0, sum = 0;
            q = l1;
            p = l2;
            curr = dummyNode; // 存放计算结果
            while (q != null || p != null) {
                sum = carry + (q == null ? 0 : q.val) + (p == null ? 0 : p.val);
                carry = sum / 10;
                curr.next = new ListNode(sum % 10);
                curr = curr.next;
                if (q != null) {
                    q = q.next;
                }
                if (p != null) {
                    p = p.next;
                }
            }
            if (carry > 0) {
                curr.next = new ListNode(1);
            }
            return dummyNode.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2,new ListNode(4,new ListNode(3)));
        ListNode l2 = new ListNode(5,new ListNode(4,new ListNode(6)));
        var t = new Main.Solution().addTwoNumbers(l1,l2);
    }
}
