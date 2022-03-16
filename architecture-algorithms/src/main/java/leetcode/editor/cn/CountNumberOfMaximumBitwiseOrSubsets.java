package leetcode.editor.cn;

/**
 * Given an integer array nums, find the maximum possible bitwise OR of a subset
 * of nums and return the number of different non-empty subsets with the maximum
 * bitwise OR.
 * <p>
 * An array a is a subset of an array b if a can be obtained from b by deleting
 * some (possibly zero) elements of b. Two subsets are considered different if the
 * indices of the elements chosen are different.
 * <p>
 * The bitwise OR of an array a is equal to a[0] OR a[1] OR ... OR a[a.length - 1]
 * (0-indexed).
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: nums = [3,1]
 * Output: 2
 * Explanation: The maximum possible bitwise OR of a subset is 3. There are 2
 * subsets with a bitwise OR of 3:
 * - [3]
 * - [3,1]
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: nums = [2,2,2]
 * Output: 7
 * Explanation: All non-empty subsets of [2,2,2] have a bitwise OR of 2. There are
 * 2³ - 1 = 7 total subsets.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: nums = [3,2,1,5]
 * Output: 6
 * Explanation: The maximum possible bitwise OR of a subset is 7. There are 6
 * subsets with a bitwise OR of 7:
 * - [3,5]
 * - [3,1,5]
 * - [3,2,5]
 * - [3,2,1,5]
 * - [2,5]
 * - [2,1,5]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= nums.length <= 16
 * 1 <= nums[i] <= 10⁵
 * <p>
 * Related Topics 位运算 数组 回溯 👍 93 👎 0
 */
public class CountNumberOfMaximumBitwiseOrSubsets {

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[] nums;

        int maxOr, cnt;

        public int countMaxOrSubsets(int[] nums) {
            this.nums = nums;
            this.maxOr = 0;
            this.cnt = 0;
            dfs(0, 0);
            return cnt;
        }

        /**
         * 回溯
         *
         * @param pos   数组索引
         * @param orVal
         */
        public void dfs(int pos, int orVal) {
            if (pos == nums.length) { // 遍历到最后一个位置后回溯
                if (orVal < maxOr) return;
                if (orVal > maxOr) {
                    maxOr = orVal;
                    cnt = 1;
                } else {
                    cnt++;  // orVal == maxOr
                }
            }
            // 此处用到bit-wise or的性质：有乘法运算类似的结合律 (a|b)|c = a|(b|c)
            dfs(pos + 1, orVal | nums[pos]);
            dfs(pos + 1, orVal);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        int num = 4;
        System.out.println(num | 3);
    }
}