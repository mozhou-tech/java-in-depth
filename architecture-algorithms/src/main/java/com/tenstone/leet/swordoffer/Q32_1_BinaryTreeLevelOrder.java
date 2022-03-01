package com.tenstone.leet.swordoffer;

import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.LinkedTransferQueue;

/**
 * Created by liuyuancheng on 2022/3/1  <br/>
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 * 从上到下打印二叉树
 *
 * @author liuyuancheng
 */
public class Q32_1_BinaryTreeLevelOrder {


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
         * 层次遍历的代码比较简单，只需要一个队列即可，先在队列中加入根结点。
         * 之后对于任意一个结点来说，在其出队列的时候，访问之。同时如果左孩子和右孩子有不为空的，入队列。
         *
         * @param root
         * @return
         */
        public int[] levelOrder(TreeNode root) {
            if (root == null) {
                return new int[0];
            }
            int[] returnArr = new int[0];
            Queue<TreeNode> queue = new LinkedTransferQueue<>();
            queue.offer(root);
            // 从二叉树
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                returnArr = arrAddElement(returnArr, node.val);
                // 层次遍历：每次检查同一层的左孩子和右孩子
                // 每一层都按照left、right的顺序入队
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            return returnArr;
        }

        public int[] arrAddElement(int[] arr, int e) {
            int[] arrtemp = new int[arr.length + 1];
            System.arraycopy(arr, 0, arrtemp, 0, arr.length);
            arrtemp[arr.length] = e;
            return arrtemp;
        }

    }

    public static void main(String[] args) {
        final TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(12);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(Arrays.toString(new Solution().levelOrder(root)));
//        [3,9,20,15,7]
    }
}
