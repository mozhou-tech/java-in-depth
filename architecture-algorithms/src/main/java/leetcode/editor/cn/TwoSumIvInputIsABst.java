package leetcode.editor.cn;

import leetcode.editor.cn.common.AssertTool;
import leetcode.editor.cn.common.TreeNode;
import leetcode.editor.cn.common.TreeNodeUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入: root = [5,3,6,2,4,null,7], k = 9
 * 输出: true
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入: root = [5,3,6,2,4,null,7], k = 28
 * 输出: false
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 二叉树的节点个数的范围是 [1, 10⁴].
 * -10⁴ <= Node.val <= 10⁴
 * root 为二叉搜索树
 * -10⁵ <= k <= 10⁵
 * <p>
 * Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 哈希表 双指针 二叉树 👍 355 👎 0
 */
public class TwoSumIvInputIsABst {
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

        public boolean findTarget(TreeNode root, int k) {
            if (root == null) return false;
            if (root.left == null && root.right == null) return false;
            Map<Integer, Integer> ref = new HashMap<>();
            return dfs(root, ref, k, false);
        }

        boolean dfs(TreeNode root, Map<Integer, Integer> ref, int k, boolean res) {
            // 这一行要前面，否则3+3=6的情况不过
            if (ref.containsKey(root.val)) return true;
            ref.put(k - root.val, root.val);
            // 增加了一个res条件之后，速度快了很多？
            // 相当于带记忆的递归
            if (root.left != null) res = res || dfs(root.left, ref, k, res);
            if (root.right != null) res = res || dfs(root.right, ref, k, res);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        final boolean target = new Solution().findTarget(TreeNodeUtil.fromArray(2, null, 3), 6);
        AssertTool.assertFalse(target);
    }
}