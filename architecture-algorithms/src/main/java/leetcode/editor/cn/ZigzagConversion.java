package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * <p>
 * P0  A4  H8  N12
 * A P L S I I G
 * Y2  I6  R10
 * <p>
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P0    I6   N12
 * A   L S  I G
 * Y A   H R
 * P3    I9
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：s = "A", numRows = 1
 * 输出："A"
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 * <p>
 * Related Topics 字符串 👍 1567 👎 0
 */
public class ZigzagConversion {

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convert(String s, int numRows) {
            // base case
            if (numRows < 2) return s;
            List<StringBuilder> rows = new ArrayList<StringBuilder>();
            for (int i = 0; i < numRows; i++) rows.add(new StringBuilder());
            int i = 0, flag = -1;
            for (char c : s.toCharArray()) {
                rows.get(i).append(c);
                // flag=1/-1  控制着往下、往上转折
                if (i == 0 || i == numRows - 1) flag = -flag;
                i += flag;
            }
            StringBuilder res = new StringBuilder();
            for (StringBuilder row : rows) res.append(row);
            return res.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        AssertTool.assertEquals("PAHNAPLSIIGYIR", new Solution().convert("PAYPALISHIRING", 3));
    }
}