package com.dong;

import java.util.*;

public class LeetCode49 {

    public static void main(String[] args) {

        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};

        LeetCode49 code = new LeetCode49();
        List<List<String>> result = code.groupAnagrams(strs);
        System.out.println("result = " + result);
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> map = new HashMap<String, List<String>>();

        for(String str : strs) {
            String key = getAnagramsKey(str);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<String>());
            }
            map.get(key).add(str);
        }

        return new ArrayList<List<String>>(map.values());
    }

    private String getAnagramsKey(String str) {
        if(str.equals("")) {
            return "";
        }

        char[] chArr = str.toCharArray();
        Arrays.sort(chArr);

        return new String(chArr);
    }


    private String getAnagramsKey2(String str) {
        if(str.equals("")) {
            return "";
        }

        int[] countArr = new int[26];
        for(char ch : str.toCharArray()){
            countArr[ch - 'a']++;
        }

        String res = "";
        for(int i = 0,len = countArr.length; i < len; i++){
            res += "#" + countArr[i];
        }
        return res;
    }
}
