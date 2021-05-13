package com.dong.leetcode;

import java.util.Arrays;

/**
 * 每日温度
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * @version 1.0 2021/5/12
 * @author dongliyang
 */
public class LeetCode739 {

    public static void main(String[] args) {
        LeetCode739 code = new LeetCode739();
        int[] result = code.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println("result = " + Arrays.toString(result));
    }

    //暴力法
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            for(int j = i + 1; j < temperatures.length; j++) {
                if(temperatures[j] > temperatures[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }
}
