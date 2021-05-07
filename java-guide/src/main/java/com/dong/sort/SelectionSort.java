package com.dong.sort;

import java.util.Arrays;

/**
 * 选择排序
 * @version 1.0 2021/4/20
 * @author dongliyang
 */
public class SelectionSort implements  ISort{

    @Override
    public void sort(int[] nums) {
        selectionSort(nums, nums.length);
    }

    private void selectionSort(int[] nums, int n) {
        while (n > 1) {
            int pos = findMaxPos(nums, n);
            swap(nums, pos, n - 1);
            n--;
        }
    }

    private int findMaxPos(int[] nums, int n) {
        int max = nums[0];
        int pos = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > max) {
                max = nums[i];
                pos = i;
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 9, 6, 1, 3, 5};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(nums);
        System.out.println("nums = " + Arrays.toString(nums));
    }

}
