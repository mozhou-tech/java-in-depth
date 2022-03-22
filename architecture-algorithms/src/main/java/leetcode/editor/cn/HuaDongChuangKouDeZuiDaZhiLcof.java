package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 * <p>
 * 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/
 * Related Topics 队列 滑动窗口 单调队列 堆（优先队列） 👍 412 👎 0
 */
public class HuaDongChuangKouDeZuiDaZhiLcof {
    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if(nums.length == 0 || k == 0) return new int[0];
            Deque<Integer> deque = new LinkedList<>();
            int[] res = new int[nums.length - k + 1];
            // 基于for的双指针
            for(int right = 0, left = 1 - k; right < nums.length; left++, right++) {
                // 如果栈头和当前元素一样，则删除
                if(left > 0 && deque.peekFirst() == nums[left - 1]) deque.removeFirst();
                // 从栈尾删除较小的数字，保持队列递减
                while(!deque.isEmpty() && deque.peekLast() < nums[right]) deque.removeLast();
                deque.addLast(nums[right]);
                // 记录窗口最大值
                if(left >= 0) res[left] = deque.peekFirst();
            }
            return res;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        int[] inputs = new int[]{9, 10, 9, -7, -4, -8, 2, -6};
        final int[] results = new Solution().maxSlidingWindow(inputs, 5);
        // should be [10,10,9,2]
        System.out.println(Arrays.toString(results));
    }
}