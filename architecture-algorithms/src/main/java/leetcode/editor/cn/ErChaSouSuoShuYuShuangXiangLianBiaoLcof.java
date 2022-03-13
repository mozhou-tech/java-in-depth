package leetcode.editor.cn;

import leetcode.editor.cn.common.Node;
import leetcode.editor.cn.common.NodeUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * <p>
 * <p>
 * <p>
 * 为了让您更好地理解问题，以下面的二叉搜索树为例：
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一
 * 个节点。
 * <p>
 * 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 426 题相同：https://leetcode-cn.com/problems/convert-binary-search-tree-
 * to-sorted-doubly-linked-list/
 * <p>
 * 注意：此题对比原题有改动。
 * Related Topics 栈 树 深度优先搜索 二叉搜索树 链表 二叉树 双向链表 👍 425 👎 0
 */
public class ErChaSouSuoShuYuShuangXiangLianBiaoLcof {

    static
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
    class Solution {

        private List<Node> values = new ArrayList<>();

        // 返回 排序的双向链表？
        // TODO 输入的是二叉搜索树，其本身是有序的！！！因此中序遍历，按顺序构建LinkedList可降低时间复杂度
        // https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/solution/mian-shi-ti-36-er-cha-sou-suo-shu-yu-shuang-xian-5/
        public Node treeToDoublyList(Node root) {
            if (root == null) return null;
            dfs(root);
            values.sort(Comparator.comparingInt(o -> o.val)); // 排序
            for (int i = 0; i < values.size(); i++) {
                int left = i - 1 < 0 ? values.size() - 1 : i - 1;
                int right = i + 1 > values.size() - 1 ? 0 : i + 1;
                values.get(i).right = values.get(right);
                values.get(i).left = values.get(left);
            }
            return values.get(0);
        }

        void dfs(Node node) {
            if (node == null) return;
            values.add(node);
            if (node.left != null) {
                dfs(node.left);
            }
            if (node.right != null) {
                dfs(node.right);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        final Node node = new Solution().treeToDoublyList(NodeUtil.fromArray(4, 2, 1, 3, 5));
        Node cur = node;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.right;
        }
    }
}