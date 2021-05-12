package com.dong.leetcode;

import java.util.*;

/**
 * 电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * @version 1.0 2021/5/12
 * @author dongliyang
 */
public class LeetCode17 {

    public static void main(String[] args) {
        LeetCode17 code = new LeetCode17();
        System.out.println("code.letterCombinations(\"23\") = " + code.letterCombinations("23"));
        System.out.println("code.letterCombinations(\"\") = " + code.letterCombinations(""));
        System.out.println("code.letterCombinations(\"2\") = " + code.letterCombinations("2"));
        System.out.println("code.letterCombinations(\"78\") = " + code.letterCombinations("78"));
        System.out.println("code.letterCombinations(\"234\") = " + code.letterCombinations("234"));
    }


    /**
     * 使用BFS宽度优先的思想，借助队列实现
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.equals("")) {
            return new ArrayList<>(0);
        }
        Map<Character,String> map = numAlphabetMap();
        //LinkedList即实现了List，也实现了(双端)队列，因此使用这个数据结构
        LinkedList<String> q = new LinkedList<>();
        for (char ch : map.get(digits.charAt(0)).toCharArray()) {
            q.offer(ch + "");
        }

        for (int i = 1; i < digits.length(); i++) {
            String item = map.get(digits.charAt(i));
            int size = q.size();
            while (size > 0) {
                String cur = q.poll();
                //开始进行拼接
                for (char ch : item.toCharArray()) {
                    q.offer(cur + ch);
                }
                size--;
            }
        }
        return q;
    }

    private Map<Character,String> numAlphabetMap() {
        Map<Character,String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        return map;
    }
}
