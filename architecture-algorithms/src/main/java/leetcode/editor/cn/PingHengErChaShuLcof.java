package leetcode.editor.cn;

import leetcode.editor.cn.common.AssertTool;
import leetcode.editor.cn.common.TreeNode;
import leetcode.editor.cn.common.TreeNodeUtil;

/**
 * English description is not available for the problem. Please switch to Chinese.
 * Related Topics 树 深度优先搜索 二叉树 👍 240 👎 0
 */
public class PingHengErChaShuLcof {

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

        /**
         * 递归，判断所有子树都是平衡
         *
         * @param root
         * @return
         */
        public boolean isBalanced(TreeNode root) {
            if (root == null) return true;
            if (Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1) {
                return isBalanced(root.left) && isBalanced(root.right);
            }
            return false;
        }

        /**
         * 获取深度（存在重复计算）
         *
         * @param node
         * @return
         */
        int getDepth(TreeNode node) {
            if (node == null) return 0;
            return Math.max(getDepth(node.right), getDepth(node.left)) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.fromArray(3, 9, 20, null, null, 15, 7);
        final boolean balanced = new Solution().isBalanced(root);
        AssertTool.assertTrue(balanced);
        AssertTool.assertFalse(new Solution().isBalanced(TreeNodeUtil.fromArray(1, null, 2, null, 3)));
    }
}