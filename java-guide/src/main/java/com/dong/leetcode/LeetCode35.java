package com.dong.leetcode;

public class LeetCode35 {

    public static void main(String[] args) {
        String str = "tea";

        for(char ch : str.toCharArray()) {

        }
    }

    public int searchInsert(int[] nums, int target) {

        if(nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;

        while(left <  right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return nums[left] < target ? left + 1 : left;
    }
}
