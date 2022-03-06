package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算滑动窗口里所有数字的平均值。
 * <p>
 * 实现 MovingAverage 类：
 * <p>
 * <p>
 * MovingAverage(int size) 用窗口大小 size 初始化对象。
 * double next(int val) 成员函数 next 每次调用的时候都会往滑动窗口增加一个整数，请计算并返回数据流中最后 size 个值的移动平均值，
 * 即滑动窗口里所有数字的平均值。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * 输入：
 * inputs = ["MovingAverage", "next", "next", "next", "next"]
 * inputs = [[3], [1], [10], [3], [5]]
 * 输出：
 * [null, 1.0, 5.5, 4.66667, 6.0]
 * <p>
 * 解释：
 * MovingAverage movingAverage = new MovingAverage(3);
 * movingAverage.next(1); // 返回 1.0 = 1 / 1
 * movingAverage.next(10); // 返回 5.5 = (1 + 10) / 2
 * movingAverage.next(3); // 返回 4.66667 = (1 + 10 + 3) / 3
 * movingAverage.next(5); // 返回 6.0 = (10 + 3 + 5) / 3
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= size <= 1000
 * -10⁵ <= val <= 10⁵
 * 最多调用 next 方法 10⁴ 次
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 346 题相同： https://leetcode-cn.com/problems/moving-average-from-data-
 * stream/
 * Related Topics 设计 队列 数组 数据流 👍 14 👎 0
 */
public class QIsx9U {

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class MovingAverage {

        private int size;

        private int sum;

        /**
         * LinkedList 实现了queue接口
         */
        private Queue<Integer> queue;

        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            this.size = size;
            queue = new LinkedList<>();
        }

        public double next(int val) {
            queue.offer(val);
            sum += val;
            if (queue.size() <= size) {
                return sum / (double) queue.size();
            } else {
                sum -= queue.poll();
                return sum / (double) queue.size();
            }
        }
    }

    /**
     * Your MovingAverage object will be instantiated and called as such:
     * MovingAverage obj = new MovingAverage(size);
     * double param_1 = obj.next(val);
     */
//leetcode submit region end(Prohibit modification and deletion)
    public static void main(String[] args) {
        final MovingAverage movingAverage = new MovingAverage(3);
        System.out.println(movingAverage.next(1));
        System.out.println(movingAverage.next(10));
        System.out.println(movingAverage.next(3));
        System.out.println(movingAverage.next(5));
    }
}