package com.tenstone.leet.algorithm.swordoffer;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuyuancheng on 2022/2/25  <br/>
 *
 * @author liuyuancheng
 */
public class Q30_MinStack {

    static class MinStack {

        private int size;

        private List<Integer> minValueList = new ArrayList<>();

        private List<Integer> store = new ArrayList<>();

        public MinStack() {

        }

        public void push(int x) {
            store.add(x);
            if (minValueList.isEmpty()) {
                minValueList.add(x);
            } else {
                minValueList.add(Math.min(minValueList.get(size - 1), x));
            }
            size++;
        }

        public void pop() {
            int popValue = store.remove(size - 1);
            size--;
            // 删除第一次匹配的元素
            minValueList.remove(Integer.valueOf(popValue));
        }

        public int top() {
            return store.get(size - 1);
        }

        public int min() {
            return minValueList.get(size - 1);
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        Assertions.assertEquals(-1024, minStack.min());
        minStack.pop();
        Assertions.assertEquals(-1024, minStack.min());
        minStack.pop();
        Assertions.assertEquals(512, minStack.min());
    }
}
