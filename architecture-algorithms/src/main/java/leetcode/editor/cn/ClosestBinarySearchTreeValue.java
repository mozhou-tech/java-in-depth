package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;
import leetcode.editor.cn.common.TreeNodeUtil;

/**
 * 给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的数值。
 * <p>
 * 注意：
 * <p>
 * <p>
 * 给定的目标值 target 是一个浮点数
 * 题目保证在该二叉搜索树中只会存在一个最接近目标值的数
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入: root = [4,2,5,1,3]，目标值 target = 3.714286
 * <p>
 * 4
 * / \
 * 2   5
 * / \
 * 1   3
 * <p>
 * 输出: 4
 * <p>
 * Related Topics 树 深度优先搜索 二叉搜索树 二分查找 二叉树 👍 111 👎 0
 */
public class ClosestBinarySearchTreeValue {
    static
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
    class Solution {

        int res = 0;

        double minDiff = Double.MAX_VALUE;

        public int closestValue(TreeNode root, double target) {
            if (Math.abs(root.val - target) < minDiff) {
                minDiff = Math.abs(root.val - target);
                res = root.val;
            }
            if (root.val < target && root.right != null) {
                return closestValue(root.right, target);
            }
            if (root.val > target && root.left != null) {
                return closestValue(root.left, target);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        final TreeNode node = TreeNodeUtil.fromArray(1, 2, 3, 5, 4);
        final int s = new Solution().closestValue(node, 4);
        System.out.println(s);
    }
}