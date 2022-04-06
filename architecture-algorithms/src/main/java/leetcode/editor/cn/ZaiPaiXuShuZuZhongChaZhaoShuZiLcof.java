package leetcode.editor.cn;

/**
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
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
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
 * position-of-element-in-sorted-array/
 * Related Topics 数组 二分查找 👍 290 👎 0
 */
public class ZaiPaiXuShuZuZhongChaZhaoShuZiLcof {
    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int cnt = 0, t = -1;
            int left = 0, right = nums.length - 1;
            int mid = -1;
            while (left <= right) {
                mid = (left + right) >> 1;
                if (nums[mid] <= target) {
                    if (nums[mid] == target) {
                        cnt++;
                        break;      // 此处是必须的，否则统计结果会有问题
                    }
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (cnt == 0) return 0;
            t = mid;
            while (t > 0 && nums[--t] == target) cnt++;  // 左侧搜索
            t = mid;
            while (t < nums.length - 1 && nums[++t] == target) cnt++; // 右侧搜索
            return cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{5, 7, 7, 8, 8, 8}, 8));
    }
}