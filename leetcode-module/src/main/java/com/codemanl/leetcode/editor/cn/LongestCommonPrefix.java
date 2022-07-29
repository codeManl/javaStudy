package com.codemanl.leetcode.editor.cn;
//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 👍 1778 👎 0

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            int length = strs.length;
            if (length == 0) {
                return "";
            }
            String res = strs[0];
            for (int i = 1; i < length; i++) {
                int j = 0; // 因为循环外要知道j的值，所以将j提取出来
                for (; j < res.length() && j < strs[i].length(); j++) {
                    if (res.charAt(j) != strs[i].charAt(j)){
                        break;
                    }
                }
                res = res.substring(0,j);
            }


            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}