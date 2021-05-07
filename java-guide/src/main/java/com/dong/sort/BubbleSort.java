package com.dong.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * @version 1.0 2021/4/20
 * @author dongliyang
 */
public class BubbleSort implements ISort{

    @Override
    public void sort(int[] nums) {
        for(int i = 0,len = nums.length; i < len; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if(nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 9, 6, 1, 3, 5};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(nums);
        System.out.println("nums = " + Arrays.toString(nums));
    }
}
