package leetcode.editor.cn;

/**
 * 给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 5
 * 输出：true
 * 解释：5 的二进制表示是：101
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 7
 * 输出：false
 * 解释：7 的二进制表示是：111.
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：n = 11
 * 输出：false
 * 解释：11 的二进制表示是：1011.
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 2³¹ - 1
 * <p>
 * Related Topics 位运算 👍 193 👎 0
 */
public class BinaryNumberWithAlternatingBits {
    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // n 正整数
        public boolean hasAlternatingBits(int n) {
            while (n > 0) {
                int t = n % 2; // 当前二进制末位的数字
                n >>= 1;       // 右移
                if (t == n % 2) return false; // 右移后的末位二进制值与t相等则返回false
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
    }
}