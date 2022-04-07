package leetcode.editor.cn;

/**
 * 给定一个排序的整数数组 nums 和一个整数目标值 target ，请在数组中找到 target ，并返回其下标。如果目标值不存在于数组中，返回它将会被按顺序插
 * 入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * <p>
 * <p>
 * 示例 4:
 * <p>
 * <p>
 * 输入: nums = [1,3,5,6], target = 0
 * 输出: 0
 * <p>
 * <p>
 * 示例 5:
 * <p>
 * <p>
 * 输入: nums = [1], target = 0
 * 输出: 0
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁴
 * -10⁴ <= nums[i] <= 10⁴
 * nums 为无重复元素的升序排列数组
 * -10⁴ <= target <= 10⁴
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 35 题相同： https://leetcode-cn.com/problems/search-insert-position/
 * Related Topics 数组 二分查找 👍 13 👎 0
 */
public class N6YdxV {
    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0, right = nums.length - 1, res = 0;
            while (left <= right) {
                int mid = (left + right) >> 1;
                if (nums[mid] <= target) {
                    if (nums[mid] == target){
                        res = mid;
                    } else {
                        res = mid + 1;
                    }
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {

    }
}