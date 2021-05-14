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
public class LeetCode125 {

    public static void main(String[] args) {
        LeetCode125 code = new LeetCode125();
        System.out.println("code.isPalindrome(\"A man, a plan, a canal: Panama\") = " + code.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println("code.isPalindrome(\"race a car\") = " + code.isPalindrome("race a car"));
    }

    //筛选+判断
    public boolean isPalindrome(String s) {
        //思路：把符合条件的字母和数字放到字符串str中，判断逆序的字符串revStr和字符串str是否相等
        StringBuilder str = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                str.append(Character.toLowerCase(ch));
            }
        }
        return str.toString().equals(str.reverse().toString());
    }
}
