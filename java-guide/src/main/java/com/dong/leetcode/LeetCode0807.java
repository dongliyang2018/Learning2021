package com.dong.leetcode;

import java.util.*;

/**
 * 无重复字符串的排列组合
 *
 * 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
 *
 * 示例1:
 *  输入：S = "qwe"
 *  输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
 *
 * 示例2:
 *  输入：S = "ab"
 *  输出：["ab", "ba"]
 *
 * 提示:
 * 字符都是英文字母。
 * 字符串长度在[1, 9]之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-i-lcci
 * @version 1.0 2021/5/18
 * @author dongliyang
 */
public class LeetCode0807 {

    public static void main(String[] args) {
        LeetCode0807 code = new LeetCode0807();
        System.out.println("code.permutation(\"qwe\") = " + Arrays.toString(code.permutation("qwe")));
    }

    public String[] permutation(String s) {
        List<String> result = new ArrayList<>();
        Map<Character,Boolean> map = new HashMap<>();
        backtracking(result, s, map, new StringBuilder());
        return result.toArray(new String[0]);
    }

    private void backtracking(List<String> result, String s, Map<Character,Boolean> visited, StringBuilder cur) {
        if (cur.length() == s.length()) {
            result.add(cur.toString());
            return;
        }
        for (char ch : s.toCharArray()) {
            if (!visited.getOrDefault(ch, false)) {
                visited.put(ch, true);
                cur.append(ch);
                backtracking(result, s, visited, cur);
                visited.put(ch, false);
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }
}
