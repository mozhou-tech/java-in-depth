package leetcode.editor.cn;

import leetcode.editor.cn.common.AssertTool;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压
 * 栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= pushed.length == popped.length <= 1000
 * 0 <= pushed[i], popped[i] < 1000
 * pushed 是 popped 的排列。
 * <p>
 * <p>
 * 注意：本题与主站 946 题相同：https://leetcode-cn.com/problems/validate-stack-sequences/
 * Related Topics 栈 数组 模拟 👍 301 👎 0
 */
public class ZhanDeYaRuDanChuXuLieLcof {
    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            if (pushed.length == 0 || popped.length == 0) return true;
            Stack<Integer> stack = new Stack<>();
            int popIdx = 0;
            // 入栈的同时遍历popped数组
            for (int item : pushed) {
                // 搜索下一个没按顺序来的，所以一直弹
                while (!stack.isEmpty() && stack.peek() == popped[popIdx]) {
                    stack.pop();
                    popIdx++;
                }
                stack.push(item);
            }
            // 检查栈中剩下的值
            while (popIdx < pushed.length) {
                if (stack.pop() != popped[popIdx++]) return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
//        boolean res = new Solution().validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1});
//        AssertTool.assertTrue(res);
//        res = new Solution().validateStackSequences(new int[]{1, 2, 0}, new int[]{0, 2, 1});
//        AssertTool.assertTrue(res);
//        res = new Solution().validateStackSequences(new int[]{1, 0, 2}, new int[]{2, 1, 0});
//        AssertTool.assertFalse(res);
        boolean res1 = new Solution().validateStackSequences(new int[]{2, 1, 0}, new int[]{1, 2, 0});
        AssertTool.assertTrue(res1);
    }
}