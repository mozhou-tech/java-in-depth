package leetcode.editor.cn;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * <p>
 * 示例 2:
 * <p>
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2³¹, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 * <p>
 * Related Topics 位运算 数学 👍 872 👎 0
 */
public class DivideTwoIntegers {
    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int divide(int dividend, int divisor) {
            if (dividend == 0) return 0;
            if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
            boolean negative = (dividend ^ divisor) < 0;//用异或来计算是否符号相异
            long dividendLong = Math.abs((long) dividend); //
            long divisorLong = Math.abs((long) divisor);
            int result = 0;
            // （2^31）-1  为最大值，逐个试探
            for (int i = 31; i >= 0; i--) {
                if ((dividendLong >> i) >= divisorLong) {//找出足够大的数2^n*divisor
                    result += 1 << i;//将结果加上2^n
                    dividendLong -= divisorLong << i;//将被除数减去2^n*divisor
                }
            }
            return negative ? -result : result;//符号相异取反
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        final int divide = new Solution().divide(Integer.MAX_VALUE, 10);
        System.out.println(divide);
    }
}