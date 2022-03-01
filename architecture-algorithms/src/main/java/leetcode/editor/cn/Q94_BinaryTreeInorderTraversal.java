/**
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * <p>
 * 输入：root = [1,2]
 * 输出：[2,1]
 * <p>
 * <p>
 * 示例 5：
 * <p>
 * <p>
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * Related Topics 栈 树 深度优先搜索 二叉树 👍 1281 👎 0
 */
package leetcode.editor.cn;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class Q94_BinaryTreeInorderTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static
//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {

        /**
         * inorder 中序遍历
         * 按照访问左子树——根节点——右子树的方式遍历这棵树
         * 前序遍历 根结点 ---> 左子树 ---> 右子树
         * 后序遍历 左子树 ---> 右子树 ---> 根结点
         * 层次遍历 1层----> 二层 ->三层    BFS宽度有限搜索（循环队列）
         *
         * @param root
         * @return
         */
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            inorder(root, res);
            return res;
        }

        public void inorder(TreeNode node, List<Integer> res) {
            if (node == null) {
                return;
            }
            inorder(node.left, res);
            res.add(node.val);
            inorder(node.right, res);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        // 测试用例不要写错，之前漏掉了right这一层
        root.right.left = new TreeNode(3);
        AssertTool.assertListEquals(new Solution().inorderTraversal(root), Lists.newArrayList(1, 3, 2));
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        AssertTool.assertListEquals(new Solution().inorderTraversal(root), Lists.newArrayList(2, 1));
        root = new TreeNode(1);
        root.right = new TreeNode(2);
        AssertTool.assertListEquals(new Solution().inorderTraversal(root), Lists.newArrayList(1, 2));
    }
}