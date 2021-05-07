package com.dong.sort;

import java.util.Arrays;

/**
 * 插入排序
 * @version 1.0 2021/4/20
 * @author dongliyang
 */
public class InsertionSort implements ISort {

    @Override
    public void sort(int[] nums) {
        insertSort(nums, nums.length);
    }

    private void insertSort(int[] nums, int n) {
        for (int i = 1; i < n; i++) {
            insert(nums, i);
        }
    }

    private void insert(int[] nums,int n) {
        int key = nums[n];
        int i = n;
        while (nums[i - 1] > key) {
            nums[i] = nums[i - 1];
            i--;
            if (i == 0) {
                break;
            }
        }
        nums[i] = key;
    }


    public static void main(String[] args) {
        int[] nums = new int[] { 9, 6, 1, 3, 5};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(nums);
        System.out.println("nums = " + Arrays.toString(nums));
    }
}
