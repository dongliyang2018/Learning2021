package com.dong.leetcode;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 *
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 * @version 1.0 2021/4/20
 * @author dongliyang
 */
public class LeetCode209 {

    public static void main(String[] args) {
        LeetCode209 code = new LeetCode209();
        System.out.println(code.minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
        System.out.println(code.minSubArrayLen(4, new int[]{1,4,4}));
        System.out.println(code.minSubArrayLen(11, new int[]{ 1,1,1,1,1,1,1,1}));
        System.out.println(code.minSubArrayLen(15, new int[]{1,2,3,4,5}));
    }

    //滑动窗口法
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0;
        int j = 0;
        int result = nums.length + 1;
        int total = 0;
        while(j < nums.length) {
            total += nums[j];
            j++;
            while(total >= target) {
                result = Math.min(result, j - i);
                total -= nums[i];
                i++;
            }
        }
        return result == nums.length + 1 ? 0 : result;

    }
}
