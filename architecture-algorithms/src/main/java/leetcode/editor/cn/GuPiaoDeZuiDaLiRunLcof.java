package leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;

/**
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 数组长度 <= 10^5
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 121 题相同：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-
 * stock/
 * Related Topics 数组 动态规划 👍 220 👎 0
 */
public class GuPiaoDeZuiDaLiRunLcof {

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxProfit(int[] prices) {
            if (prices.length < 2) return 0;
            int cost = Integer.MAX_VALUE, profit = 0;
            // 交易顺序与遍历顺序一致
            for (int price : prices) {
                // 找到最小的成本后停止
                cost = Math.min(price, cost);
                // 找到最大的利润后停止
                profit = Math.max(profit, price - cost);
            }
            return profit;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Assertions.assertEquals(0, new Solution().maxProfit(new int[]{7, 6, 4, 3, 1}));
        Assertions.assertEquals(5, new Solution().maxProfit(new int[]{7, 1, 4, 3, 6}));
        Assertions.assertEquals(2, new Solution().maxProfit(new int[]{2, 4, 1}));
    }
}