package leetcode.editor.cn;

import leetcode.editor.cn.common.AssertTool;
import leetcode.editor.cn.common.TreeNode;
import leetcode.editor.cn.common.TreeNodeUtil;

/**
 * English description is not available for the problem. Please switch to Chinese.
 * <p>
 * Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 171 👎 0
 */
public class ErChaShuDeShenDuLcof {

    static
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
    class Solution {

        int maxDepth;

        // bfs
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            dfs(root, 1); // root是第一层
            return maxDepth;
        }

        void dfs(TreeNode node, int depth) {
            if (node == null) return;
            if (node.right != null || node.left != null) { // 满足条件则层数递增
                ++depth;
            }
            if (node.left != null) {
                dfs(node.left, depth);
            }
            if (node.right != null) {
                dfs(node.right, depth);
            }
            maxDepth = Math.max(depth, maxDepth); // 选取最大的depth
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.fromArray(3, 9, 20, null, null, 15, 7);
        final int maxDepth = new Solution().maxDepth(root);
        AssertTool.assertEquals(3, maxDepth);
    }
}