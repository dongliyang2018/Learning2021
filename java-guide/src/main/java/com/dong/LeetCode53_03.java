package com.dong;

public class LeetCode53_03 {

    public static void main(String[] args) {

        LeetCode53_03 code = new LeetCode53_03();

        int[] nums = new int[] { -2,1,-3,4,-1,2,1,-5,4 };
        int largestSum = code.maxSubArray(nums);
        System.out.println("largestSum = " + largestSum);
    }

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        int result = nums[0];

        for(int i = 1,len = nums.length; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i],nums[i]);
            result = Math.max(result,dp[i]);
        }

        return result;
    }

}
