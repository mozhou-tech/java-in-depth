package leetcode.editor.cn;

import leetcode.editor.cn.common.AssertTool;

import java.util.Arrays;

/**
 * English description is not available for the problem. Please switch to Chinese.
 * Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 395 👎 0
 */
public class ZuiXiaoDeKgeShuLcof {

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] getLeastNumbers(int[] arr, int k) {
            if (arr.length == 0) return new int[0];
            int[] res = new int[k];
            Arrays.sort(arr);
            System.arraycopy(arr, 0, res, 0, k);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        final int[] res = new Solution().getLeastNumbers(new int[]{3, 2, 1}, 2);
        AssertTool.assertEquals(res, new int[]{1, 2});
    }
}