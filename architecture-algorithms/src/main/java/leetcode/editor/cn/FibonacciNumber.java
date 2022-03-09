package leetcode.editor.cn;

import leetcode.editor.cn.common.AssertTool;

/**
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * <p>
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * <p>
 * <p>
 * 给定 n ，请计算 F(n) 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：n = 4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= n <= 30
 * <p>
 * Related Topics 递归 记忆化搜索 数学 动态规划 👍 412 👎 0
 */
public class FibonacciNumber {

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int fib(int n) {
            int[] dp = new int[n + 2]; // 数组的大小如何决定？
            dp[0] = 0;
            dp[1] = 1;
            return recur(dp, n);
        }

        //TODO 防止重复创建数组，把dp的创建放在递归之外
        public int recur(int[] dp, int n) {
            if (n == 0) return 0;
            if (dp[n] != 0) return dp[n]; // 记忆化搜索
            dp[n] = recur(dp, n - 1) + recur(dp, n - 2);
            return dp[n];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        AssertTool.assertEquals(2, new Solution().fib(3));
        AssertTool.assertEquals(3, new Solution().fib(4));
    }
}