package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;

/**
 * English description is not available for the problem. Please switch to Chinese.
 * <p>
 * Related Topics 树 深度优先搜索 二叉树 👍 393 👎 0
 */
public class ErChaShuDeZuiJinGongGongZuXianLcof {

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
         *
         * @param root
         * @param p
         * @param q
         * @return
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // 如果 p和q中有等于 root的，那么它们的最近公共祖先即为root（一个节点也可以是它自己的祖先）
            if (root == null || root == q || root == p) return root;
            // 递归遍历左子树，只要在左子树中找到了p或q，则先找到谁就返回谁
            final TreeNode left = lowestCommonAncestor(root.left, p, q);
            // 递归遍历右子树，只要在右子树中找到了p或q，则先找到谁就返回谁
            final TreeNode right = lowestCommonAncestor(root.right, p, q);
            // 如果在左子树中 p和 q都找不到，则 p和 q一定都在右子树中，
            // 右子树中先遍历到的那个就是最近公共祖先（一个节点也可以是它自己的祖先）
            if (left == null) return right;
            // 否则，如果 left不为空，在左子树中有找到节点（p或q），
            // 这时候要再判断一下右子树中的情况，如果在右子树中，p和q都找不到，则 p和q一定都在左子树中，
            // 左子树中先遍历到的那个就是最近公共祖先（一个节点也可以是它自己的祖先）
            if (right == null) return left;
            // 当 left和 right均不为空时，说明 p、q节点分别在 root异侧, 最近公共祖先即为 root
            return root;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {

    }
}