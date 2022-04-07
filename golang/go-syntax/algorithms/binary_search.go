package main

func main() {
	nums := []int{1, 2, 3, 4, 5}
	println(binarySearch(nums, 2))
}

func binarySearch(nums []int, target int) int {
	res := -1
	left := 0
	right := len(nums)
	for left <= right {
		mid := (left + right) >> 1
		if nums[mid] <= target {
			res = mid
			left = mid + 1
		} else {
			right = mid - 1
		}
	}
	return res
}
