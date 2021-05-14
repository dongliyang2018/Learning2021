package com.dong.leetcode;

/**
 * 最长回文子串
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * 示例 3：
 * 输入：s = "a"
 * 输出："a"
 *
 * 示例 4：
 * 输入：s = "ac"
 * 输出："a"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * @version 1.0 2021/5/14
 * @author dongliyang
 */
public class LeetCode5 {
    public static void main(String[] args) {
        LeetCode5 code = new LeetCode5();
        System.out.println("code.longestPalindrome(\"babad\") = " + code.longestPalindrome("babad"));
        System.out.println("code.longestPalindrome(\"cbbd\") = " + code.longestPalindrome("cbbd"));
        System.out.println("code.longestPalindrome(\"a\") = " + code.longestPalindrome("a"));
        System.out.println("code.longestPalindrome(\"ac\") = " + code.longestPalindrome("ac"));
    }

    //暴力破解法
    public String longestPalindrome(String s) {
        //依次递减长度，尝试获取回文
        for(int i = s.length(); i >= 1;i--) {
            String result = tryLongestPalindrome(s,i);
            if(result != null) {
                return result;
            }
        }
        return null;
    }

    private String tryLongestPalindrome(String s,int length) {
        for(int i = 0; i <= s.length() - length; i++) {
            String str = s.substring(i,i + length);
            if(isPalindrome(str)) {
                return str;
            }
        }
        return null;
    }

    private boolean isPalindrome(String s) {
        if(s == null || s.equals("")) {
            return false;
        }
        if(s.length() == 1) {
            return true;
        }
        int l = 0;
        int r = s.length() - 1;
        while(l <= r) {
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
