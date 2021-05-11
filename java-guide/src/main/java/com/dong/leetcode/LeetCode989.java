package com.dong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 数组形式的整数加法
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 *
 * 示例 1：
 * 输入：A = [1,2,0,0], K = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 *
 * 示例 2：
 * 输入：A = [2,7,4], K = 181
 * 输出：[4,5,5]
 * 解释：274 + 181 = 455
 *
 * 示例 3：
 * 输入：A = [2,1,5], K = 806
 * 输出：[1,0,2,1]
 * 解释：215 + 806 = 1021
 *
 * 示例 4：
 * 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * 输出：[1,0,0,0,0,0,0,0,0,0,0]
 * 解释：9999999999 + 1 = 10000000000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-to-array-form-of-integer
 * @version 1.0 2021/5/11
 * @author dongliyang
 */
public class LeetCode989 {

    public static void main(String[] args) {
        LeetCode989 code = new LeetCode989();
        System.out.println("code.addToArrayForm(new int[] { 1,2,0,0 }, 34) = " + code.addToArrayForm(new int[]{1, 2, 0, 0}, 34));
        System.out.println("code.addToArrayForm(new int[] { 2, 7, 4 }, 181) = " + code.addToArrayForm(new int[]{2, 7, 4}, 181));
        System.out.println("code.addToArrayForm(new int[]{2, 1, 5}, 806) = " + code.addToArrayForm(new int[]{2, 1, 5}, 806));
        System.out.println("code.addToArrayForm(new int[] { 9,9,9,9,9,9,9,9,9,9 }, 1) = " + code.addToArrayForm(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, 1));
    }

    public List<Integer> addToArrayForm(int[] nums, int k){
        /*
        解题思路：
        1、从数组的后面往前遍历，计算。
        2、如何得到K中当前要参与计算的数字？
        这里用到了一个小的技巧，比如K=12，那么K%10 = 2，得到了个位数2，就是要参与计算的数字。
        K / 10 = 1，得到了十位数1。同时，将K=K/10赋值，这时K=1，参与下一次计算。

        此时K=1，
        K%10=1，得到要参与计算的数字。K=K/10=0。当K=0的时候，说明K的所有位数都计算完毕。

        3、如何保存每一位相加的结果？
        因为是从后往前遍历的，而返回结果是一个List。
        因此，可以使用LinkedList，它既实现了List又实现了双端队列。调用双端队列的方法addFirst，将每一位数字加到列表的开头（时间复杂度O(1)）。
        最后返回LinkedList。

        4、设置一个变量，标识进位。
         */

        //进位
        int carry = 0;
        LinkedList<Integer> result = new LinkedList<>();
        //从后往前遍历数组
        for (int i = nums.length - 1; i >= 0; i--) {
            //计算余数，得到当前参与计算的数字
            int remainder = k % 10;
            //更新k的值
            k = k / 10;

            //计算出来的结果，可能超过了10，因此需要将个位数得到
            int total = nums[i] + remainder + carry;
            int resultNum = total % 10;
            //得到进位，如果total > 10，则carry = 1
            carry = total / 10;
            result.addFirst(resultNum);
        }

        //1、如果K > nums代表的数字，那么经过上面的计算，K就不为0，还剩余。
        //2、还可能存在，nums遍历完了，但是还有进位carry=1
        //因此，需要处理这些特殊情况
        k = k + carry;

        while(k != 0) {
            result.addFirst(k % 10);
            k = k / 10;
        }
        return result;
    }
}
