package com.dong.leetcode;

import java.util.*;

/**
 * 前 K 个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * @version 1.0 2021/5/12
 * @author dongliyang
 */
public class LeetCode347 {

    public static void main(String[] args) {
        LeetCode347 code = new LeetCode347();
        System.out.println("code.topKFrequent(new int[] { 1,1,1,2,2,3 }, 2) = " + Arrays.toString(code.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println("code.topKFrequent(new int[] { 1 }, 1) = " + Arrays.toString(code.topKFrequent(new int[]{1}, 1)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> counterMap = new HashMap<>();
        for (int num : nums) {
            if (!counterMap.containsKey(num)) {
                counterMap.put(num, 1);
            } else {
                counterMap.put(num, counterMap.get(num) + 1);
            }
        }

        //最大堆，使用数字出现的次数进行排序
        PriorityQueue<Map.Entry<Integer,Integer>> q = new PriorityQueue<>((a,b) ->  b.getValue() - a.getValue());

        for (Map.Entry<Integer, Integer> entry : counterMap.entrySet()) {
            q.offer(entry);
        }

        int[] result = new int[k];
        int index = 0;
        //从最大堆里取数据
        while(k > 0) {
            Map.Entry<Integer, Integer> entry = q.poll();
            result[index++] = entry.getKey();
            k--;
        }
        return result;
    }
}
