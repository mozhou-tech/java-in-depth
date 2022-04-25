package main

/**
给定二叉树的根节点 root ，返回所有左叶子之和。



 示例 1：




输入: root = [3,9,20,null,null,15,7]
输出: 24
解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24


 示例 2:


输入: root = [1]
输出: 0




 提示:


 节点数在 [1, 1000] 范围内
 -1000 <= Node.val <= 1000



 Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 438 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
// sumOfLeftLeaves 什么是左叶子：在左侧并且没有下级节点
func sumOfLeftLeaves(root *TreeNode) (ans int) {
	if root == nil {
		return ans
	}
	if root.Left != nil && root.Left.Left == nil && root.Left.Right == nil {
		ans += root.Left.Val
	}
	return sumOfLeftLeaves(root.Left) + sumOfLeftLeaves(root.Right) + ans
}

//leetcode submit region end(Prohibit modification and deletion)
