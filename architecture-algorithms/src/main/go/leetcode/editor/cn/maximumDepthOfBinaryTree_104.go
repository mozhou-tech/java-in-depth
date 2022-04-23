package main

/**
给定一个二叉树，找出其最大深度。

 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

 说明: 叶子节点是指没有子节点的节点。

 示例：
给定二叉树 [3,9,20,null,null,15,7]，

     3
   / \
  9  20
    /  \
   15   7

 返回它的最大深度 3 。
 Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1211 👎 0

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
func maxDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}
	var queue []*TreeNode
	queue = append(queue, root)
	cnt := 0
	for len(queue) > 0 {
		// 每一层的节点数量
		size := len(queue)
		for size > 0 {
			node := queue[0:1][0]
			queue = queue[1:]
			if node.Left != nil {
				queue = append(queue, node.Left)
			}
			if node.Right != nil {
				queue = append(queue, node.Right)
			}
			size--
		}
		cnt++
	}
	return cnt
}

//leetcode submit region end(Prohibit modification and deletion)
