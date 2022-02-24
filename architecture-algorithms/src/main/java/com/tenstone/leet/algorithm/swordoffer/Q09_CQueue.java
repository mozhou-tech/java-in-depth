package com.tenstone.leet.algorithm.swordoffer;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by liuyuancheng on 2022/2/24  <br/>
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * 剑指 Offer 09. 用两个栈实现队列
 *
 * @author liuyuancheng
 */
@Slf4j
public class Q09_CQueue {

    static class CQueue {

        private Stack<Integer> stackIn = new Stack<>();

        private Stack<Integer> stackOut = new Stack<>();

        public CQueue() {

        }

        public void appendTail(int value) {
            stackIn.push(value);
        }

        public int deleteHead() {
            if (stackIn.empty() && stackOut.empty()) {
                return -1;
            } else if (stackOut.empty()) {
                while (!stackIn.empty()) {
                    stackOut.push(stackIn.pop());
                }
            }
            return stackOut.pop();
        }
    }

    // 对数器
    public static void main(String[] args) {
        CQueue obj = new CQueue();
        Queue<Integer> queue = new LinkedBlockingQueue<>();
        for (int i = 0; i < 100; i++) {
            obj.appendTail(i);
            queue.add(i);
        }
        while (!queue.isEmpty()) {
            final Integer right = queue.poll();
            final int test = obj.deleteHead();
            log.info("right: {}  test: {}", right, test);
            Assertions.assertEquals((int) queue.poll(), obj.deleteHead());
        }

    }
}
