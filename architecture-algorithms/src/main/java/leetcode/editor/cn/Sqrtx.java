package leetcode.editor.cn;

/**
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * <p>
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * <p>
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：x = 4
 * 输出：2
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= x <= 2³¹ - 1
 * <p>
 * Related Topics 数学 二分查找 👍 946 👎 0
 */
public class Sqrtx {
    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            int left = 0, right = x, res = 0;
            while (left <= right) {
                int mid = ((right - left) >> 1) + left;
                // mid 小，
                if ((long) mid * mid <= x) {
                    res = mid;      // 相当于向下取整
                    left = mid + 1; // mid本身排除在外
                } else {
                    right = mid - 1; // mid 本身排除在外
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        final int i = new Solution().mySqrt(4);
        System.out.println(i);
    }
}