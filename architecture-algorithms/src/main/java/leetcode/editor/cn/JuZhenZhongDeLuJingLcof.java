package leetcode.editor.cn;

import leetcode.editor.cn.common.AssertTool;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * <p>
 * <p>
 * 例如，在下面的 3×4 的矩阵中包含单词 'ABCCED'（单词中的字母已标出）。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word =
 * 'ABCCED'
 * 输出：true
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：board = [['a','b'],['c','d']], word = 'abcd'
 * 输出：false
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * board 和 word 仅由大小写英文字母组成
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/
 * Related Topics 数组 回溯 矩阵 👍 536 👎 0
 */
public class JuZhenZhongDeLuJingLcof {

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 按照字母顺序,不允许重复使用,相邻
        //TODO 深度优先搜索
        public boolean exist(char[][] board, String word) {
            char[] words = word.toCharArray();
            // O(N^2)
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (dfs(board, words, i, j, 0)) return true;
                }
            }
            return false;
        }

        /**
         * 深度优先搜索
         *
         * @param board
         * @param word  word chars
         * @param i     行索引
         * @param j     列索引
         * @param k     word的索引，起始位为0
         * @return
         */
        boolean dfs(char[][] board, char[] word, int i, int j, int k) {
            // 搜索终结条件: 数组越界、不相等
            if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
            if (k == word.length - 1) return true; // 递归到word的最后一个字符
            board[i][j] = '.';// 标记为空字符
            boolean res = dfs(board, word, i + 1, j, k + 1) || // 上下左右的位置找到
                    dfs(board, word, i - 1, j, k + 1) ||
                    dfs(board, word, i, j + 1, k + 1) ||
                    dfs(board, word, i, j - 1, k + 1);
            board[i][j] = word[k];//TODO 为什么是不可或缺的？
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        char[][] board = new char[][]{{'a', 'b'}, {'c', 'd'}};
        AssertTool.assertFalse(new Solution().exist(board, "abcd"));
    }
}