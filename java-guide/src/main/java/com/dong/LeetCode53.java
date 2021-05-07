package com.dong;

public class LeetCode53 {

    public static void main(String[] args) {

        LeetCode53 code = new LeetCode53();

        int[] nums = new int[] { -2,1,-3,4,-1,2,1,-5,4 };
        int largestSum = code.maxSubArray(nums);
        System.out.println("largestSum = " + largestSum);
    }

    /**
     * 暴力法
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            int sum = 0;
            for(int j = i; j <nums.length;j++) {
                sum += nums[j];
                max = Math.max(sum,max);
            }
        }
        return max;
    }
}
