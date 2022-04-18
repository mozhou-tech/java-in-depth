package main

import (
	"math"
)

/**
给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。

 差值是一个正数，其数值等于两值之差的绝对值。





 示例 1：


输入：root = [4,2,6,1,3]
输出：1


 示例 2：


输入：root = [1,0,48,null,null,12,49]
输出：1




 提示：


 树中节点的数目范围是 [2, 100]
 0 <= Node.val <= 10⁵




 注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 相同


 Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 二叉树 👍 216 👎 0

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
func minDiffInBST(root *TreeNode) int {
	res, last := math.MaxInt, -1
	var inorder func(node *TreeNode)
	update := func(val int) {
		if last == -1 {
			last = val
			return
		}
		if val-last < res {
			res = val - last
		}
		last = val
	}
	inorder = func(node *TreeNode) {
		if node.Left != nil {
			inorder(node.Left)
		}
		update(node.Val)
		if node.Right != nil {
			inorder(node.Right)
		}
	}
	inorder(root)
	return res
}

//leetcode submit region end(Prohibit modification and deletion)
