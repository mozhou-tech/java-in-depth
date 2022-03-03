package leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：2
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 7
 * 输出：21
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：n = 0
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= n <= 100
 * <p>
 * <p>
 * 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/
 * <p>
 * <p>
 * Related Topics 记忆化搜索 数学 动态规划 👍 246 👎 0
 */
public class QingWaTiaoTaiJieWenTiLcof {

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 此类求 多少种可能性 的题目一般都有 递推性质 ，即 f(n)f(n) 和 f(n-1)f(n−1)…f(1)f(1) 之间是有联系的。
         */
        private Map<Integer, Integer> memo = new HashMap<>();

        public int numWays(int n) {
            if (n == 0) return 1;
            if (n == 1) return 1;
            if (memo.containsKey(n)) return memo.get(n);
            int r = (numWays(n - 1) + numWays(n - 2)) % 1000000007;
            memo.put(n, r);
            return r;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Assertions.assertEquals(21, new Solution().numWays(7));
    }
}