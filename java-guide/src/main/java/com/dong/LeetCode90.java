package com.dong;

import java.util.*;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 * 示例 1：
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 * @version 1.0 2021/4/15
 * @author dongliyang
 */
public class LeetCode90 {

    public static void main(String[] args) {
        LeetCode90 code = new LeetCode90();
        int[] nums = new int[]{ 1,2,2 };
        List<List<Integer>> subsets = code.subsets(nums);
        System.out.println("subsets = " + subsets);
    }

    //扩展法
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new LinkedHashSet<>();
        result.add(Arrays.asList());

        for(int num : nums) {
            List<List<Integer>> curList = new ArrayList<>();
            for(List<Integer> before : result) {
                ArrayList<Integer> cur = new ArrayList<>(before);
                cur.add(num);
                curList.add(cur);
            }
            result.addAll(curList);
        }
        
        return new ArrayList<>(result);
    }
}
