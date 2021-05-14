package com.dong.leetcode;

/**
 * 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * @version 1.0 2021/5/14
 * @author dongliyang
 */
public class LeetCode125_02 {

    public static void main(String[] args) {
        LeetCode125_02 code = new LeetCode125_02();
        System.out.println("code.isPalindrome(\"A man, a plan, a canal: Panama\") = " + code.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println("code.isPalindrome(\"race a car\") = " + code.isPalindrome("race a car"));
        System.out.println("code.isPalindrome(\" \") = " + code.isPalindrome(" "));
    }

    //双指针方法
    public boolean isPalindrome(String s) {
        //思路：双指针，一个指向头部，一个指向尾部，判断它们指向的字符是否相等。但是需要指向符合条件的字符：字母和数字
        int l = 0;
        int r = s.length() - 1;

        while (l <= r) {
            while(l < s.length() && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while (r >= 0 && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            if (l < s.length() && r >= 0 && Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
