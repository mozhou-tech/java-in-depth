package main

import "errors"

type stack struct {
	items []int
}

func (i *stack) push(item int) {
	if i == nil {
		*i = stack{}
	}
	i.items = append(i.items, item)
}

func (i *stack) pop() (int, error) {
	top := len(i.items) - 1
	if top < 0 {
		// panic 主动抛出异常
		//panic("error")
		return 0, errors.New("empty items.")
	}
	pop := i.items[top]
	items := i.items[0 : len(i.items)-1]
	i.items = items
	return pop, nil
}

func main() {
	stack := stack{[]int{1, 2, 3, 4, 5, 6}}
	println(stack.pop())
	println(stack.pop())
	println(stack.pop())
	println(stack.pop())
	println(stack.pop())
	println(stack.pop())
	println(stack.pop())
}
