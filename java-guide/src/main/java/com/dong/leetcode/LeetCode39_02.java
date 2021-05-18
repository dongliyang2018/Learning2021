package com.dong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 *
 * 示例 1：
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * 示例 2：
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *  
 *
 * 提示：
 *
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * @version 1.0 2021/5/17
 * @author dongliyang
 */
public class LeetCode39_02 {

    public static void main(String[] args) {
        LeetCode39_02 code = new LeetCode39_02();
        System.out.println("code.combinationSum(new int[] { 2,3,6,7 }, 7) = " + code.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtracking(result, candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void backtracking(List<List<Integer>> result,int[] candidates,int target,int beginIndex,List<Integer> cur) {
        //退出条件，当target = 0的时候，说明已经找到符合条件的组合
        if (target == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }
        //target是递减的
        for (int i = beginIndex; i < candidates.length; i++) {
            //候选值应该小于等于target，大于的时候不符合，退出循环
            if (candidates[i] > target) {
                break;
            }
            //将候选值加入组合。因为已经将候选值加入了，因此，在下一次递归的时候，target就应该减去这个候选值
            cur.add(candidates[i]);
            backtracking(result, candidates, target - candidates[i],i,cur);
            //回溯，删除最后一个元素
            cur.remove(cur.size() - 1);
        }
    }
}
