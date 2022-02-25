package com.tenstone.leet.algorithm.swordoffer;

import org.junit.jupiter.api.Assertions;

import java.util.Stack;

/**
 * Created by liuyuancheng on 2022/2/25  <br/>
 * <p>
 * 最小栈 先写操作流程注释再写代码
 * Stack底层基于Vector，可以使用Vector提供的方法
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 *
 * @author liuyuancheng
 */
public class Q30_MinStack {

    static class MinStack {

        private Stack<Integer> a = new Stack<>();

        /**
         * 辅助栈，从上往下升序排列
         */
        private Stack<Integer> b = new Stack<>();

        public MinStack() {

        }

        public void push(int x) {
            a.push(x);
            if (b.isEmpty() || b.peek() >= x) {
                b.push(x);
            } else {
                int stackSize = b.size();
                for (int i = stackSize - 1; i >= 0; i--) {
                    if (b.get(i) >= x) {
                        b.insertElementAt(x, i);
                        // 记得要跳出循环
                        break;
                    }
                }
            }
        }

        public void pop() {
            int popVal = a.pop();
            b.removeElement(popVal);
        }

        public int top() {
            return a.peek();
        }

        public int min() {
            return b.peek();
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        System.out.println(minStack.a);
        System.out.println(minStack.b);
        minStack.pop();
        Assertions.assertEquals(-1024, minStack.min());
        minStack.pop();
        Assertions.assertEquals(-1024, minStack.min());
        minStack.pop();
        Assertions.assertEquals(512, minStack.min());
        Assertions.assertEquals(512, minStack.top());
        //====================================
    }
}
