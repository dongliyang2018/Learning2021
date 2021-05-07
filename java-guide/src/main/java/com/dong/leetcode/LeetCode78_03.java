package com.dong.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * @version 1.0 2021/4/15
 * @author dongliyang
 */
public class LeetCode78_03 {

    public static void main(String[] args) {
        LeetCode78_03 code = new LeetCode78_03();
        int[] nums = new int[]{ 1,2,3 };
        List<List<Integer>> subsets = code.subsets(nums);
        System.out.println("subsets = " + subsets);
    }

    //深度优先法
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, nums, 0,new ArrayList<>());
        return result;
    }

    private void dfs(List<List<Integer>> result,int[] nums,int index,List<Integer> subset){
        result.add(new ArrayList<>(subset));

        if(index == nums.length) {
            return;
        }

        for(int i = index; i < nums.length; i++) {
            subset.add(nums[i]);
            dfs(result, nums, i + 1, subset);

            subset.remove(subset.size() - 1);
        }
    }
}
