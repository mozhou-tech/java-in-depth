package com.tenstone.leet.swordoffer;

import java.util.*;

/**
 * Created by liuyuancheng on 2022/3/1  <br/>
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 *
 * @author liuyuancheng
 */
public class Q32_3_BinaryTreeLevelOrder_ {


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {


        /**
         * 理解题意：层次遍历，注意不是前序遍历
         * https://blog.csdn.net/My_Jobs/article/details/43451187
         * <p>
         * 双端队列解决正反顺序问题
         *
         * @param root
         * @return
         */
        public List<List<Integer>> levelOrder(TreeNode root) {
            Deque<TreeNode> queue = new LinkedList<>();
            List<List<Integer>> res = new ArrayList<>();
            if (root != null) queue.add(root);
            // BFS 循环（宽度优先搜索）： 当队列 queue 为空时跳出；
            int level = 1;
            while (!queue.isEmpty()) {
                // 每一次while循环，处理queue中所有的元素（此时是一层）
                //  当前层打印循环： 循环次数为当前层节点数（即队列 queue 长度）；
                //      出队： 队首元素出队，记为 node；
                //      打印： 将 node.val 添加至 tmp 尾部；
                //      添加子节点： 若 node 的左（右）子节点不为空，则将左（右）子节点加入队列 queue
                LinkedList<Integer> tmp = new LinkedList<>();
                // 当前的queue长度，是上次遍历中添加的所有right和left
                for (int i = queue.size(); i > 0; i--) {
                    TreeNode node = queue.poll();
                    if (level % 2 == 0) tmp.addFirst(node.val);
                    else tmp.addLast(node.val);
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
                level++;
                res.add(tmp);
            }
            return res;
        }

    }

    /**
     * [
     * [3],
     * [20,9],
     * [15,7]
     * ]
     *
     * @param args
     */
    public static void main(String[] args) {
        final TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new Solution().levelOrder(root));
    }
}
