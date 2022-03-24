package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;
import leetcode.editor.cn.common.TreeNodeUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * <p>
 * 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
 * 反序列化为原始的树结构。
 * <p>
 * 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解
 * 决这个问题。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-
 * binary-tree/
 * Related Topics 树 深度优先搜索 广度优先搜索 设计 字符串 二叉树 👍 280 👎 0
 */
public class XuLieHuaErChaShuLcof {
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
    public class Codec {

        private final String SPLITTER = ",";

        private final String NULL_PLACEHOLDER = "#";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "";
            final StringBuilder sb = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                final TreeNode node = queue.poll();
                if (node == null) {
                    sb.append(NULL_PLACEHOLDER).append(SPLITTER);
                    continue;
                }
                sb.append(node.val).append(SPLITTER);
                // 因为null节点要替换为#，所以没有node.left!=null的判断
                queue.offer(node.left);
                queue.offer(node.right);
            }
            return sb.deleteCharAt(sb.length() - 1).toString();
        }

        /**
         * bfs
         *
         * @param data
         * @return
         */
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.isEmpty()) return null;
            final String[] splits = data.split(SPLITTER);
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode root = new TreeNode(Integer.parseInt(splits[0]));
            queue.offer(root);
            for (int i = 1; i < splits.length - 1; ) {
                TreeNode parent = queue.poll();
                String leftVal = splits[i++];
                if (!leftVal.equals(NULL_PLACEHOLDER)) {
                    parent.left = new TreeNode(Integer.parseInt(leftVal));
                    queue.offer(parent.left);
                }
                String rightVal = splits[i++];
                if (!rightVal.equals(NULL_PLACEHOLDER)) {
                    parent.right = new TreeNode(Integer.parseInt(rightVal));
                    queue.offer(parent.right);
                }
            }
            return root;
        }

    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        final Codec codec = new Codec();
        final TreeNode input = TreeNodeUtil.fromArray(1, 2, 3, null, null, 4, 5);
        System.out.println(TreeNodeUtil.toArrayString(input));
        final String serialize = codec.serialize(input);
        System.out.println(serialize);
        final TreeNode treeNode = codec.deserialize(serialize);
        System.out.println(TreeNodeUtil.toArrayString(treeNode));
    }
}