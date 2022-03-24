package leetcode.editor.cn;

import java.util.*;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * <p>
 * <p>
 * <p>
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * <p>
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= s 的长度 <= 8
 * Related Topics 字符串 回溯 👍 519 👎 0
 */
public class ZiFuChuanDePaiLieLcof {

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<String> res = new LinkedList<>();

        char[] chars;

        /**
         * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/solution/mian-shi-ti-38-zi-fu-chuan-de-pai-lie-hui-su-fa-by/
         * @param s
         * @return
         */
        public String[] permutation(String s) {
            chars = s.toCharArray();
            backtrack(0);
            return res.toArray(String[]::new);
        }

        // 回溯法 (全排列)
        void backtrack(int x) {
            if(x == chars.length - 1) {
                res.add(String.valueOf(chars));      // 添加排列方案
                return;
            }
            Set<Character> set = new HashSet<>();
            for(int i = x; i < chars.length; i++) {
                if(set.contains(chars[i])) continue; // 重复（原始字串中重复），因此剪枝（少一次递归）
                set.add(chars[i]);
                swap(i, x);                         // 交换，将 c[i] 固定在第 x 位
                backtrack(x + 1);                // 开启固定第 x + 1 位字符
                swap(i, x);                         // 恢复交换
            }
        }

        void swap(int a, int b) {
            char tmp = chars[a];
            chars[a] = chars[b];
            chars[b] = tmp;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {

    }
}