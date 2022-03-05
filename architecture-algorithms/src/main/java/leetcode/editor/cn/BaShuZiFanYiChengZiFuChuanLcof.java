package leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= num < 2³¹
 * <p>
 * Related Topics 字符串 动态规划 👍 380 👎 0
 */
public class BaShuZiFanYiChengZiFuChuanLcof {

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // STEP 1： 寻找子问题
        // STEP 2: 状态转移方程
        // 总结：限制条件的跳台阶（转移条件）
        // 递推方程（转移方程）需要严格的数学证明
        public int translateNum(int num) {
            String s = String.valueOf(num);
            int[] dp = new int[s.length() + 1];
            // 基本情况(取0位/取1位)
            dp[0] = dp[1] = 1;
            // 状态转移到基本情况(次数i，代表dp的index)
            for (int i = 2; i <= s.length(); i++) {
                int lastTowNum = Integer.parseInt(s.substring(i - 2, i));
                if (lastTowNum <= 25 && lastTowNum >= 10) {
                    //可以整体翻译 整体翻译s[i-1]s[i]
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    dp[i] = dp[i - 1];
                }
            }
            return dp[s.length()];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Assertions.assertEquals(2, new Solution().translateNum(25));
    }
}