package com.dong.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode46 {

    public static void main(String[] args) {

        LeetCode46 code = new LeetCode46();

        int[] nums = new int[] {1,2,3};
        List<List<Integer>> permute = code.permute(nums);
        System.out.println("permute = " + permute);
    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Map<Integer,Boolean> visited = new HashMap<Integer, Boolean>();

        for (int num : nums) {
            visited.put(num, false);
        }

        backtracking(nums,res,visited,new ArrayList<Integer>());

        return res;
    }

    private void backtracking(int[] nums, List<List<Integer>> res, Map<Integer,Boolean> visited,List<Integer> cur) {

        //递归的退出条件时，当前cur里包含的元素数量等于nums的length。即：已包含所有元素。
        if (cur.size() == nums.length) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }

        for (int num : nums) {
            //当没有访问过时才进行下面的处理
            if (!visited.get(num)) {
                cur.add(num);
                //已经访问过了
                visited.put(num, true);

                //进入下一层递归
                backtracking(nums,res,visited,cur);

                //当从下一层递归返回后，到了本层。那么删除最后一个访问的元素，
                cur.remove(cur.size() - 1);
                visited.put(num,false);
            }
        }

    }
}
