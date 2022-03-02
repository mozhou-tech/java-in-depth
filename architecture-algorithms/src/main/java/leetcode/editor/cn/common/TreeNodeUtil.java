package leetcode.editor.cn.common;

import java.util.*;

/**
 * Created by liuyuancheng on 2022/3/2  <br/>
 *
 * @author liuyuancheng
 */
public class TreeNodeUtil {

    public static TreeNode fromArray(Integer[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        for (Integer num : nums) {
            nodes.offer(num == null ? null : new TreeNode(num));
        }
        TreeNode root = nodes.poll();
        TreeNode node = root;
        for (int i = 0; i < nodes.size(); i++) {
            node.left = nodes.poll();
            node.right = nodes.poll();
        }
        return root;
    }

    public static Integer[] toArray(TreeNode root) {
        if (null == root) {
            return new Integer[]{};
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            final TreeNode node = queue.poll();
            res.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return res.toArray(new Integer[0]);
    }

    public static void main(String[] args) {
        TreeNode node  = fromArray(new Integer[]{1, 2, 3, 4, 5, 6});
        System.out.println(Arrays.toString(toArray(node)));
    }
}
