package leetcode.editor.cn;

import leetcode.editor.cn.common.AssertTool;
import leetcode.editor.cn.common.TreeNode;
import leetcode.editor.cn.common.TreeNodeUtil;

/**
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 *    2
 * 输出: 4
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 4
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * <p>
 * 1 ≤ k ≤ 二叉搜索树元素个数
 * <p>
 * Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 262 👎 0
 */
public class ErChaSouSuoShuDeDiKdaJieDianLcof {

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
        int count = 0, res = 0;//形参k不能随着dfs的迭代而不断变化，为了记录迭代进程和结果，引入类变量count和res。

        //TODO 二叉搜索树的中序遍历为 递增序列( 中序遍历倒序 为 递减序列)
        //TODO 搜索树本身是有序的！！！
        //TODO 因此，求 “二叉搜索树第 kk 大的节点” 可转化为求 “此树的中序遍历倒序的第 kk 个节点”。
        public int kthLargest(TreeNode root, int k) {
            this.count = k;//利用形参值k对类变量count进行初始化
            dfs(root);//这里不要引入形参k，dfs中直接使用的是初始值为k的类变量count
            return res;
        }

        public void dfs(TreeNode root) {
            if (root == null || count == 0) return;//当root为空或者已经找到了res时，直接返回
            dfs(root.right);
            if (--count == 0) {//先--，再判断
                res = root.val;
                return;//这里的return可以避免之后的无效迭代dfs(root.left);
            }
            dfs(root.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        TreeNode node = TreeNodeUtil.fromArray(5, 3, 6, 2, 4, null, null, 1);
        final int i = new Solution().kthLargest(node, 3);
        AssertTool.assertEquals(4, i);
    }
}