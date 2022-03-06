package leetcode.editor.cn;

import leetcode.editor.cn.common.ListNode;
import leetcode.editor.cn.common.ListNodeUtil;

import java.util.Arrays;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * <p>
 * 返回删除后的链表的头节点。
 * <p>
 * 注意：此题对比原题有改动
 * <p>
 * 示例 1:
 * <p>
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * <p>
 * <p>
 * <p>
 * <p>
 * 说明：
 * <p>
 * <p>
 * 题目保证链表中节点的值互不相同
 * 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 * <p>
 * Related Topics 链表 👍 197 👎 0
 */
public class ShanChuLianBiaoDeJieDianLcof {

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
        public ListNode deleteNode(ListNode head, int val) {
            ListNode cur = head, root = head, pre = null;
            while (cur != null) {
                if (cur.val == val) {
                    if (pre != null) {
                        pre.next = cur.next;
                        cur = pre.next;
                    } else {
                        root = cur.next;
                        cur = root;
                    }
                } else {
                    pre = cur;
                    cur = cur.next;
                }
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        ListNode res = new Solution().deleteNode(ListNodeUtil.fromArray(-3, 5, -99), -99);
        System.out.println(Arrays.toString(ListNodeUtil.toArray(res)));
    }
}