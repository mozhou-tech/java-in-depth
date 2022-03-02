package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * <p>
 * 例如:
 * 给定的树 A:
 * <p>
 * 3
 * / \
 * 4 5
 * / \
 * 1 2
 * 给定的树 B：
 * <p>
 * 4
 * /
 * 1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 10000
 * Related Topics 树 深度优先搜索 二叉树 👍 476 👎 0
 */
public class ShuDeZiJieGouLcof {

    static
//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            return (A != null && B != null) &&
                    (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
        }

        // 通过递归，树的左右指针层层深入
        boolean recur(TreeNode A, TreeNode B) {
            if (B == null) return true;
            if (A == null || A.val != B.val) return false;
            return recur(A.left, B.left) && recur(A.right, B.right);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {

    }
}