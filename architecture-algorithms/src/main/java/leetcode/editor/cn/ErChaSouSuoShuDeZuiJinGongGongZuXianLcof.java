package leetcode.editor.cn;

import leetcode.editor.cn.common.AssertTool;
import leetcode.editor.cn.common.TreeNode;
import leetcode.editor.cn.common.TreeNodeUtil;

/**
 * English description is not available for the problem. Please switch to Chinese.
 * <p>
 * Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 209 👎 0
 */
public class ErChaSouSuoShuDeZuiJinGongGongZuXianLcof {

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
         * 二叉树的性质
         *
         * @param root 根节点
         * @param p
         * @param q
         * @return
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return root;
            // 如果p、q都比root小，则递归左树
            if (root.val > p.val && root.val > q.val) {
                return lowestCommonAncestor(root.left, p, q);
            }
            // 如果p/q都比root大，递归右树
            if (root.val < p.val && root.val < q.val) {
                return lowestCommonAncestor(root.right, p, q);
            }
            // 排除以上两种情况的root是p/q的最近公共祖先
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.fromArray(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5);
        final TreeNode node = new Solution().lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8));
        AssertTool.assertEquals(node.val, 6);

    }
}