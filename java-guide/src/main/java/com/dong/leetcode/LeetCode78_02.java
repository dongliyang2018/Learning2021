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
public class LeetCode78_02 {

    public static void main(String[] args) {
        LeetCode78_02 code = new LeetCode78_02();
        int[] nums = new int[]{ 1,2,3 };
        List<List<Integer>> subsets = code.subsets(nums);
        System.out.println("subsets = " + subsets);
    }

    //回溯法
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(0));

        for(int i = 1;  i <= nums.length; i++) {
            backtracking(result, nums, i, 0, new ArrayList<>());
        }
        return result;
    }

    private void backtracking(List<List<Integer>> result,int[] nums,int length,int index,List<Integer> cur){
        if (cur.size() == length) {
            result.add(new ArrayList<>(cur));
            return;
        }

        for(int i = index; i < nums.length; i++) {
            cur.add(nums[i]);
            backtracking(result, nums, length, i + 1, cur);

            cur.remove(cur.size() - 1);
        }
    }
}
