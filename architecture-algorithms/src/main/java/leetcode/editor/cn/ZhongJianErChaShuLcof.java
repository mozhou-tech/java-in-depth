package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;

import java.util.HashMap;

/**
 * English description is not available for the problem. Please switch to Chinese.
 * Related Topics 树 数组 哈希表 分治 二叉树 👍 714 👎 0
 */
public class ZhongJianErChaShuLcof {

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


        int[] preorder;//保留的先序遍历

        /**
         * 标记中序遍历  value->idx
         * 仅适用于无重复节点值
         */
        HashMap<Integer, Integer> inorderMap = new HashMap<>();

        /**
         * 重建二叉树
         *
         * @param preorder 先序
         * @param inorder  中序（遍历找到根节点即可划分左右子树）
         * @return
         */
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.preorder = preorder;
            for (int i = 0; i < preorder.length; i++) inorderMap.put(inorder[i], i);
            return recursive(0, 0, inorder.length - 1);
        }

        /**
         * 分治
         *
         * @param pre_root_idx 先序-根节点
         * @param in_left_idx  中序-左树起始索引
         * @param in_right_idx 中序-右树结束索引
         * @return
         */
        TreeNode recursive(int pre_root_idx, int in_left_idx, int in_right_idx) {
            // 左树的起始索引小于或等于右树结束索引
            if (in_left_idx > in_right_idx) {
                return null;
            }
            // 根节点
            TreeNode root = new TreeNode(preorder[pre_root_idx]);
            // 获取根节点的中序索引（有了先序的），用于界定左右子树的中序索引范围
            int in_root_index = inorderMap.get(preorder[pre_root_idx]);

            //左子树的根节点就是 左子树的(前序遍历）第一个，就是+1,左边边界就是left
            root.left = recursive(pre_root_idx + 1, // 前序遍历索引+1（根节点的左树根节点）
                    in_left_idx,       // 左边界：in_left_idx
                    in_root_index - 1 // 右边界：中序根节点索引-1
            );

            //由根节点在中序遍历的idx 区分成2段,idx 就是根
            root.right = recursive(pre_root_idx + (in_root_index - in_left_idx + 1), // 右树根节点=根节点索引+左树节点数量
                    in_root_index + 1, // 左边界：中序根节点索引+1
                    in_right_idx // 右边界：上一次递归的右边界
            );
            return root;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {

    }
}