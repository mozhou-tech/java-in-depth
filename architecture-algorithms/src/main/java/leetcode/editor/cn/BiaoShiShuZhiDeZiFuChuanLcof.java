package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * <p>
 * 数值（按顺序）可以分成以下几个部分：
 * <p>
 * <p>
 * 若干空格
 * 一个 小数 或者 整数
 * （可选）一个 'e' 或 'E' ，后面跟着一个 整数
 * 若干空格
 * <p>
 * <p>
 * 小数（按顺序）可以分成以下几个部分：
 * <p>
 * <p>
 * （可选）一个符号字符（'+' 或 '-'）
 * 下述格式之一：
 * <p>
 * 至少一位数字，后面跟着一个点 '.'
 * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * 一个点 '.' ，后面跟着至少一位数字
 * <p>
 * <p>
 * <p>
 * <p>
 * 整数（按顺序）可以分成以下几个部分：
 * <p>
 * <p>
 * （可选）一个符号字符（'+' 或 '-'）
 * 至少一位数字
 * <p>
 * <p>
 * 部分数值列举如下：
 * <p>
 * <p>
 * ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
 * <p>
 * <p>
 * 部分非数值列举如下：
 * <p>
 * <p>
 * ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "0"
 * 输出：true
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "e"
 * 输出：false
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：s = "."
 * 输出：false
 * <p>
 * 示例 4：
 * <p>
 * <p>
 * 输入：s = "    .1  "
 * 输出：true
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 20
 * s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，空格 ' ' 或者点 '.' 。
 * <p>
 * Related Topics 字符串 👍 316 👎 0
 */
public class BiaoShiShuZhiDeZiFuChuanLcof {
    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 编译原理，有穷自动机
        public boolean isNumber(String s) {
            Map[] states = {
                    new HashMap<>() {{
                        put(' ', 0);
                        put('s', 1);
                        put('d', 2);
                        put('.', 4);
                    }}, // 0.
                    new HashMap<>() {{
                        put('d', 2);
                        put('.', 4);
                    }},                           // 1.
                    new HashMap<>() {{
                        put('d', 2);
                        put('.', 3);
                        put('e', 5);
                        put(' ', 8);
                    }}, // 2.
                    new HashMap<>() {{
                        put('d', 3);
                        put('e', 5);
                        put(' ', 8);
                    }},              // 3.
                    new HashMap<>() {{
                        put('d', 3);
                    }},                                        // 4.
                    new HashMap<>() {{
                        put('s', 6);
                        put('d', 7);
                    }},                           // 5.
                    new HashMap<>() {{
                        put('d', 7);
                    }},                                        // 6.
                    new HashMap<>() {{
                        put('d', 7);
                        put(' ', 8);
                    }},                           // 7.
                    new HashMap<>() {{
                        put(' ', 8);
                    }}                                         // 8.
            };
            int p = 0;
            char t;
            for (char c : s.toCharArray()) {
                if (c >= '0' && c <= '9') t = 'd';
                else if (c == '+' || c == '-') t = 's';
                else if (c == 'e' || c == 'E') t = 'e';
                else if (c == '.' || c == ' ') t = c;
                else t = '?';
                if (!states[p].containsKey(t)) return false;
                p = (int) states[p].get(t);
            }
            return p == 2 || p == 3 || p == 7 || p == 8;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        final boolean b = new Solution().isNumber("e");
        System.out.println(b);
    }
}