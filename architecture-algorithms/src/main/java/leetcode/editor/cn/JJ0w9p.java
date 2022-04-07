package leetcode.editor.cn;

/**
 * 给定一个非负整数 x ，计算并返回 x 的平方根，即实现 int sqrt(int x) 函数。
 * <p>
 * 正数的平方根有两个，只输出其中的正数平方根。
 * <p>
 * 如果平方根不是整数，输出只保留整数的部分，小数部分将被舍去。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: x = 4
 * 输出: 2
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: x = 8
 * 输出: 2
 * 解释: 8 的平方根是 2.82842...，由于小数部分将被舍去，所以返回 2
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 0 <= x <= 2³¹ - 1
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 69 题相同： https://leetcode-cn.com/problems/sqrtx/
 * Related Topics 数学 二分查找 👍 16 👎 0
 */
public class JJ0w9p {
    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            long left = 0, right = x;
            int res = -1;
            while (left <= right) {
                long mid = (right + left) >> 1;
                if (mid * mid <= x) { // 小于号使小数点后面的数字舍去
                    res = (int) mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {

    }
}