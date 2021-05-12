package com.dong.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 字符串解码
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例 1：
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 *
 * 示例 2：
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 *
 * 示例 3：
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 *
 * 示例 4：
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-string
 * @version 1.0 2021/5/12
 * @author dongliyang
 */
public class LeetCode394_02 {

    int pos;
    public static void main(String[] args) {
        LeetCode394_02 code = new LeetCode394_02();
        System.out.println("code.decodeString(\"3[a]2[bc]\") = " + code.decodeString("3[a]2[bc]"));
        System.out.println("code.decodeString(\"3[a2[c]]\") = " + code.decodeString("3[a2[c]]"));
        System.out.println("code.decodeString(\"2[abc]3[cd]ef\") = " + code.decodeString("2[abc]3[cd]ef"));
        System.out.println("code.decodeString(\"abc3[cd]xyz\") = " + code.decodeString("abc3[cd]xyz"));
    }

    public String decodeString(String s) {
        //使用LinkedList模拟栈
        LinkedList<String> stack = new LinkedList<>();
        pos = 0;

        while (pos < s.length()) {
            char ch = s.charAt(pos);
            if (Character.isLetter(ch) || ch == '[') {
                //字母或者左[，直接入栈
                stack.addLast(String.valueOf(ch));
                pos++;
            } else if (Character.isDigit(ch)) {
                //解析出数字，放到栈中。数字可能是两位或多位。比如78,156
                String digits = getDigits(s);
                stack.addLast(digits);
            } else if(ch == ']') {
                pos++;
                //开始出栈，直到遇到左[，得到括号内的字符串。再从栈中出一个元素，就是需要循环的次数
                LinkedList<String> sub = new LinkedList<>();
                while(!"[".equals(stack.getLast())) {
                    sub.addFirst(stack.removeLast());
                }
                //左括号[出栈
                stack.removeLast();
                int repTime = Integer.parseInt(stack.removeLast());
                String str = getString(sub);
                StringBuilder subResult = new StringBuilder();
                for (int i = 0; i < repTime; i++) {
                    subResult.append(str);
                }
                //将构造号的字符串入栈
                stack.addLast(subResult.toString());
            }
        }

        return getString(stack);
    }

    private String getDigits(String s) {
        StringBuilder result = new StringBuilder();
        while(Character.isDigit(s.charAt(pos))) {
            result.append(s.charAt(pos));
            pos++;
        }
        return result.toString();
    }

    private String getString(List<String> list) {
        StringBuilder result = new StringBuilder();
        for (String str : list) {
            result.append(str);
        }
        return result.toString();
    }

}
