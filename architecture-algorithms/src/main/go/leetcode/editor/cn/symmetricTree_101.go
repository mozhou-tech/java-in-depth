package main

import "fmt"

/**
给你一个二叉树的根节点 root ， 检查它是否轴对称。



 示例 1：


输入：root = [1,2,2,3,4,4,3]
输出：true


 示例 2：


输入：root = [1,2,2,null,3,null,3]
输出：false




 提示：


 树中节点数目在范围 [1, 1000] 内
 -100 <= Node.val <= 100




 进阶：你可以运用递归和迭代两种方法解决这个问题吗？
 Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1874 👎 0

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
func isSymmetric(root *TreeNode) bool {
	if root == nil {
		return true
	}
	var queue []*TreeNode
	queue = append(queue, root)
	symArr := func(ints []int) bool {
		fmt.Println(ints)
		size := len(ints)
		for i := 0; i < size/2; i++ {
			if ints[i] != ints[size-1-i] {
				return false
			}
		}
		return true
	}
	for len(queue) > 0 {
		size := len(queue)
		var arr []int
		for i := 0; i < size; i++ {
			node := queue[0:1][0]
			queue = queue[1:]
			if node == nil {
				arr = append(arr, -1)
			} else {
				arr = append(arr, node.Val)
			}
			if node != nil {
				if node.Left != nil {
					queue = append(queue, node.Left)
				} else {
					queue = append(queue, nil)
				}
				if node.Right != nil {
					queue = append(queue, node.Right)
				} else {
					queue = append(queue, nil)
				}
			}
		}
		if !symArr(arr) {
			return false
		}
	}
	return true
}

//leetcode submit region end(Prohibit modification and deletion)
