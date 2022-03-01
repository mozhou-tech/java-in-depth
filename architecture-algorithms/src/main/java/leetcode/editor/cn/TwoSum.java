//////////给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组
//下标
////。 
//////
//////////
////////// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
//////////
////////// 你可以按任意顺序返回答案。 
//////////
////////// 
//////////
////////// 示例 1： 
//////////
////////// 
//////////输入：nums = [2,7,11,15], target = 9
//////////输出：[0,1]
//////////解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
////////// 
//////////
////////// 示例 2： 
//////////
////////// 
//////////输入：nums = [3,2,4], target = 6
//////////输出：[1,2]
////////// 
//////////
////////// 示例 3： 
//////////
////////// 
//////////输入：nums = [3,3], target = 6
//////////输出：[0,1]
////////// 
//////////
////////// 
//////////
////////// 提示： 
//////////
////////// 
////////// 2 <= nums.length <= 10⁴ 
////////// -10⁹ <= nums[i] <= 10⁹ 
////////// -10⁹ <= target <= 10⁹ 
////////// 只会存在一个有效答案 
////////// 
//////////
////////// 进阶：你可以想出一个时间复杂度小于 O(n²) 的算法吗？ 
////////// Related Topics 数组 哈希表 👍 13561 👎 0
////////
//////
////
//
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TwoSum {

    /**
     * 暴力搜索法，复杂度 O(n^2)
     */
    static class Solution1 {
        public int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length < 2) {
                return null;
            }
            // while比for更方便控制指针
            int cur = 0, po = 1;
            while (cur < nums.length - 1) {
                if (nums[cur] + nums[po] == target) {
                    return new int[]{cur, po};
                }
                if (po < nums.length - 1) {
                    po++;
                } else if (cur < nums.length - 1) {
                    po = ++cur + 1;
                }
            }
            return null;
        }
    }

    /**
     * 逆向思维！！！拿到结果后再反向搜索 O(n)
     */
    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length < 2) {
                return null;
            }
            Map<Integer, Integer> valMap = new HashMap<>();
            // 要全部遍历
            for (int i = 0; i < nums.length; i++) {
                int val = target - nums[i];
                valMap.put(val, i);
            }
            for (int i = 0; i < nums.length; i++) {
                if (valMap.containsKey(nums[i])) {
                    if (valMap.get(nums[i]) == i) {
                        continue;
                    }
                    return new int[]{valMap.get(nums[i]), i};
                }
            }
            return null;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        int[] nums = new int[]{-1,-2,-3,-4,-5};
        final int[] result = new Solution().twoSum(nums, -8);
        System.out.println(Arrays.toString(result));
    }
}