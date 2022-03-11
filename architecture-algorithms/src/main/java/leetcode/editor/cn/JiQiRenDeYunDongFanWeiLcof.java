package leetcode.editor.cn;

import leetcode.editor.cn.common.AssertTool;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（
 * 不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不
 * 能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 * <p>
 * Related Topics 深度优先搜索 广度优先搜索 动态规划 👍 457 👎 0
 */
public class JiQiRenDeYunDongFanWeiLcof {

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int m, n, k;
        boolean[][] visited;
        public int movingCount(int m, int n, int k) {
            this.m = m; this.n = n; this.k = k;
            this.visited = new boolean[m][n];
            return dfs(0, 0, 0, 0);
        }

        public int dfs(int i, int j, int si, int sj) {
            if(i >= m || j >= n || k < si + sj || visited[i][j]) return 0;
            visited[i][j] = true;
            return 1 + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj) + dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
        }

        // 计算两个坐标数字的和
        private int sum(int i, int j) {
            int sum = 0;
            while (i != 0) {
                sum += i % 10;
                i /= 10;
            }
            while (j != 0) {
                sum += j % 10;
                j /= 10;
            }
            return sum;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        final int res = new Solution().movingCount(2, 3, 1);
        AssertTool.assertEquals(3, res);
    }
}