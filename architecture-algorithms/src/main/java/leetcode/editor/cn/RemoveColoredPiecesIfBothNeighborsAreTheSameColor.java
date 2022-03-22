package leetcode.editor.cn;

import leetcode.editor.cn.common.AssertTool;

/**
 * 总共有 n 个颜色片段排成一列，每个颜色片段要么是 'A' 要么是 'B' 。给你一个长度为 n 的字符串 colors ，其中 colors[i] 表示第
 * i 个颜色片段的颜色。
 * <p>
 * Alice 和 Bob 在玩一个游戏，他们 轮流 从这个字符串中删除颜色。Alice 先手 。
 * <p>
 * <p>
 * 如果一个颜色片段为 'A' 且 相邻两个颜色 都是颜色 'A' ，那么 Alice 可以删除该颜色片段。Alice 不可以 删除任何颜色 'B' 片段。
 * 如果一个颜色片段为 'B' 且 相邻两个颜色 都是颜色 'B' ，那么 Bob 可以删除该颜色片段。Bob 不可以 删除任何颜色 'A' 片段。
 * Alice 和 Bob 不能 从字符串两端删除颜色片段。
 * 如果其中一人无法继续操作，则该玩家 输 掉游戏且另一玩家 获胜 。
 * <p>
 * <p>
 * 假设 Alice 和 Bob 都采用最优策略，如果 Alice 获胜，请返回 true，否则 Bob 获胜，返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：colors = "AAABABB"
 * 输出：true
 * 解释：
 * AAABABB -> AABABB
 * Alice 先操作。
 * 她删除从左数第二个 'A' ，这也是唯一一个相邻颜色片段都是 'A' 的 'A' 。
 * <p>
 * 现在轮到 Bob 操作。
 * Bob 无法执行任何操作，因为没有相邻位置都是 'B' 的颜色片段 'B' 。
 * 因此，Alice 获胜，返回 true 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：colors = "AA"
 * 输出：false
 * 解释：
 * Alice 先操作。
 * 只有 2 个 'A' 且它们都在字符串的两端，所以她无法执行任何操作。
 * 因此，Bob 获胜，返回 false 。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：colors = "ABBBBBBBAAA"
 * 输出：false
 * 解释：
 * ABBBBBBBAAA -> ABBBBBBBAA
 * Alice 先操作。
 * 她唯一的选择是删除从右数起第二个 'A' 。
 * <p>
 * ABBBBBBBAA -> ABBBBBBAA
 * 接下来轮到 Bob 操作。
 * 他有许多选择，他可以选择任何一个 'B' 删除。
 * <p>
 * 然后轮到 Alice 操作，她无法删除任何片段。
 * 所以 Bob 获胜，返回 false 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= colors.length <= 10⁵
 * colors 只包含字母 'A' 和 'B'
 * <p>
 * Related Topics 贪心 数学 字符串 博弈 👍 54 👎 0
 */
public class RemoveColoredPiecesIfBothNeighborsAreTheSameColor {
    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 每个能被删除的元素前后一定都和当前元素一样。
         * 也就是只有出现连续的三个A或者三个B，我们才能进行删除。
         * 这意味着，删完之后，两个本来不相邻的B或者A，仍然不相邻。
         * 从而我们可以直接遍历统计A和B各能被删除多少，求差即可。当A-B>=1时，A胜利；反之B胜利。
         * @param colors
         * @return
         */
        public boolean winnerOfGame(String colors) {
            int diff = 0;
            // 转成bytes，使用数组效率更高
            final byte[] colorsb = colors.getBytes();
            for (int i = 1; i < colorsb.length - 1; i++) {
                if (colorsb[i] == 'A' && colorsb[i - 1] == 'A' && colorsb[i + 1] == 'A') diff++;
                if (colorsb[i] == 'B' && colorsb[i - 1] == 'B' && colorsb[i + 1] == 'B') diff--;
            }
            // Alice先手
            return diff >= 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        AssertTool.assertFalse(new Solution().winnerOfGame("ABBBBBBBAAA"));
    }
}