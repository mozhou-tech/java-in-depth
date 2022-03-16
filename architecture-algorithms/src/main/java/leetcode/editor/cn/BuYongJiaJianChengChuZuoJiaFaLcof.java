package leetcode.editor.cn;

import leetcode.editor.cn.common.AssertTool;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: a = 1, b = 1
 * 输出: 2
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * a, b 均可能是负数或 0
 * 结果不会溢出 32 位整数
 * <p>
 * Related Topics 位运算 数学 👍 272 👎 0
 */
public class BuYongJiaJianChengChuZuoJiaFaLcof {

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int add(int a, int b) {
            int carry = 0;
            while (b != 0) {
                carry = (a & b) << 1; // 1&1=1；1&0=0；0&0=0；按位与左移后获得进位
                a ^= b; // a=非进位和（异或运算 1^1=0;1^0=1;0^0=0）
                b = carry;
            }
            return a;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        AssertTool.assertEquals(2, new Solution().add(1, 1));
    }
}