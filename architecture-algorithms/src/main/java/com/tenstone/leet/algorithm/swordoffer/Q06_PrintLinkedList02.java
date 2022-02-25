package com.tenstone.leet.algorithm.swordoffer;

import org.junit.jupiter.api.Assertions;

import java.util.Objects;

/**
 * Created by liuyuancheng on 2022/2/25  <br/>
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 *
 * @author liuyuancheng
 */
public class Q06_PrintLinkedList02 {

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

        static class Solution {

            private int size = 0;

            /**
             * 方法，逆序放到数组：先放最末位以此类推
             *
             * @param head
             * @return
             */
            public int[] reversePrint(ListNode head) {
                int[] returning = new int[size];
                ListNode current = head;
                while (Objects.nonNull(current)) {
                    size++;
                    // 创建新的数组
                    int[] returningTempt = new int[size];
                    // 最后1位赋值
                    returningTempt[0] = current.val;
                    // 上一次的returning要放在后面
                    // 数组拷贝，时间复杂度高，占用空间大
                    System.arraycopy(returning, 0, returningTempt, 1, returning.length);
                    returning = returningTempt;
                    current = current.next;
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
}
