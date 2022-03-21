package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],
 * [4,5,6],
 * [7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * <p>
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 * <p>
 * <p>
 * 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
 * Related Topics 数组 矩阵 模拟 👍 377 👎 0
 */
public class ShunShiZhenDaYinJuZhenLcof {
    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * “从左向右、从上向下、从右向左、从下向上” 循环
         * @param matrix
         * @return
         */
        public int[] spiralOrder(int[][] matrix) {
            if (matrix.length == 0) return new int[0];
            int left = 0,
                    right = matrix[0].length - 1,
                    top = 0,
                    bottom = matrix.length - 1,
                    x = 0;
            int[] res = new int[(right + 1) * (bottom + 1)];
            while (true) {
                for (int i = left; i <= right; i++) res[x++] = matrix[top][i]; // left to right.
                if (++top > bottom) break; // 结束一行后，top下移缩小遍历范围；出现越界退出循环
                for (int i = top; i <= bottom; i++) res[x++] = matrix[i][right]; // top to bottom.
                if (left > --right) break; // 同上
                for (int i = right; i >= left; i--) res[x++] = matrix[bottom][i]; // right to left.
                if (top > --bottom) break; // 同上
                for (int i = bottom; i >= top; i--) res[x++] = matrix[i][left]; // bottom to top.
                if (++left > right) break; // 同上
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        int[][] inputs = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        final int[] ints = new Solution().spiralOrder(inputs);
        System.out.println(Arrays.toString(ints));
    }
}