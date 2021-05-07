package com.dong.leetcode;

import java.util.Stack;

/**
 * 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 *
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 *
 * 示例 4：
 * 输入：s = "([)]"
 * 输出：false
 *
 * 示例 5：
 * 输入：s = "{[]}"
 * 输出：true
 * @version 1.0 2021/4/24
 * @author dongliyang
 */
public class LeetCode20 {
    //本题考察栈Stack的应用

    public static void main(String[] args) {
        LeetCode20 code = new LeetCode20();
        assert (code.isValid("()") == true);
        assert (code.isValid("()[]{}") == true);
        assert (code.isValid("(]") == false);
        assert (code.isValid("([)]") == false);
        assert (code.isValid("{[]}") == true);
        System.out.println("OK");
    }

    public boolean isValid(String s) {
        if (s == null || s.equals("")) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                //如果没有右括号，直接返回false
                if (stack.isEmpty()) {
                    return false;
                }
                char temp = stack.pop();
                if (temp == ')' && ch != '(') {
                    return false;
                }
                if (temp == ']' && ch != '[') {
                    return false;
                }
                if (temp == '}' && temp != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
