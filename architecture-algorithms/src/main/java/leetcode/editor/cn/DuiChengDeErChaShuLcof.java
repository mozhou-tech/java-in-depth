package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2 2
 * / \ / \
 * 3 4 4 3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2 2
 * \ \
 * 3 3
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 1000
 * <p>
 * 注意：本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/
 * Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 288 👎 0
 */
public class DuiChengDeErChaShuLcof {

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

        // 递归判断二叉树是否对称
        public boolean isSymmetric(TreeNode root) {
            if (null == root) {
                return true;
            }
            return recur(root.left, root.right);
        }

        public boolean recur(TreeNode left, TreeNode right) {
            // base case
            if (left == null && right == null) return true;
            if (right == null || left == null || left.val != right.val) return false;
            return recur(left.left, right.right) && recur(left.right, right.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {

    }
}