package com.tenstone.leet.structure.binary_tree.q101_symmetric_tree;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 * 给定一个二叉树，检查它是否是镜像对称的。
 * Created by liuyuancheng on 2021/7/10  <br/>
 */
public class MainRecursion {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {

        public boolean isSymmetric(TreeNode root) {
            return check(root, root);
        }

        public boolean check(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if (p == null || q == null) {
                return false;
            }
            return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
        }

    }

    public static void main(String[] args) {

    }
}
