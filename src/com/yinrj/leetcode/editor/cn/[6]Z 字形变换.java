package com.yinrj.leetcode.editor.cn;

//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下： 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// 
//string convert(string s, int numRows); 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "PAYPALISHIRING", numRows = 3
//输出："PAHNAPLSIIGYIR"
// 
//
//示例 2：
//
// 
//输入：s = "PAYPALISHIRING", numRows = 4
//输出："PINALSIGYAHRPI"
//解释：
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// 示例 3： 
//
// 
//输入：s = "A", numRows = 1
//输出："A"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由英文字母（小写和大写）、',' 和 '.' 组成 
// 1 <= numRows <= 1000 
// 
//
// Related Topics 字符串 👍 2410 👎 0

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        char[][] board = new char[numRows][chars.length];
        for (int i = 0; i < numRows; ++i) {
            Arrays.fill(board[i], '0');
        }

        int dx = 0;
        int point = 0;

        int i = 0;
        int j = 0;
        while (point < chars.length) {
            board[i][j] = chars[point++];

            if (i == numRows - 1) {
                dx = 1;
            }
            if (i == 0) {
                dx = 0;
            }

            if (dx == 0) {
                ++i;
            }

            if (dx == 1) {
                --i;
                ++j;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int p = 0; p < numRows; ++p) {
            for (int k = 0; k < chars.length; ++k) {
                if (board[p][k] != '0') {
                    sb.append(board[p][k]);
                }
            }
        }

        return sb.toString();

    }
}
//leetcode submit region end(Prohibit modification and deletion)
