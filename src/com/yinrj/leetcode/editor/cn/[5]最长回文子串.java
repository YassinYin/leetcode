package com.yinrj.leetcode.editor.cn;

//给你一个字符串 s，找到 s 中最长的 回文 子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 双指针 字符串 动态规划 👍 7425 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution5 {

    /**
     * 中心扩散
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int start = 0;
        int end = 0;
        int len = s.length();

        for (int i = 0; i < len; ++i) {
            int res1 = extendAround(s, i, i);
            int res2 = extendAround(s, i, i + 1);

            int res = Math.max(res1, res2);
            if (res > end - start) {
                start = i - (res - 1) / 2;
                end = i + res / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int extendAround(String s, int left, int right) {
        int len = s.length();
        while (right < len && left >= 0 && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }

    /**
     * 动态规划
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int maxLen = 1;
        int start = 0;
        int len = s.length();

        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; ++i) {
            dp[i][i] = true;
        }

        // 枚举长度
        for (int i = 2; i <= len; ++i) {
            for (int left = 0; left < len; ++left) {
                int right = left + i - 1;
                if (right >= len) {
                    break;
                }

                if (s.charAt(left) == s.charAt(right)) {
                    if (right - left < 3) {
                        dp[left][right] = true;
                    } else {
                        dp[left][right] = dp[left + 1][right - 1];
                    }
                }

                if (dp[left][right] && i > maxLen) {
                    maxLen = i;
                    start = left;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }

    /**
     * 暴力求解
     *
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        String res = "";

        int len = s.length();

        for (int i = 0; i < len; ++i) {
            for (int j = i; j < len; ++j) {
                if (judgement(s, i, j)) {
                    String item = s.substring(i, j + 1);
                    if (item.length() >= res.length()) {
                        res = item;
                    }
                }
            }
        }

        return res;
    }

    private boolean judgement(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            ++start;
            --end;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
