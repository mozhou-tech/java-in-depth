package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 * <p>
 * Related Topics 数组 哈希表 双指针 二分查找 排序 👍 517 👎 0
 */
public class IntersectionOfTwoArrays {
    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            int[] res = new int[nums1.length];
            int cnt = 0;
            Arrays.sort(nums2); // 二分法需要先排序
            Set<Integer> sets = new HashSet<>();
            for (int j : nums1) {
                if (!sets.contains(j) && search(nums2, j) && cnt < res.length) {
                    res[cnt++] = j;
                    sets.add(j);
                }
            }
            // 求子数组
            return Arrays.copyOfRange(res, 0, cnt);
        }


        public boolean search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            int val0 = Integer.MAX_VALUE;
            while (left <= right) {
                int mid = (right + left) >> 1;
                if (nums[mid] <= target) { // 目标值在中点的右边，移动左指针 (向下取整，等于号在左侧)
                    val0 = nums[mid];
                    left = mid + 1; // 排除已经搜索的一个mid所以
                } else {
                    right = mid - 1; // 排除已经搜索的一个mid所以
                }
            }
            return val0 == target;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().intersection(new int[]{0, 5, 8, 7, 2, 9, 7, 5},
                new int[]{1, 4, 8, 9})));
//        final int[] ints = {2, 1};
//        for (int anInt : ints) {
//            System.out.println(new Solution().search(new int[]{1, 2}, anInt));
//        }
        System.out.println(new Solution().search(new int[]{1, 4, 8, 9}, 0));
    }
}