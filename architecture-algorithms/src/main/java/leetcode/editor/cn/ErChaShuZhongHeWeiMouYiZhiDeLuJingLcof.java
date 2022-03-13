package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;
import leetcode.editor.cn.common.TreeNodeUtil;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * English description is not available for the problem. Please switch to Chinese.
 * Related Topics 树 深度优先搜索 回溯 二叉树 👍 305 👎 0
 */
public class ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof {

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

        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new LinkedList<Integer>();

        /**
         * 回溯算法:递归
         *
         * @param root
         * @param target
         * @return
         */
        public List<List<Integer>> pathSum(TreeNode root, int target) {
            if (root == null) return res;
            path.addLast(root.val);
            backtrack(root, target, root.val);
            return res;
        }

        /**
         * 回溯算法
         *
         * @param node
         * @param target
         * @param sum
         */
        void backtrack(TreeNode node, int target, int sum) {
            if (node == null) return;
            if (node.left == null && node.right == null && target == sum) {
                res.add(new ArrayList<>(path));
                return;
            }
            // pop&poll默认弹出最后一个元素
            if (node.left != null) {
                path.addLast(node.left.val);   // 为什么用双端队列
                backtrack(node.left, target, sum + node.left.val);
                path.pollLast();    // 回溯
            }
            if (node.right != null) {
                path.addLast(node.right.val);
                backtrack(node.right, target, sum + node.right.val);
                path.pollLast();    // 回溯
            }
            // 左右子节点都为空, sum != target, 什么都不用做
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        final List<List<Integer>> lists = new Solution().pathSum(TreeNodeUtil.fromArray(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1), 22);
        System.out.println(lists);
    }
}