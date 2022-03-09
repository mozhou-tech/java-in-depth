package leetcode.editor.cn;

import leetcode.editor.cn.common.AssertTool;

/**
 * /**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 45
 * <p>
 * Related Topics 记忆化搜索 数学 动态规划 👍 2242 👎 0
 */

public class ClimbingStairs {

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int climbStairs(int n) {
            int[] dp = new int[n + 2];
            dp[0] = 1;
            dp[1] = 1;
            return recur(dp, n);
        }

        private int recur(int[] dp, int n) {
            if (n == 0) return dp[0];
            if (dp[n] != 0) return dp[n];
            dp[n] = recur(dp, n - 1) + recur(dp, n - 2);
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        AssertTool.assertEquals(1, new Solution().climbStairs(1));
        AssertTool.assertEquals(2, new Solution().climbStairs(2));
        AssertTool.assertEquals(3, new Solution().climbStairs(3));
    }
}