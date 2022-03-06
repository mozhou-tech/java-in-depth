package leetcode.editor.cn.common;

import java.util.Arrays;

/**
 * Created by liuyuancheng on 2022/3/6  <br/>
 *
 * @author liuyuancheng
 */
public class ListNodeUtil {

    public static ListNode fromArray(Integer... args) {
        if (args.length == 0) return null;
        int i = 1;
        ListNode head = new ListNode(args[0]);
        ListNode cur = head;
        while (i < args.length) {
            cur.next = new ListNode(args[i]);
            cur = cur.next;
            i++;
        }
        return head;
    }

    public static int[] toArray(ListNode node) {
        ListNode cur = node;
        int[] res = new int[0];
        while (cur != null) {
            res = appendElement(res, cur.val);
            cur = cur.next;
        }
        return res;
    }

    public static String toArrayString(ListNode node){
        return Arrays.toString(toArray(node));
    }

    private static int[] appendElement(int[] nums, int e) {
        int[] res = new int[nums.length + 1];
        res[nums.length] = e;
        System.arraycopy(nums, 0, res, 0, nums.length);
        return res;
    }

    public static void main(String[] args) {
        final ListNode listNode = fromArray(1, 2, 3, 4);
        ListNode cur = listNode;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
        final int[] ints = toArray(listNode);
        System.out.println(Arrays.toString(ints));
    }
}
