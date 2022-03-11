package leetcode.editor.cn.common;

import java.util.*;

/**
 * Created by liuyuancheng on 2022/3/2  <br/>
 *
 * @author liuyuancheng
 */
public class TreeNodeUtil {

    //TODO 数组转二叉树
    public static TreeNode fromArray(Integer... array) {
        if (array.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeft = true;
        for (int i = 1; i < array.length; i++) {
            TreeNode node = queue.peek();
            if (isLeft) {
                if (array[i] != null) {
                    node.left = new TreeNode(array[i]);
                    queue.offer(node.left);
                }
                isLeft = false;
            } else {
                if (array[i] != null) {
                    node.right = new TreeNode(array[i]);
                    queue.offer(node.right);
                }
                queue.poll();
                isLeft = true;
            }
        }
        return root;

    }


    public static Integer[] toArray(TreeNode root) {
        if (null == root) return new Integer[]{};
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        // BFS
        queue.offer(root);
        while (!queue.isEmpty()) {
            final TreeNode node = queue.poll();
            res.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return res.toArray(Integer[]::new);
    }

    public static String toArrayString(TreeNode root) {
        return Arrays.toString(toArray(root));
    }

    public static void main(String[] args) {
        TreeNode node = fromArray(new Integer[]{1, 2, 3, 4, 5, 6});
        System.out.println(Arrays.toString(toArray(node)));
    }
}
