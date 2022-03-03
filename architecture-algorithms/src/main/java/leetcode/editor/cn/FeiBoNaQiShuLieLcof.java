package leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * <p>
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * <p>
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 2
 * 输出：1
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 5
 * 输出：5
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= n <= 100
 * <p>
 * Related Topics 记忆化搜索 数学 动态规划 👍 307 👎 0
 */
public class FeiBoNaQiShuLieLcof {

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private Map<Integer, Integer> memo = new HashMap<>();

        /**
         * 记忆化递归=动态规划
         * @param n
         * @return
         */
        public int fib(int n) {
            // base case
            if (n == 1) return 1;
            if (n == 0) return 0;
            if (memo.containsKey(n)) return memo.get(n);
            // n > 1 时
            int r = (fib(n - 1) + fib(n - 2)) % 1000000007;
            memo.put(n, r);
            return r;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Assertions.assertEquals(134903163, new Solution().fib(45));
    }
}