package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * English description is not available for the problem. Please switch to Chinese.
 * Related Topics 设计 双指针 数据流 排序 堆（优先队列） 👍 271 👎 0
 */
public class ShuJuLiuZhongDeZhongWeiShuLcof {

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {

        private final List<Integer> data;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            this.data = new ArrayList<>();
        }

        public void addNum(int num) {
            if (this.data.size() == 0) {
                this.data.add(num);
                return;
            }
            // 找到右侧最近的
            int targetIndex = binarySearch(0, this.data.size() - 1, num);
            this.data.add(targetIndex, num);
        }

        public double findMedian() {
            int mod = this.data.size() % 2;
            int mid = this.data.size() / 2 - 1;
            if (mod == 1) return this.data.get(mid + 1);
            return (this.data.get(mid) + this.data.get(mid + 1)) / 2D;
        }

        /**
         * 二分法查找到合适的插入位置
         *
         * @param target
         * @return
         */
        int binarySearch(int start, int end, int target) {
            if (target > this.data.get(end)) return end + 1;
            // base case
            int diff = end - start;
            if (diff == 0 && this.data.get(start) >= target) return start;
            if (diff == 0 && this.data.get(start) < target) return start + 1;
            if (diff == 1 && this.data.get(start) >= target) return start;
            if (diff == 1 && this.data.get(start) < target && this.data.get(end) > target) return end;
            if (diff == 1 && this.data.get(end) <= target) return end + 1;
            int mid = (end + start) / 2;
            if (this.data.get(mid) < target && this.data.get(end) >= target) {
                return binarySearch(mid, end, target);
            }
            return binarySearch(start, mid, target);
        }
    }

    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */
//leetcode submit region end(Prohibit modification and deletion)
    public static void main(String[] args) {
        final MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.findMedian();
        medianFinder.addNum(3);
        medianFinder.addNum(4);
        medianFinder.addNum(5);
        medianFinder.addNum(6);
        medianFinder.addNum(7);
        medianFinder.addNum(8);
        medianFinder.addNum(9);
        medianFinder.addNum(10);
        medianFinder.findMedian();
    }
}