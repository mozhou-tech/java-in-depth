package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。
 * 求出这个圆圈里剩下的最后一个数字。
 * <p>
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入: n = 5, m = 3
 * 输出: 3
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入: n = 10, m = 17
 * 输出: 2
 * <p>
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * <p>
 * 1 <= n <= 10^5
 * 1 <= m <= 10^6
 * <p>
 * Related Topics 递归 数学 👍 567 👎 0
 */
public class YuanQuanZhongZuiHouShengXiaDeShuZiLcof {
    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 约瑟夫环：动态规划
         * https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/jian-zhi-offer-62-yuan-quan-zhong-zui-ho-dcow/
         *
         * @param n
         * @param m
         * @return
         */
        public int lastRemaining(int n, int m) {
            int x = 0;
            for (int i = 2; i <= n; i++) {
                // 状态转移方程：dp[i]=(dp[i−1]+m) % i
                x = (x + m) % i;
            }
            return x;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {

    }
}