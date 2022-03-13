package leetcode.editor.cn.common;

/**
 * Created by liuyuancheng on 2022/3/2  <br/>
 *
 * @author liuyuancheng
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString(){
        return String.valueOf(val);
    }
}
