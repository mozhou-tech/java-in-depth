package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= nums.length <= 50000
 * 0 <= nums[i] <= 10000
 * <p>
 * Related Topics 数组 双指针 排序 👍 204 👎 0
 */
public class DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof {

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 复杂度O(N)
         *
         * @param nums
         * @return
         */
        public int[] exchange(int[] nums) {
            if (nums.length < 2) return nums;
            int size = nums.length;
            int left = 0, right = size - 1;
            //TODO 注意while的条件(数组处理)
            while (left < right) {
                if (isOdd(nums[left])) {
                    left++;
                    continue;
                }
                if (!isOdd(nums[right])) {
                    right--;
                    continue;
                }
                if (!isOdd(nums[left]) && isOdd(nums[right])) {
                    swap(nums, left, right);
                    left++;
                    right--;
                }
            }
            return nums;
        }

        private boolean isOdd(int num) {
            return num % 2 == 1;
        }

        private void swap(int[] nums, int a, int b) {
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        final int[] nums = {1, 2, 3, 4};
        new Solution().exchange(nums);
        System.out.println(Arrays.toString(nums));
    }
}