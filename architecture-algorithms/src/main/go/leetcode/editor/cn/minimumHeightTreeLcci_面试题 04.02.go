package main

/**
给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。示例: 给定有序数组: [-10,-3,0,5,9], 一个可能的答
案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：           0          / \        -3
9        /   /      -10  5 Related Topics 树 二叉搜索树 数组 分治 二叉树 👍 122 👎 0

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
func sortedArrayToBST1(nums []int) *TreeNode {
	var helper func(nums []int, left int, right int) *TreeNode
	helper = func(nums []int, left int, right int) *TreeNode {
		if left > right {
			return nil
		}
		mid := left + ((right - left) / 2)
		node := &TreeNode{Val: nums[mid]}
		node.Left = helper(nums, left, mid-1)
		node.Right = helper(nums, mid+1, right)
		return node
	}
	return helper(nums, 0, len(nums)-1)
}

//leetcode submit region end(Prohibit modification and deletion)
