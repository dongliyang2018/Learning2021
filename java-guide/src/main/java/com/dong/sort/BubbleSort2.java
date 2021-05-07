package com.dong.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * @version 1.0 2021/4/20
 * @author dongliyang
 */
public class BubbleSort2 implements ISort{

    @Override
    public void sort(int[] nums) {
        for (int i = nums.length; i > 0; i--) {
            bubble(nums, i);
        }
    }

    /**
     * 一次冒泡
     * @param nums
     * @param n n代表要排序的是前n个数字
     */
    private void bubble(int[] nums,int n) {
        int temp;
        for (int i = 0; i < n - 1; i++) {
            if(nums[i] > nums[i + 1]) {
                swap(nums, i, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 9, 6, 1, 3, 5};
        BubbleSort2 bubbleSort = new BubbleSort2();
        bubbleSort.sort(nums);
        System.out.println("nums = " + Arrays.toString(nums));
    }
}
