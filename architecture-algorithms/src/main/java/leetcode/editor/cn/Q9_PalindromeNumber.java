/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * <p>
 * 例如，121 是回文，而 123 不是。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：x = 121
 * 输出：true
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * -2³¹ <= x <= 2³¹ - 1
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：你能不将整数转为字符串来解决这个问题吗？
 * Related Topics 数学 👍 1829 👎 0
 */
package leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;

public class Q9_PalindromeNumber {

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(int x) {
            final String s = String.valueOf(x);
            int mid = s.length() / 2;
            for (int i = 0; i < mid; i++) {
                if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Assertions.assertTrue(new Solution().isPalindrome(121));
        Assertions.assertFalse(new Solution().isPalindrome(10));
        Assertions.assertFalse(new Solution().isPalindrome(110));
        Assertions.assertTrue(new Solution().isPalindrome(22122));
    }
}