package leetcode.editor.cn;

/**
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: num = 38
 * 输出: 2
 * 解释: 各位相加的过程为：
 * 38 --> 3 + 8 --> 11
 * 11 --> 1 + 1 --> 2
 * 由于 2 是一位数，所以返回 2。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: num = 0
 * 输出: 0
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= num <= 2³¹ - 1
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：你可以不使用循环或者递归，在 O(1) 时间复杂度内解决这个问题吗？
 * Related Topics 数学 数论 模拟 👍 439 👎 0
 */
public class AddDigits {

    static class Solution1 {
        public int addDigits(int num) {
            // base case
            if (num < 10) return num;
            String numStr = String.valueOf(num);
            int sum = 0;
            for (int i = 0; i < numStr.length(); i++) {
                // 字符转数字（而不是ascll码）
                sum += Character.getNumericValue(numStr.charAt(i));
            }
            return addDigits(sum);
        }
    }

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 看清题目：
        // 对一个数来说，它和【它的各位数码和】模9同余
        // 所以，对一个数来说，它和【它做任意次[各位数码和]】模9同余。
        // 方法二：画图可知返回值是个周期数（如何想到？）
        // O(1) 的解法
        public int addDigits(int num) {
            // base case
            if (num == 0) return 0;
            if (num % 9 == 0) return 9;
            return num % 9;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        final int sum = Integer.valueOf("1") + 1;
        System.out.println(sum);
    }
}