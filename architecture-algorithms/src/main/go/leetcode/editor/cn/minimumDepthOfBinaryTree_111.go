package main

import "math"

/**
给定一个二叉树，找出其最小深度。

 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

 说明：叶子节点是指没有子节点的节点。



 示例 1：


输入：root = [3,9,20,null,null,15,7]
输出：2


 示例 2：


输入：root = [2,null,3,null,4,null,5,null,6]
输出：5




 提示：


 树中节点数的范围在 [0, 10⁵] 内
 -1000 <= Node.val <= 1000

 Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 726 👎 0

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
func minDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}
	if root.Left == nil && root.Right == nil {
		return 1
	}
	minD := math.MaxInt
	if root.Left != nil {
		minD = min(minD, minDepth(root.Left))
	}
	if root.Right != nil {
		minD = min(minD, minDepth(root.Right))
	}
	return minD + 1
}
func min(a, b int) int {
	if a > b {
		return b
	}
	return a
}

//leetcode submit region end(Prohibit modification and deletion)
