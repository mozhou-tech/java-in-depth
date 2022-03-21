package leetcode.editor.cn;

/**
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
 * <p>
 * <p>
 * <p>
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * <p>
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的
 * 数字字符组合起来，形成整数。
 * <p>
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * <p>
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * <p>
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * <p>
 * 说明：
 * <p>
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−2³¹, 231 − 1]。如果数值超过这个范围，请返回 INT_MAX (231 −
 * 1) 或 INT_MIN (−2³¹) 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "42"
 * 输出: 42
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * <p>
 * <p>
 * 示例 4:
 * <p>
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 * 因此无法执行有效的转换。
 * <p>
 * 示例 5:
 * <p>
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−2³¹) 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 8 题相同：https://leetcode-cn.com/problems/string-to-integer-atoi/
 * Related Topics 字符串 👍 149 👎 0
 */
public class BaZiFuChuanZhuanHuanChengZhengShuLcof {
    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 从左向右递推，逐位判断
         *
         * @param str
         * @return
         */
        public int strToInt(String str) {
            if (str == null || str.length() == 0) return 0;
            int sIdx = 0, sign = 1;
            long res = 0;
            // 搜索到第一位非空字符
            while (sIdx < str.length() - 1 && str.charAt(sIdx) == ' ') sIdx++;
            // 处理符号位
            if (str.charAt(sIdx) == '-') {
                sign = -1;
                sIdx++;
            } else if (str.charAt(sIdx) == '+') sIdx++;
            // 如果符号位后非数字或索引超过字符串长度，返回0
            if (str.length() - 1 < sIdx || !Character.isDigit(str.charAt(sIdx))) return 0;
            while (sIdx < str.length() && Character.isDigit(str.charAt(sIdx))) {
                // 整数每增长一位，
                res = res * 10 + (str.charAt(sIdx) - '0');
                if (res > Integer.MAX_VALUE) return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                sIdx++;
            }
            return (int) (sign * res);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        final int i = new Solution().strToInt(" ");
        System.out.println(i);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}

