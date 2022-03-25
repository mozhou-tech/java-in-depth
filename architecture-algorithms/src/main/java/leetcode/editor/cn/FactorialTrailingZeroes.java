package leetcode.editor.cn;

/**
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 * <p>
 * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 3
 * 输出：0
 * 解释：3! = 6 ，不含尾随 0
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 5
 * 输出：1
 * 解释：5! = 120 ，有一个尾随 0
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：n = 0
 * 输出：0
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= n <= 10⁴
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：你可以设计并实现对数时间复杂度的算法来解决此问题吗？
 * Related Topics 数学 👍 578 👎 0
 */
public class FactorialTrailingZeroes {
    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 使用递归，为何会溢出？
         * 0 <= n <= 10⁴ 看数据范围
         * 包含因子：2/5
         * 不需要把值算出来，找到对应的因子即可
         *
         * @param n
         * @return
         */
        public int trailingZeroes(int n) {
            int n2 = 0, n5 = 0;
            for (int i = n; i >= 1; i--) {
                if (i % 2 != 0 && i % 5 != 0) continue;
                int x = i;
                while (x % 2 == 0) {
                    n2++;
                    x /= 2;
                }
                while (x % 5 == 0) {
                    n5++;
                    x /= 5;
                }
            }
            return Math.min(n2, n5);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        System.out.println(new Solution().trailingZeroes(50));
    }
}