package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 要求时间复杂度是O(n)，空间复杂度是O(1)。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * <p>
 * 2 <= nums.length <= 10000
 * <p>
 * <p>
 * <p>
 * Related Topics 位运算 数组 👍 578 👎 0
 */
public class ShuZuZhongShuZiChuXianDeCiShuLcof {
    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 要求O(n) 不能两层遍历嵌套
         * @param nums
         * @return
         */
        public int[] singleNumbers(int[] nums) {
            if (nums.length == 0) return new int[0];
            // 排序
            Arrays.sort(nums);
            int split = 0;
            int a = 0, b = 0;
            // 分两组
            for (int i = 0; i < nums.length; i++) {
                if (i % 2 == 0 && nums[i] != nums[i + 1]) {
                    split = i + 1;
                    break;
                }
            }
            // 两组分别异或
            for (int i = 0; i < split; i++) {
                a ^= nums[i];
            }
            for (int i = split; i < nums.length; i++) {
                b ^= nums[i];
            }
            return new int[]{a, b};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        final int[] ints = new Solution().singleNumbers(new int[]{4, 1, 4, 6});
        System.out.println(Arrays.toString(ints));
    }
}