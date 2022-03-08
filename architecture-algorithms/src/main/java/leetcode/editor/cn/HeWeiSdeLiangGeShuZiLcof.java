package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 * <p>
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 * <p>
 * Related Topics 数组 双指针 二分查找 👍 168 👎 0
 */
public class HeWeiSdeLiangGeShuZiLcof {

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //TODO 对撞双指针！！！
        //哈希表的时间空间复杂度都是O(n)，双指针可以把空间复杂度降为O(1)
        public int[] twoSum(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int s = nums[left] + nums[right];
                if (s < target) left++;
                else if (s > target) right--;
                else return new int[]{nums[left], nums[right]};
            }
            return new int[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        final int[] ints = new Solution().twoSum(new int[]{10, 26, 30, 31, 47, 60}, 40);
        System.out.println(Arrays.toString(ints));
    }
}