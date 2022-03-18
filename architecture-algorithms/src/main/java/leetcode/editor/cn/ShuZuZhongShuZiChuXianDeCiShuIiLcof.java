package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,4,3,3]
 * 输出：4
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * <p>
 * 1 <= nums.length <= 10000
 * 1 <= nums[i] < 2^31
 * <p>
 * <p>
 * <p>
 * Related Topics 位运算 数组 👍 304 👎 0
 */
public class ShuZuZhongShuZiChuXianDeCiShuIiLcof {

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 1; i++) {
                // 查看nums[0]是否符合条件
                if (i == 0 && nums[i] != nums[i + 1]) return nums[i];
                // 前后都不同，则当前值是唯一的
                if (i > 0 && nums[i - 1] != nums[i] && nums[i] != nums[i + 1]) return nums[i];
            }
            // 找不到则返回最后1位
            return nums[nums.length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static int main(String[] args) {
        int a = 1;
        int b = 0;
        return a + b;
    }
}