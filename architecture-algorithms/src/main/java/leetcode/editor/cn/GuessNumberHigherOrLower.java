package leetcode.editor.cn;

/**
 * 猜数字游戏的规则如下：
 * <p>
 * <p>
 * 每轮游戏，我都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
 * 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
 * <p>
 * <p>
 * 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：
 * <p>
 * <p>
 * -1：我选出的数字比你猜的数字小 pick < num
 * 1：我选出的数字比你猜的数字大 pick > num
 * 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
 * <p>
 * <p>
 * 返回我选出的数字。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 10, pick = 6
 * 输出：6
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 1, pick = 1
 * 输出：1
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：n = 2, pick = 1
 * 输出：1
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * <p>
 * 输入：n = 2, pick = 2
 * 输出：2
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 2³¹ - 1
 * 1 <= pick <= n
 * <p>
 * Related Topics 二分查找 交互 👍 190 👎 0
 */
public class GuessNumberHigherOrLower {

    static
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return         -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

    public class Solution extends GuessGame {
        public int guessNumber(int n) {
            if (guess(n) == 0) return n;
            int flag = -1;
            int left = 1, right = n;
            int mid = 0;
            while (left <= right && flag != 0) {
                mid = left + (right - left) / 2;
                flag = guess(mid);
                if (flag == -1) right = mid;
                if (flag == 1) left = mid;
            }
            return mid;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        System.out.println(new Solution().guessNumber(10));
    }
}

class GuessGame {
    int guess(int n) {
        if (n == 6) return 0;
        return n > 6 ? -1 : 1;
    }
}
