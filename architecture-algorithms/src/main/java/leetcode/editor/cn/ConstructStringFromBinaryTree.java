package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;
import leetcode.editor.cn.common.TreeNodeUtil;

/**
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 * <p>
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: 二叉树: [1,2,3,4]
 * 1
 * /   \
 * 2     3
 * /
 * 4
 * <p>
 * 输出: "1(2(4))(3)"
 * <p>
 * 解释: 原本将是“1(2(4)())(3())”，
 * 在你省略所有不必要的空括号对之后，
 * 它将是“1(2(4))(3)”。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: 二叉树: [1,2,3,null,4]
 * 1
 * /   \
 * 2     3
 * \
 * 4
 * <p>
 * 输出: "1(2()(4))(3)"
 * <p>
 * 解释: 和第一个示例相似，
 * 除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
 * <p>
 * Related Topics 树 深度优先搜索 字符串 二叉树 👍 272 👎 0
 */
public class ConstructStringFromBinaryTree {
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

        public String tree2str(TreeNode root) {
            StringBuilder res = new StringBuilder();
            dfs(root, res);
            return res.toString();
        }

        /**
         * 为什么没有用非递归方式？
         *
         * @param root
         * @param res
         */
        public void dfs(TreeNode root, StringBuilder res) {
            res.append(root.val);
            if (root.left != null) {
                res.append('(');
                dfs(root.left, res);
                res.append(')');
            } else if (root.right != null) {
                res.append("()");
            }
            if (root.right != null) {
                res.append('(');
                dfs(root.right, res);
                res.append(')');
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        var t = new ConstructStringFromBinaryTree.Solution().tree2str(TreeNodeUtil.fromArray(1, 2, 3, 4));
        System.out.println(t);
    }
}