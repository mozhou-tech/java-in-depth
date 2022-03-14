package leetcode.editor.cn;

import leetcode.editor.cn.common.AssertTool;

/**
 * English description is not available for the problem. Please switch to Chinese.
 * <p>
 * Related Topics 位运算 递归 脑筋急转弯 👍 451 👎 0
 */
public class Qiu12nLcof {

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 逻辑运算符的短路效应：
         * 常见的逻辑运算符有三种，即 “与 \&\&&& ”，“或 ||∣∣ ”，“非 !! ” ；而其有重要的短路效应，如下所示：
         * if(A && B)  // 若 A 为 false ，则 B 的判断不会执行（即短路），直接判定 A && B 为 false
         * if(A || B) // 若 A 为 true ，则 B 的判断不会执行（即短路），直接判定 A || B 为 true
         *
         * @param n
         * @return
         */
        int res = 0;

        public int sumNums(int n) {
            boolean t = n > 1 && sumNums(n - 1) > 0;
            res += n;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        AssertTool.assertEquals(6, new Solution().sumNums(3));
        AssertTool.assertEquals(45, new Solution().sumNums(9));
    }
}