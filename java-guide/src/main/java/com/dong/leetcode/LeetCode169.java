package com.dong.leetcode;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1：
 * 输入：[3,2,3]
 * 输出：3
 *
 * 示例 2：
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 * @version 1.0 2021/4/16
 * @author dongliyang
 */
public class LeetCode169 {
    public static void main(String[] args) {
        LeetCode169 code = new LeetCode169();
        int[] nums = new int[]{1,1,2,2,2,3,3,3,3};
        int majority = code.majorityElement(nums);
        System.out.println("majority = " + majority);
    }

    //投票法
    public int majorityElement(int[] nums) {
        int count = 1;
        int compare = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(compare == nums[i]) {
                count++;
            } else if(compare != nums[i]) {
                count--;
            }
            if(count == 0) {
                compare = nums[i + 1];
            }
        }
        return compare;
    }
}
