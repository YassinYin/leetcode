package com.yinrj.leetcode.editor.cn;

//给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
//如果 needle 不是 haystack 的一部分，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "sadbutsad", needle = "sad"
//输出：0
//解释："sad" 在下标 0 和 6 处匹配。
//第一个匹配项的下标是 0 ，所以返回 0 。
// 
//
// 示例 2： 
//
// 
//输入：haystack = "leetcode", needle = "leeto"
//输出：-1
//解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= haystack.length, needle.length <= 10⁴ 
// haystack 和 needle 仅由小写英文字符组成 
// 
//
// Related Topics 双指针 字符串 字符串匹配 👍 2318 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution28 {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }

        if (haystack.equals(needle)) {
            return 0;
        }

        if (needle.length() >= haystack.length()) {
            return -1;
        }

        int res = -1;
        int size = needle.length();

        for (int i = 0; i < haystack.length() - size + 1; ++i) {
            if (haystack.charAt(i) == needle.charAt(0) && needle.equals(haystack.substring(i, i + size))) {
                res = i;
                break;
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
