package com.dong.sort;

/**
 * 排序接口
 * @version 1.0 2021/04/20
 * @author dongliyang
 */
public interface ISort {

    /**
     * 排序方法
     * @param nums
     */
    public void sort(int[] nums);

    /**
     * 交换元素
     * @param nums
     * @param i
     * @param j
     */
    public default void swap(int[] nums,int i,int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
