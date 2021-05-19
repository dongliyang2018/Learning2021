package com.dong.leetcode;

import java.util.*;

/**
 * 全排列 II
 *
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 *
 * 示例 2：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *  
 *
 * 提示：
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @version 1.0 2021/5/19
 * @author dongliyang
 */
public class LeetCode47 {

    public static void main(String[] args) {
        LeetCode47 code = new LeetCode47();
        System.out.println("code.permuteUnique(new int[] { 1,1,2 }) = " + code.permuteUnique(new int[]{1, 1, 2}));
        System.out.println("code.permuteUnique(new int[] { 1,2,3 }) = " + code.permuteUnique(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer,Boolean> visited = new HashMap<>();
        Set<String> all = new HashSet<>();
        backtracking(result,nums,visited,all, new ArrayList<>());
        return result;
    }

    private void backtracking(List<List<Integer>> result, int[] nums, Map<Integer, Boolean> visited, Set<String> all,List<Integer> cur) {
        if (cur.size() == nums.length) {
            if(!all.contains(cur.toString())) {
                all.add(cur.toString());
                result.add(new ArrayList<>(cur));
            }
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited.getOrDefault(i, false)) {
                visited.put(i, true);
                cur.add(nums[i]);
                backtracking(result, nums, visited,all,cur);
                visited.put(i, false);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
