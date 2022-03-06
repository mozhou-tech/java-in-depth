package leetcode.editor.cn;

import leetcode.editor.cn.common.ListNode;

import static leetcode.editor.cn.common.ListNodeUtil.fromArray;
import static leetcode.editor.cn.common.ListNodeUtil.toArrayString;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * <p>
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 * Related Topics 链表 双指针 👍 331 👎 0
 */
public class LianBiaoZhongDaoShuDiKgeJieDianLcof {

    static
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            int length = 1;
            ListNode curI = head, curJ = head;
            // 先获取长度
            while (curI != null) {
                curI = curI.next;
                length++;
            }
            // 倒数index改为正数index
            for (int l = 1; l < length - k; l++) {
                curJ = curJ.next;
            }
            return curJ;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        final ListNode res = new Solution().getKthFromEnd(fromArray(1, 2, 3, 4, 5), 2);
        System.out.println(toArrayString(res));
    }
}