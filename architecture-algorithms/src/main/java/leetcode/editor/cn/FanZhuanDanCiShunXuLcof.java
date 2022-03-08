package leetcode.editor.cn;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输
 * 出"student. a am I"。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * <p>
 * <p>
 * <p>
 * 说明：
 * <p>
 * <p>
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * <p>
 * 注意：本题与主站 151 题相同：https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * <p>
 * 注意：此题对比原题有改动
 * Related Topics 双指针 字符串 👍 178 👎 0
 */
public class FanZhuanDanCiShunXuLcof {

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            if (s == null) return null;
            StringBuilder res = new StringBuilder();
            int left = s.length() - 1, right = s.length() - 1;
            // 倒序搜索，依次添加
            while (left >= 0) {
                while (left >= 0 && s.charAt(left) != ' ') left--;// 搜索首个空格
                res.append(s, left + 1, right + 1).append(' '); // 添加单词
                while (left >= 0 && s.charAt(left) == ' ') left--;// 跳过单词间空格
                right = left;
            }
            res.append(s, 0, right + 1);
            return res.toString().trim();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        final String res = new Solution().reverseWords("a good   example");
        System.out.println(res);
    }
}