package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 进阶：
 * <p>
 * <p>
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= nums.length <= 10⁵
 * -10⁹ <= nums[i] <= 10⁹
 * nums 是一个非递减数组
 * -10⁹ <= target <= 10⁹
 * <p>
 * Related Topics 数组 二分查找 👍 1592 👎 0
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int l = -1, r = -1;
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) >> 1;
                if (nums[mid] <= target) {
                    if (nums[mid] == target) {
                        l = r = mid;
                        break;      // 此处是必须的，否则统计结果会有问题
                    }
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            while (l > 0 && nums[l - 1] == target) l--; // 左侧搜索
            while (r < nums.length - 1 && nums[r + 1] == target) r++; // 右侧搜索
            return new int[]{l, r};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }
}