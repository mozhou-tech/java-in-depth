package com.tenstone.leet.algorithm.swordoffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by liuyuancheng on 2022/2/26  <br/>
 * <p>
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，
 * 每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 *
 * @author liuyuancheng
 */
public class Q35_CopyListWithRandomPointer01 {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node addNode(int val) {
            this.next = new Node(val);
            return this.next;
        }
    }

    static class Solution {
        /**
         * value可能一样；使用数组辅助链表拷贝
         *
         * @param head
         * @return
         */
        public Node copyRandomList(Node head) {
            // base case
            if (head == null) {
                return null;
            }
            List<Node> arr = new ArrayList<>();
            List<Node> arrCopy = new ArrayList<>();
            Node current = head;
            // build arr
            while (current != null) {
                arr.add(current);
                arrCopy.add(new Node(current.val));
                current = current.next;
            }
            // set next/random pointer
            for (int i = 0; i < arr.size(); i++) {
                if (i + 1 < arr.size()) {
                    arrCopy.get(i).next = arrCopy.get(i + 1);
                } else {
                    arrCopy.get(i).next = null;
                }
                if (arr.get(i).random != null) {
                    int randomNodeIndex = arr.indexOf(arr.get(i).random);
                    arrCopy.get(i).random = arrCopy.get(randomNodeIndex);
                }
            }
            return arrCopy.get(0);
        }
    }

    public static void main(String[] args) {
        Node node7 = new Node(7);
        Node node13 = node7.addNode(13);
        Node node11 = node13.addNode(11);
        Node node10 = node11.addNode(10);
        Node node1 = node10.addNode(1);
        node7.random = null;
        node13.random = node7;
        node11.random = node1;
        node10.random = node11;
        node1.random = node7;
        Node current = node7;
        while (Objects.nonNull(current)) {
            System.out.print(current.val + "->");
            if (current.random != null) {
                System.out.println(current.random.val);
            } else {
                System.out.println();
            }
            current = current.next;
        }
        System.out.println("============================================");
        current = new Solution().copyRandomList(node7);
        while (Objects.nonNull(current)) {
            System.out.print(current.val + "->");
            if (current.random != null) {
                System.out.println(current.random.val);
            } else {
                System.out.println();
            }
            current = current.next;
        }
    }
}
