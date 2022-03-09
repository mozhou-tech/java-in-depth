package leetcode.editor.cn;

import leetcode.editor.cn.common.AssertTool;
import leetcode.editor.cn.common.ListNode;
import leetcode.editor.cn.common.ListNodeUtil;

import static leetcode.editor.cn.common.ListNodeUtil.fromArray;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 * <p>
 * Related Topics 递归 链表 数学 👍 7651 👎 0
 */
public class AddTwoNumbers {

    static
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
    class Solution {

        // 顺着链表依次相加进位
        //TODO 只是进位方向的区别，逆向思维
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode res = new ListNode(0);
            int carry = 0; // 进位
            ListNode resCur = res;
            while (l1 != null || l2 != null) {
                int a = l1 == null ? 0 : l1.val;
                int b = l2 == null ? 0 : l2.val;
                // 移位
                if (l1 != null) l1 = l1.next;
                if (l2 != null) l2 = l2.next;
                int val = a + b + carry;
                resCur.next = new ListNode(val % 10);
                carry = val / 10;
                resCur = resCur.next;
            }
            // 如果余下carry，需要向前进位
            if (carry != 0) resCur.next = new ListNode(carry);
            return res.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
//      输入：l1 = [2,4,3], l2 = [5,6,4]
//      输出：[7,0,8]
        final ListNode listNode = new Solution().addTwoNumbers(fromArray(2, 4, 9), fromArray(5, 6, 4, 9));
        AssertTool.assertEquals(listNode, fromArray(7, 0, 4, 0, 1));
    }
}