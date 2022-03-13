package leetcode.editor.cn;

import leetcode.editor.cn.common.AssertTool;

import java.util.HashSet;
import java.util.Set;

/**
 * English description is not available for the problem. Please switch to Chinese.
 * Related Topics 数组 排序 👍 213 👎 0
 */
public class BuKePaiZhongDeShunZiLcof {

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isStraight(int[] nums) {
            if (nums.length == 0 || nums.length > 5) return false;
            // HashMap 判断key是否存在，时间复杂度O(1)
            // ArrayList 和LinkedList的时间复杂度为O(N)
            Set<Integer> numSet = new HashSet<>();
            int minE = Integer.MAX_VALUE;  // 为什么不能用nums[0]?
            int zeroCount = 0;
            // 首次遍历，找出0的数量、最小值以及准备Set
            for (int num : nums) {
                if (num == 0) {
                    zeroCount++;
                    continue;
                }
                if (num < minE) minE = num;
                numSet.add(num);
            }
            for (int i = minE; i < minE + 5; i++) {
                if (!numSet.contains(i)) zeroCount--;
            }
            return zeroCount >= 0;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        AssertTool.assertTrue(new Solution().isStraight(new int[]{0, 0, 8, 5, 4}));
    }
}