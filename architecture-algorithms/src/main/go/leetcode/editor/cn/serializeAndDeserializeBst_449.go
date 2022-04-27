package main

import (
	"fmt"
	"strconv"
	"strings"
	"unicode/utf8"
)

/**
序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。

 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化
为最初的二叉搜索树。

 编码的字符串应尽可能紧凑。



 示例 1：


输入：root = [2,1,3]
输出：[2,1,3]


 示例 2：


输入：root = []
输出：[]




 提示：


 树中节点数范围是 [0, 10⁴]
 0 <= Node.val <= 10⁴
 题目数据 保证 输入的树是一棵二叉搜索树。

 Related Topics 树 深度优先搜索 广度优先搜索 设计 二叉搜索树 字符串 二叉树 👍 263 👎 0

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

type Codec struct {
}

func Constructor() Codec {
	return Codec{}
}

// Serializes a tree to a single string.
func (this *Codec) serialize(root *TreeNode) (ret string) {
	if root == nil {
		return ""
	}
	queue := []*TreeNode{root}
	for len(queue) > 0 {
		node := queue[0:1][0]
		queue = queue[1:]
		nodeVal := -1
		if node != nil {
			nodeVal = node.Val
		}
		ret = ret + fmt.Sprintf("%d", nodeVal) + ","
		if node != nil {
			queue = append(queue, node.Left)
			queue = append(queue, node.Right)
		}
	}
	fmt.Println(ret)
	return ret
}

// Deserializes your encoded data to tree.
func (this *Codec) deserialize(data string) *TreeNode {
	if utf8.RuneCountInString(data) == 0 {
		return nil
	}
	splits := strings.Split(data, ",")
	stringToInt := func(split string) int {
		parseInt, _ := strconv.ParseInt(split, 10, 32)
		return int(parseInt)
	}
	var queue []*TreeNode
	root := &TreeNode{stringToInt(splits[0]), nil, nil}
	queue = append(queue, root)
	offset := 1
	for len(queue) > 0 && offset < len(splits) {
		node := queue[0:1][0]
		if stringToInt(splits[offset]) == -1 {
			node.Left = nil
		} else {
			node.Left = &TreeNode{stringToInt(splits[offset]), nil, nil}
			queue = append(queue, node.Left)
		}
		offset++
		if stringToInt(splits[offset]) == -1 {
			node.Right = nil
		} else {
			node.Right = &TreeNode{stringToInt(splits[offset]), nil, nil}
			queue = append(queue, node.Right)
		}
		offset++
		queue = queue[1:]
	}
	return root
}

/**
 * Your Codec object will be instantiated and called as such:
 * ser := Constructor()
 * deser := Constructor()
 * tree := ser.serialize(root)
 * ans := deser.deserialize(tree)
 * return ans
 */
//leetcode submit region end(Prohibit modification and deletion)
