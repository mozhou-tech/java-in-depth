package main

/**
编写一个函数来查找字符串数组中的最长公共前缀。

 如果不存在公共前缀，返回空字符串 ""。



 示例 1：


输入：strs = ["flower","flow","flight"]
输出："fl"


 示例 2：


输入：strs = ["dog","racecar","car"]
输出：""
解释：输入不存在公共前缀。



 提示：


 1 <= strs.length <= 200
 0 <= strs[i].length <= 200
 strs[i] 仅由小写英文字母组成

 Related Topics 字符串 👍 2192 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
func longestCommonPrefix(strs []string) string {
	res := ""
	size := len(strs)
	flag := true
	if size == 1 {
		return strs[0]
	}
	if len(strs[0]) == 0 {
		return ""
	}
	for i := 0; i < len(strs[0]); i++ { // 搜索字符
		t := strs[0][i : i+1]
		res += t
		for j := 1; j < size; j++ { // 搜索数组
			if i+1 > len(strs[j]) || strs[j][i:i+1] != t {
				res = res[0 : len(res)-1]
				flag = false
				break
			}
		}
		if !flag {
			break
		}
	}
	return res
}

//leetcode submit region end(Prohibit modification and deletion)
