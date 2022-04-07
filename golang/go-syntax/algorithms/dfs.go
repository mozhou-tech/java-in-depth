package main

import "encoding/json"

type Node struct {
	val   int
	left  *Node
	right *Node
}

var res []int

func main() {
	root := Node{1, nil, nil}
	root.left = new(Node)
	root.right = new(Node)
	root.left.val = 2
	root.right.val = 3
	root.right.right = new(Node)
	root.right.right.val = 5
	root.right.right.right = new(Node)
	root.right.right.right.val = 15
	dfs(root)
	v, err := json.Marshal(res)
	if err != nil {
		panic(v)
	}
	println(string(v))
}

//*和&的区别: & 是取地址符号, 即取得某个变量的地址,
//如; &a. *是指针运算符, 可以表示一个变量是指针类型,
//也可以表示一个指针变量所指向的存储单元, 也就是这个地址所存储的值.
func dfs(node Node) {
	res = append(res, node.val)
	if node.left != nil {
		dfs(*node.left)
	}
	if node.right != nil {
		dfs(*node.right)
	}
}
