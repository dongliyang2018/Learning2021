package com.dong.leetcode;

public class LeetCode53_02 {

    public static void main(String[] args) {

        LeetCode53_02 code = new LeetCode53_02();

        int[] nums = new int[] { -2,1,-3,4,-1,2,1,-5,4 };
        int largestSum = code.maxSubArray(nums);
        System.out.println("largestSum = " + largestSum);
    }

    /**
     * 分治法
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        return getMax(nums, 0, nums.length - 1);
    }

    private int getMax(int[] nums,int left,int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = left + (right - left) / 2;
        int leftMax = getMax(nums,left,mid);
        int rightMax = getMax(nums,mid + 1,right);
        int crossMax = getCrossMax(nums,left,right);

        return Math.max(Math.max(leftMax,rightMax),crossMax);
    }

    private int getCrossMax(int[] nums,int left,int right) {
        int mid = left + (right - left) / 2;
        int leftSum = nums[mid];
        int leftMax = leftSum;

        for(int i = mid - 1; i >= left; i--) {
            leftSum += nums[i];
            leftMax = Math.max(leftMax,leftSum);
        }

        int rightSum = nums[mid + 1];
        int rightMax = rightSum;

        for(int i = mid + 2; i <= right; i++){
            rightSum += nums[i];
            rightMax = Math.max(rightMax,rightSum);
        }

        return leftMax + rightMax;
    }
}
