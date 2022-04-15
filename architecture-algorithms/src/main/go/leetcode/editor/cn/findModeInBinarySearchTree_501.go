package main

/**
给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。

 如果树中有不止一个众数，可以按 任意顺序 返回。

 假定 BST 满足如下定义：


 结点左子树中所含节点的值 小于等于 当前节点的值
 结点右子树中所含节点的值 大于等于 当前节点的值
 左子树和右子树都是二叉搜索树




 示例 1：


输入：root = [1,null,2,2]
输出：[2]


 示例 2：


输入：root = [0]
输出：[0]




 提示：


 树中节点的数目在范围 [1, 10⁴] 内
 -10⁵ <= Node.val <= 10⁵




 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 442 👎 0

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
func findMode(root *TreeNode) (answer []int) {
	var dfs func(*TreeNode)
	var maxCount, base, count int
	update := func(value int) {
		if base == value {
			count++
		} else {
			// 此处count为何是1？
			base, count = value, 1
		}
		if count == maxCount {
			answer = append(answer, base)
		} else if count > maxCount {
			// 此处base是符合条件的answer
			answer = []int{base}
			maxCount = count
		}
	}
	// inorder遍历把BST转变为有序数组的遍历
	dfs = func(node *TreeNode) {
		if node == nil {
			return
		}
		if node.Left != nil {
			dfs(node.Left)
		}
		update(node.Val)
		if node.Right != nil {
			dfs(node.Right)
		}
	}
	dfs(root)
	return
}

//leetcode submit region end(Prohibit modification and deletion)
