package leetcode.editor.cn;

import leetcode.editor.cn.common.AssertTool;

/**
 * English description is not available for the problem. Please switch to Chinese.
 * Related Topics 递归 数学 👍 270 👎 0
 */
public class ShuZhiDeZhengShuCiFangLcof {

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
         * 快速幂O(logN)   2^7=2^3 * 2^3 *2
         * https://oi-wiki.org/math/quick-pow/
         *
         * @param x
         * @param n
         * @return
         */
        public double myPow(double x, int n) {
            long b = n; // 避免-(-2147483648)=-2147483648的问题，int的正负范围不同
            if (n == 0) return 1;
            if (x == 0) return 0;
            if (b < 0) {
                x = 1 / x;
                b = -b;
            }
            double res = myPow(x, (int) (b / 2));
            if ((b % 2) == 1) return res * res * x;
            return res * res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        final double v = new Solution().myPow(2, -2147483648);
        System.out.println(v);
        //fixme WHY? 最大的正数是2147483647
        AssertTool.assertEquals(-(-2147483648), -2147483648);
    }

}