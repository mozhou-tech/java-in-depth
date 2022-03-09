package leetcode.editor.cn;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * <p>
 * <p>
 * 说明:
 * <p>
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * <p>
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * <p>
 * 你可以想象内部操作如下:
 * <p>
 * <p>
 * // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
 * int len = removeElement(nums, val);
 * <p>
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2, nums = [2,2]
 * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums
 * = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 * 输出：5, nums = [0,1,4,0,3]
 * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元
 * 素。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 50
 * 0 <= val <= 100
 * <p>
 * Related Topics 数组 双指针 👍 1215 👎 0
 */
public class RemoveElement {

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // while的好处，灵活控制指针的运动
        //TODO 对撞双指针（还有快慢双指针）
        public int removeElement(int[] nums, int val) {
            // base case
            if (nums.length == 0) return 0;
            if (nums.length == 1 && nums[0] == val) return 0; // 这种情况下 left=right，不符合遍历条件
            int left = 0, right = nums.length - 1;
            int res = nums.length;
            while (left < right) { // 如果取等号，则会导致重复计算，left/right被多移动
                while (left < right && nums[left] != val) left++; //TODO 搜索左侧第一个为val的
                while (left < right && nums[right] == val) { // 搜索右侧第一个不为val的
                    right--;
                    res--;
                }
                if (nums[left] == val) {
                    res--;
                    swap(nums, left, right);
                    right--;
                }
            }
            return res;
        }

        private void swap(int[] nums, int a, int b) {
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        final int res = new Solution().removeElement(new int[]{3, 2, 2, 3}, 3);
        System.out.println(res);
    }
}