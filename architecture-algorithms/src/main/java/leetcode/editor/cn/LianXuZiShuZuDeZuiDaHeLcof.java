package leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * <p>
 * 要求时间复杂度为O(n)。
 * <p>
 * <p>
 * <p>
 * 示例1:
 * <p>
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 * <p>
 * <p>
 * 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/
 * <p>
 * <p>
 * Related Topics 数组 分治 动态规划 👍 470 👎 0
 */
public class LianXuZiShuZuDeZuiDaHeLcof {


    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxSubArray(int[] nums) {
            if (nums.length < 1) return 0;
            // 滚动数组思想，压缩dp空间
            int pre = 0, dp = nums[0];
            for (int num : nums) {
                // 如果pre+num小于num，则说明pre小于0，对num负贡献，舍弃后取新的num
                pre = Math.max(pre + num, num);
                dp = Math.max(dp, pre);
            }
            return dp;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Assertions.assertEquals(new Solution().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}), 6);
    }
}