package leetcode.editor.cn;

import leetcode.editor.cn.common.AssertTool;

/**
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量).）。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是
 * 无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用 二进制补码 记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 11 (控制台输入 00000000000000000000000000001011)
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 128 (控制台输入 00000000000000000000000010000000)
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：n = 4294967293 (控制台输入 11111111111111111111111111111101，部分语言中 n = -3）
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 输入必须是长度为 32 的 二进制串 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 191 题相同：https://leetcode-cn.com/problems/number-of-1-bits/
 * Related Topics 位运算 👍 231 👎 0
 */
public class ErJinZhiZhong1deGeShuLcof {

    static
//leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        public int hammingWeight(int n) {
            int res = 0;
            while (n != 0) {
                res += n & 1;   // 是否
                n >>>= 1; // 无符号右移（忽略符号位，空位都以0补齐）；>>带符号
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        AssertTool.assertEquals(1, new Solution().hammingWeight(128));
        AssertTool.assertEquals(31, new Solution().hammingWeight(-3));
        System.out.println(1 >> 1);
    }
}