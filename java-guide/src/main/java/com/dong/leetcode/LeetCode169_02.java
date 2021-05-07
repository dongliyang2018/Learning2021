package com.dong.leetcode;

import java.util.Arrays;

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
public class LeetCode169_02 {
    public static void main(String[] args) {
        LeetCode169_02 code = new LeetCode169_02();
        int[] nums = new int[]{1,1,2,2,3,3,3,3,3};
        int majority = code.majorityElement(nums);
        System.out.println("majority = " + majority);
    }

    //投票法
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[(int)Math.ceil(nums.length * 1.0 / 2)];
    }
}
