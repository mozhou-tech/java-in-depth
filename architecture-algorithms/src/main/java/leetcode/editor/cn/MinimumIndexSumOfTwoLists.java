package leetcode.editor.cn;

import java.util.*;

/**
 * /**
 * Suppose Andy and Doris want to choose a restaurant for dinner, and they both
 * have a list of favorite restaurants represented by strings.
 * <p>
 * You need to help them find out their common interest with the least list index
 * <p>
 * sum. If there is a choice tie between answers, output all of them with no order
 * <p>
 * requirement. You could assume there always exists an answer.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input:
 * list1 = ["Shogun","Tapioca Express","Burger King","KFC"],
 * list2 = ["Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"]
 * Output: ["Shogun"]
 * Explanation: The only restaurant they both like is "Shogun".
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"],
 * list2 = ["KFC","Shogun","Burger King"]
 * Output: ["Shogun"]
 * Explanation: The restaurant they both like and have the least index sum is
 * "Shogun" with index sum 1 (0+1).
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= list1.length, list2.length <= 1000
 * 1 <= list1[i].length, list2[i].length <= 30
 * list1[i] and list2[i] consist of spaces ' ' and English letters.
 * All the stings of list1 are unique.
 * All the stings of list2 are unique.
 * <p>
 * Related Topics 数组 哈希表 字符串 👍 167 👎 0
 */

public class MinimumIndexSumOfTwoLists {

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] findRestaurant(String[] list1, String[] list2) {
            // 保存更小的数组到哈希表，减少哈希表的开销
            if (list1.length > list2.length) {
                return findRestaurant(list2, list1);
            }
            // 构建HashMap
            Map<String, Integer> hashMap1 = new HashMap<>();
            for (int i = 0; i < list1.length; i++) hashMap1.put(list1[i], i);
            int min = Integer.MAX_VALUE;
            List<String> res = new ArrayList<>();
            // 遍历数组比遍历Map效率高
            // 以数组驱动HashMap校验
            for (int i = 0; i < list2.length; i++) {
                final String key = list2[i];
                // 通过遍历数组，减少一次Map的get操作
                if (!hashMap1.containsKey(key)) continue;
                int sum = hashMap1.get(key) + i;
                if (min == sum) res.add(key);
                if (min > sum) {
                    min = sum;
                    res.clear();
                    res.add(key);
                }
            }
            return res.toArray(String[]::new);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        String[] list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        final String[] restaurant = new Solution().findRestaurant(list1, list2);
        System.out.println(Arrays.toString(restaurant));
    }
}