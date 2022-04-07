package main

type stack struct {
	items []int
}

func Constructor() stack {
	return stack{}
}

func (i *stack) push(item int) {
	if i == nil {
		// 指针的指针 是值本身
		*i = Constructor()
	}
	i.items = append(i.items, item)
}

func (i *stack) pop() int {
	top := len(i.items) - 1
	pop := i.items[top]
	items := i.items[0 : len(i.items)-1]
	i.items = items
	return pop
}

func main() {
	stack := stack{}
	stack.push(1)
	stack.push(2)
	stack.push(3)
	stack.push(4)
	println(stack.pop())
	println(stack.pop())
	println(stack.pop())
	println(stack.pop())
}
