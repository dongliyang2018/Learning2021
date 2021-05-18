package com.dong.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 字母大小写全排列
 *
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 * 示例：
 * 输入：S = "a1b2"
 * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * 输入：S = "3z4"
 * 输出：["3z4", "3Z4"]
 *
 * 输入：S = "12345"
 * 输出：["12345"]
 *
 * 提示：
 * S 的长度不超过12。
 * S 仅由数字和字母组成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-case-permutation
 * @version 1.0 2021/5/18
 * @author dongliyang
 */
public class LeetCode784 {

    public static void main(String[] args) {
        LeetCode784 code = new LeetCode784();
        System.out.println("code.letterCasePermutation(\"a1b2\") = " + code.letterCasePermutation("a1b2"));
        System.out.println("code.letterCasePermutation(\"3z4\") = " + code.letterCasePermutation("3z4"));
        System.out.println("code.letterCasePermutation(\"12345\") = " + code.letterCasePermutation("12345"));
    }

    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        backtracking(result, s, 0, new StringBuilder());
        return result;
    }

    private void backtracking(List<String> result, String s, int index,StringBuilder cur) {
        if (cur.length() == s.length()) {
            result.add(cur.toString());
            return;
        }
        char[] chArr = getCharArray(s, index);
        for (char ch : chArr) {
            cur.append(ch);
            backtracking(result, s, index + 1, cur);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    private char[] getCharArray(String s,int index) {
        char ch = s.charAt(index);
        char[] chArr = null;
        if (Character.isLetter(ch)) {
            chArr = new char[]{ Character.toLowerCase(ch), Character.toUpperCase(ch)};
        } else {
            chArr = new char[] { ch };
        }
        return chArr;
    }
}
