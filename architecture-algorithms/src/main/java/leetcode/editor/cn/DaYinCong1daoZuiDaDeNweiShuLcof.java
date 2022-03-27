package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 * <p>
 * <p>
 * <p>
 * <p>
 * 说明：
 * <p>
 * <p>
 * 用返回一个整数列表来代替打印
 * n 为正整数
 * <p>
 * Related Topics 数组 数学 👍 210 👎 0
 */
public class DaYinCong1daoZuiDaDeNweiShuLcof {
    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] printNumbers(int n) {
            int max = (int) Math.pow(10, n) - 1;
            int[] res = new int[max];
            for (int i = 1; i < res.length + 1; i++) {
                res[i - 1] = i;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        final int[] ints = new Solution().printNumbers(1);
        System.out.println(Arrays.toString(ints));
    }
}