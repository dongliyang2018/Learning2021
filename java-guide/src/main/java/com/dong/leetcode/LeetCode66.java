package com.dong.leetcode;

import java.util.Arrays;

/**
 * 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。

 * 示例 1：
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 *
 * 示例 2：
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 *
 * 示例 3：
 * 输入：digits = [0]
 * 输出：[1]
 *  
 * 提示：
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * @version 1.0 2021/4/23
 * @author dongliyang
 */
public class LeetCode66 {

    public static void main(String[] args) {
        LeetCode66 code = new LeetCode66();
        System.out.println(Arrays.toString(code.plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(code.plusOne(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(code.plusOne(new int[]{0})));
        System.out.println(Arrays.toString(code.plusOne(new int[]{9})));
    }

    public int[] plusOne(int[] digits) {
        //复制一份
        int[] result = new int[digits.length + 1];
        System.arraycopy(digits, 0, result, 1, digits.length);
        result[result.length - 1] = result[result.length - 1] + 1;
        for (int i = result.length - 1; i > 0; i--) {
            int cur = result[i];
            if (cur >= 10) {
                result[i] = (10 - result[i]);
                result[i - 1] = result[i - 1] + 1;
            }
        }
        return result[0] != 0 ? result : Arrays.copyOfRange(result, 1, result.length);
    }
}
