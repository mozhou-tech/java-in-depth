package leetcode.editor.cn;

import leetcode.editor.cn.common.ListNode;

import static leetcode.editor.cn.common.ListNodeUtil.fromArray;
import static leetcode.editor.cn.common.ListNodeUtil.toArrayString;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * <p>
 * 示例1：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 1000
 * <p>
 * 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * Related Topics 递归 链表 👍 217 👎 0
 */
public class HeBingLiangGePaiXuDeLianBiaoLcof {

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
        // 类似于归并
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            ListNode res = new ListNode(0);
            ListNode cur = res;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    cur.next = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    cur.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
                cur = cur.next;
            }
            if (l2 != null) cur.next = l2;
            else if (l1 != null) cur.next = l1;
            return res.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        final ListNode listNode = new Solution().mergeTwoLists(fromArray(1, 2, 3), fromArray(1, 3, 4));
        System.out.println(toArrayString(listNode));
    }
}