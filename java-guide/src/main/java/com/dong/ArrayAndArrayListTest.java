package com.dong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 数组和ArrayList测试
 * @version 1.0 2021/4/22
 * @author dongliyang
 */
public class ArrayAndArrayListTest {

    public static void main(String[] args) {
//        testArray();
        testArrayList();
    }

    public static void testArray() {
        int[] nums = { 1,5,2,7,9,8,3 };
        //访问Access
        System.out.println(nums[2]);

        //遍历
        for (int num : nums) {
            System.out.println(num);
        }

        //查找Search
        int target = 7;
        for (int num : nums) {
            if (num == target) {
                System.out.println("Found:" + target);
                break;
            }
        }

        //修改
        nums[2] = 10;
        System.out.println(Arrays.toString(nums));

        //排序，升序
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        //排序，降序
        //带Comparator的重载方法，第一个参数需要引用类型，因此对于基本类型，需要转换成包装类型
        Integer[] arr = new Integer[nums.length];
        for (int i = 0, len = nums.length; i < len; i++) {
            arr[i] = nums[i];
        }
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println(Arrays.toString(arr));
    }

    public static void testArrayList() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,5,2,7,9,8,3));

        //在末尾添加
        list.add(10);
        System.out.println(list.toString());

        //在某个位置添加
        list.add(1, 4);
        System.out.println(list.toString());

        //删除某个元素
        Object target = 4;
        list.remove(target);
        System.out.println(list.toString());

        //删除某个索引的元素
        int delIdx = 4;
        list.remove(delIdx);
        System.out.println(list.toString());

        //获取某个元素
        System.out.println(list.get(2));

        //修改某个元素
        list.set(2, 9);
        System.out.println(list.toString());

        //查找某个元素是否存在
        System.out.println(list.contains(9));

        //排序，升序
        Collections.sort(list);
        System.out.println(list.toString());

        //排序，降序
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list.toString());
    }
}
