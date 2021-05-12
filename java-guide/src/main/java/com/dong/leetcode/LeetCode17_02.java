package com.dong.leetcode;

import java.util.*;

/**
 * 电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * @version 1.0 2021/5/12
 * @author dongliyang
 */
public class LeetCode17_02 {

    public static void main(String[] args) {
        LeetCode17_02 code = new LeetCode17_02();
        System.out.println("code.letterCombinations(\"23\") = " + code.letterCombinations("23"));
        System.out.println("code.letterCombinations(\"\") = " + code.letterCombinations(""));
        System.out.println("code.letterCombinations(\"2\") = " + code.letterCombinations("2"));
        System.out.println("code.letterCombinations(\"78\") = " + code.letterCombinations("78"));
        System.out.println("code.letterCombinations(\"234\") = " + code.letterCombinations("234"));
    }


    /**
     * 使用DFS深度优先思想实现，回溯法
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.equals("")) {
            return new ArrayList<>(0);
        }
        Map<Character,String> map = numAlphabetMap();
        List<String> combinationList = new ArrayList<>();
        backtracking(combinationList,map,digits,0, new StringBuilder());
        return combinationList;
    }

    //深度优先，回溯法的思想
    private void backtracking(List<String> combinationList, Map<Character,String> numAlphabetMap, String digits, int index, StringBuilder preResult) {
        //退出条件，到达了字符串的末尾，说明到最后一层了
        if (index >= digits.length()) {
            combinationList.add(preResult.toString());
            return;
        }
        String item = numAlphabetMap.get(digits.charAt(index));
        for (char ch : item.toCharArray()) {
            preResult.append(ch);
            backtracking(combinationList,numAlphabetMap,digits, index + 1, preResult);
            //向上一层回溯，删除最后一个字符
            preResult.deleteCharAt(preResult.length() - 1);
        }
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
