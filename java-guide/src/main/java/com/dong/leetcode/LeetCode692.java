package com.dong.leetcode;

import java.util.*;

/**
 * 前K个高频单词
 * @version 1.0 2021/4/26
 * @author dongliyang
 */
public class LeetCode692 {

    public static void main(String[] args) {
        LeetCode692 code = new LeetCode692();

        List<String> f1 = code.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2);
        System.out.println("f1 = " + f1);
        List<String> f2 = code.topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4);
        System.out.println("f2 = " + f2);
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for(String word : words) {
            if(!map.containsKey(word)) {
                map.put(word,1);
            } else {
                map.put(word,map.get(word) + 1);
            }
        }

        PriorityQueue<Map.Entry<String,Integer>> q = new PriorityQueue<Map.Entry<String,Integer>>(map.size(),(a, b) -> {
            if(a.getValue() > b.getValue()) {
                return -1;
            } else if(a.getValue() < b.getValue()) {
                return 1;
            } else {
                return a.getKey().compareTo(b.getKey());
            }
        });

        for(Map.Entry<String,Integer> entry : map.entrySet()) {
            q.offer(entry);
        }

        List<String> result = new ArrayList<>();
        while(k > 0) {
            Map.Entry<String,Integer> entry = q.poll();
            result.add(entry.getKey());
            k--;
        }
        return result;
    }
}
