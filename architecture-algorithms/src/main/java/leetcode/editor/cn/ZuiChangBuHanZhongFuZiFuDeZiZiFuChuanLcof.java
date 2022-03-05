package leetcode.editor.cn;

import leetcode.editor.cn.common.AssertTool;

import java.util.HashMap;
import java.util.Map;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * s.length <= 40000
 * <p>
 * <p>
 * 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-
 * repeating-characters/
 * Related Topics 哈希表 字符串 滑动窗口 👍 383 👎 0
 */
public class ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof {

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 动态规划（迭代）+哈希表
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> dic = new HashMap<>();
            int res = 0, tmp = 0;
            for (int j = 0; j < s.length(); j++) {
                int i = dic.getOrDefault(s.charAt(j), -1); // 获取索引 i
                dic.put(s.charAt(j), j); // 更新哈希表
                if (tmp < j - i) tmp += 1;  //
                else tmp = j - i;   // 当前字符到上一次该字符出现间隔的长度（当tmp>=j-i时）
                res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        AssertTool.assertEquals(3, new Solution().lengthOfLongestSubstring("pwwkew"));
    }
}