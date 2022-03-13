package leetcode.editor.cn.common;

import java.util.*;

/**
 * Created by liuyuancheng on 2022/3/2  <br/>
 *
 * @author liuyuancheng
 */
public class NodeUtil {

    //TODO 数组转二叉树
    public static Node fromArray(Integer... array) {
        if (array.length == 0) {
            return null;
        }
        Node root = new Node(array[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeft = true;
        for (int i = 1; i < array.length; i++) {
            Node node = queue.peek();
            if (isLeft) {
                if (array[i] != null) {
                    node.left = new Node(array[i]);
                    queue.offer(node.left);
                }
                isLeft = false;
            } else {
                if (array[i] != null) {
                    node.right = new Node(array[i]);
                    queue.offer(node.right);
                }
                queue.poll();
                isLeft = true;
            }
        }
        return root;

    }


    public static Integer[] toArray(Node root) {
        if (null == root) return new Integer[]{};
        Queue<Node> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        // BFS
        queue.offer(root);
        while (!queue.isEmpty()) {
            final Node node = queue.poll();
            res.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return res.toArray(Integer[]::new);
    }

    public static String toArrayString(Node root) {
        return Arrays.toString(toArray(root));
    }

    public static void main(String[] args) {
        Node node = fromArray(new Integer[]{1, 2, 3, 4, 5, 6});
        System.out.println(Arrays.toString(toArray(node)));
    }
}
