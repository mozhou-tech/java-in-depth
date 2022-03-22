package leetcode.editor.cn;

import leetcode.editor.cn.common.AssertTool;

import java.util.Deque;
import java.util.LinkedList;

/**
 * /**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是
 * O(1)。
 * <p>
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 * <p>
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * <p>
 * 1 <= push_back,pop_front,max_value的总操作数 <= 10000
 * 1 <= value <= 10^5
 * <p>
 * Related Topics 设计 队列 单调队列 👍 336 👎 0
 */

public class DuiLieDeZuiDaZhiLcof {
    static
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 本质上是一个求滑动窗口最大值的问题。
     * 这个队列可以看成是一个滑动窗口，入队就是将窗口的右边界右移，出队就是将窗口的左边界右移。
     */
    class MaxQueue {

        private Deque<Integer> deque;

        /**
         * min->max
         */
        private Deque<Integer> maxDeque;

        public MaxQueue() {
            deque = new LinkedList<>();
            maxDeque = new LinkedList<>();
        }

        public int max_value() {
            if (maxDeque.isEmpty()) return -1;
            return maxDeque.peekLast();
        }

        public void push_back(int value) {
            deque.addLast(value);
            while (!maxDeque.isEmpty() && maxDeque.peekFirst() < value) maxDeque.pollFirst();
            maxDeque.addFirst(value);
        }

        public int pop_front() {
            if (deque.isEmpty()) return -1;
            final Integer val = deque.pollFirst();
            if (val.equals(maxDeque.peekLast())) {
                maxDeque.pollLast();
            }
            return val;
        }
    }

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
//leetcode submit region end(Prohibit modification and deletion)


    /**
     * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
     * [[],[1],[2],[],[],[]]
     * 输出: [null,null,null,2,1,2]
     *
     * @param args
     */
    public static void main(String[] args) {
        final MaxQueue queue = new MaxQueue();
        queue.push_back(1);
        queue.push_back(2);
        AssertTool.assertEquals(2, queue.max_value());
        AssertTool.assertEquals(1, queue.pop_front());
        AssertTool.assertEquals(2, queue.max_value());
    }
}