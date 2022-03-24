package leetcode.editor.cn;

/**
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * <p>
 * 说明:
 * <p>
 * <p>
 * 1 是丑数。
 * n 不超过1690。
 * <p>
 * <p>
 * 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/
 * Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 310 👎 0
 */
public class ChouShuLcof {
    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 丑数的递推性质：丑数只包含因子 2, 3, 5，因此有 “丑数 == 某较小丑数 × 某因子”
         * 例如：10=5×2
         *
         * @param n
         * @return
         */
        public int nthUglyNumber(int n) {
            int a = 0, b = 0, c = 0;
            int[] dp = new int[n];
            dp[0] = 1;
            for (int i = 1; i < n; i++) {
                int n2 = 2 * dp[a], n3 = 3 * dp[b], n5 = 5 * dp[c];
                dp[i] = Math.min(Math.min(n5, n2), n3);
                if (dp[i] == n2) a++;
                if (dp[i] == n3) b++;
                if (dp[i] == n5) c++;
            }
            return dp[n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {

    }
}