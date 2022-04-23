package main

import "fmt"

func main() {
	arr := []int{1, 2, 3, 4, 5, 6}
	for i := 0; i < 6; i++ {
		arr = arr[1:]
		fmt.Println()
		fmt.Printf("%v", arr)
		fmt.Println(len(arr))
	}
}
