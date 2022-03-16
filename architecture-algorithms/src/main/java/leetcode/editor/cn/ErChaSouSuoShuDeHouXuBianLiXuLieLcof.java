package leetcode.editor.cn;

/**
 * English description is not available for the problem. Please switch to Chinese.
 * Related Topics 栈 树 二叉搜索树 递归 二叉树 单调栈 👍 461 👎 0
 */
public class ErChaSouSuoShuDeHouXuBianLiXuLieLcof {

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 验证给定数组是否是某二叉树的后续遍历
         * 注意题中关键字：二叉搜索树
         *
         * @param postorder
         * @return
         */
        public boolean verifyPostorder(int[] postorder) {
            return recur(postorder, 0, postorder.length - 1);
        }

        boolean recur(int[] postorder, int left, int right) {
            if (left >= right) return true;
            int p = left;
            while (postorder[p] < postorder[right]) p++; // 找到右侧边界（假定postorder不符合二叉搜索树）
            int m = p;
            while (postorder[p] > postorder[right]) p++;
            return p == right &&
                    recur(postorder, left, m - 1) &&
                    recur(postorder, m, right - 1);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {

    }
}