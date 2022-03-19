package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[i]
 * =A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 所有元素乘积之和不会溢出 32 位整数
 * a.length <= 100000
 * <p>
 * Related Topics 数组 前缀和 👍 207 👎 0
 */
public class GouJianChengJiShuZuLcof {
    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 朴素的暴力计算，存在大量重复运算
         *
         * @param a
         * @return
         */
        public int[] constructArr(int[] a) {
            if (a.length == 0) return new int[0];
            int[] b = new int[a.length];
            b[0] = 1; // 第1位
            int tmp = 1;
            // 左下三角
            for (int i = 1; i < a.length; i++) {
                b[i] = b[i - 1] * a[i - 1];
            }
            // 右上三角
            for (int i = a.length - 2; i >= 0; i--) {
                tmp *= a[i + 1];
                b[i] *= tmp;
            }
            return b;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 3, 4, 5};
        final int[] ints1 = new Solution().constructArr(ints);
        System.out.println(Arrays.toString(ints1));
    }
}