package com.dong.leetcode;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 第三大的数
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 *
 * 示例 1：
 * 输入：[3, 2, 1]
 * 输出：1
 * 解释：第三大的数是 1 。
 *
 * 示例 2：
 * 输入：[1, 2]
 * 输出：2
 * 解释：第三大的数不存在, 所以返回最大的数 2 。
 *
 * 示例 3：
 * 输入：[2, 2, 3, 1]
 * 输出：1
 * 解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
 * 此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/third-maximum-number
 * @version 1.0 2021/5/17
 * @author dongliyang
 */
public class LeetCode414 {

    public static void main(String[] args) {
        LeetCode414 code = new LeetCode414();
        System.out.println("code.thirdMax(new int[] { 3,2,1 }) = " + code.thirdMax(new int[]{3, 2, 1}));
        System.out.println("code.thirdMax(new int[] { 1, 2 }) = " + code.thirdMax(new int[]{1, 2}));
        System.out.println("code.thirdMax(new int[] { 2,2,3,1 }) = " + code.thirdMax(new int[]{2, 2, 3, 1}));
    }

    public int thirdMax(int[] nums) {
        //借助TreeSet实现，TreeSet既有Set去重的功能，又有排序的功能
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for (int num : nums) {
            set.add(num);
        }
        if (set.size() < 3) {
            return set.first();
        } else {
            Iterator<Integer> iterator = set.iterator();
            int count = 0;
            Integer next = null;
            while(count < 3) {
                next = iterator.next();
                count++;
            }
            return next;
        }
    }
}
