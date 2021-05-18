package com.dong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和 II
 *
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 *
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 *
 * 示例 2:
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * @version 1.0 2021/5/18
 * @author dongliyang
 */
public class LeetCode40 {

    public static void main(String[] args) {
        LeetCode40 code = new LeetCode40();
        System.out.println("code.combinationSum2(new int[] { 10,1,2,7,6,1,5 },8) = " + code.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println("code.combinationSum2(new int[] { 2,5,2,1,2 },5) = " + code.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        //1,1,2,5,6,7,10
        List<List<Integer>> result = new ArrayList<>();
        backtracking(result, candidates, target, 0, 0, new ArrayList<>());
        return result;
    }

    private void backtracking(List<List<Integer>> result, int[] candidates, int target, int begin, int sum, List<Integer> cur) {
        if (sum == target) {
            result.add(new ArrayList<>(cur));
            return;
        }
        int i = begin;
        while(i < candidates.length) {
            sum += candidates[i];
            if (sum <= target) {
                cur.add(candidates[i]);
                backtracking(result, candidates, target, i + 1, sum, cur);
                sum -= candidates[i];
                cur.remove(cur.size() - 1);

                int j = i + 1;
                while (j < candidates.length && candidates[j] == candidates[i]) {
                    j++;
                }
                i = j;
            } else {
                break;
            }
        }
    }
}
