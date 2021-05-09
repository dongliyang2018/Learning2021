package com.dong.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 词典中最长的单词
 * 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返回答案中字典序最小的单词。
 *
 * 若无答案，则返回空字符串。

 * 示例 1：
 *
 * 输入：
 * words = ["w","wo","wor","worl", "world"]
 * 输出："world"
 * 解释：
 * 单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
 *
 * 示例 2：
 * 输入：
 * words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * 输出："apple"
 * 解释：
 * "apply"和"apple"都能由词典中的单词组成。但是"apple"的字典序小于"apply"。
 *
 * @version 1.0 2021/5/10
 * @author dongliyang
 */
public class LeetCode720 {

    public static void main(String[] args) {
        LeetCode720 code = new LeetCode720();
        String r1 = code.longestWord(new String[]{"w", "wo", "wor", "worl", "world"});
        System.out.println("r1 = " + r1 + ",isRight:" + "world".equals(r1));
        String r2 = code.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"});
        System.out.println("r2 = " + r2 + ",isRight:" + "apple".equals(r2));
    }

    public String longestWord(String[] words) {
        if (words == null || words.length == 0) {
            return null;
        }
        //借助set，用于判断字符串是否存在数组。时间复杂度O(1)。
        //如果不借助set，循环数组挨个判断，时间复杂度O(N)。
        Set<String> set = new HashSet<>(Arrays.asList(words));

        //用于存放满足条件的字符串
        String result = "";

        for (String word : words) {
            //1.字符串长度，比result大，有可能是满足条件的一个新的字符串
            //2.字符串长度相同，但是字典顺序小
            if (word.length() > result.length() ||
                (word.length() == result.length() && word.compareTo(result) < 0)) {
                if (isAllInArray(set, word)) {
                    result = word;
                }
            }
        }
        return result;
    }

    private boolean isAllInArray(Set<String> set, String word) {
        for (int i = 1, len = word.length(); i <= len; i++) {
            if(!set.contains(word.substring(0,i))) {
                return false;
            }
        }
        return true;
    }
}
