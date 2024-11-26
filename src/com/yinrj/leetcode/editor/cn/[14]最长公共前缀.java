package com.yinrj.leetcode.editor.cn;

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
//
// Related Topics 字典树 字符串 👍 3226 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int minLen = Integer.MAX_VALUE;
        String minStr = "";
        for (String item : strs) {
            if (item.length() < minLen) {
                minLen = item.length();
                minStr = item;
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for (int i = 0; i < minLen; ++i) {
            char ch = minStr.charAt(i);
            for (String item : strs) {
                if (item.charAt(i) != ch) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                sb.append(ch);
            } else {
                break;
            }
        }

        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
