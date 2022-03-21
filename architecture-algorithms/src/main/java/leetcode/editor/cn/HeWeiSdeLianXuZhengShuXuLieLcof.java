package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 

 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 

 

 示例 1： 

 输入：target = 9
输出：[[2,3,4],[4,5]]
 

 示例 2： 

 输入：target = 15
输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 

 

 限制： 

 
 1 <= target <= 10^5 
 

 
 Related Topics 数学 双指针 枚举 👍 397 👎 0

*/
public class HeWeiSdeLianXuZhengShuXuLieLcof{
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 枚举思想
     *
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<int[]>();
        return res.toArray(new int[res.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


  public static void main(String[] args) {
 
  }
}