package leetcode.editor.cn;

import leetcode.editor.cn.common.AssertTool;

import java.util.Arrays;

/**
 * English description is not available for the problem. Please switch to Chinese.
 * Related Topics 贪心 字符串 排序 👍 398 👎 0
 */
public class BaShuZuPaiChengZuiXiaoDeShuLcof {

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 数组比动图数组要快！
        public String minNumber(int[] nums) {
            if (nums.length == 0) return "";
            String[] numsInString = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                numsInString[i] = String.valueOf(nums[i]);
            }
            // 若拼接字符串 x + y > y + x  x+y>y+x ，则 xx “大于” yy ；
            // 直接对字符串排序
            Arrays.sort(numsInString, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
            return String.join("", numsInString);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        final String s = new Solution().minNumber(new int[]{3, 30, 34, 5, 9});
        AssertTool.assertEquals("3033459", s);
    }
}