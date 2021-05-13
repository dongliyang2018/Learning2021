package com.dong.leetcode;

import java.util.Arrays;
import java.util.Stack;

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
public class LeetCode739_02 {

    public static void main(String[] args) {
        LeetCode739_02 code = new LeetCode739_02();
        int[] result = code.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println("result = " + Arrays.toString(result));
    }

    //单调栈
    public int[] dailyTemperatures(int[] temperatures) {

        /**
         * 解题方法：
         * 可以维护一个存储下标的单调栈，从栈底到栈顶的下标对应的温度列表中温度依次递减。
         * 如果一个下标在单调栈里，则表示尚未找到下一次温度更高的下标。
         *
         * 1.正向遍历温度列表。对于温度列表中的每个元素T[i],如果栈为空，则直接将i入栈。
         * 2.如果栈不为空，则比较栈顶元素prevIndex对应的问题T[prevIndex]和当前温度T[i]。
         * 如果T[i] > T[prevIndex]，则将prevIndex移除，并将prevIndex对应的等待天数赋为i-prevIndex。
         * 重复上述操作直到栈为空或者栈顶元素对应的温度小于等于当前温度，然后将i进栈。
         *
         * 为什么可以在弹栈的时候更新ans[prevIndex]呢？ 因为在这种情况下，即将进栈的i对应的
         * T[i]一定是T[prevIndex]右边第一个比它大的元素，试想如果prevIndex和i有比它的元素，
         * 将设下标为j，那么prevIndex一定会在下标j的那一轮被弹掉。
         *
         * 由于单调栈满足从栈底到栈顶元素对应的温度递减，因此每次有元素进栈时，会将温度更低的元素全部移除，
         * 并更新栈元素对应的天数，这样可以确保等待天数一定是最小的。
         */
        //stack中存放元素的索引
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int i = 0, len = temperatures.length; i < len; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.empty() && temperatures[i] > temperatures[stack.peek()]) {
                    Integer prevIndex = stack.pop();
                    result[prevIndex] = i - prevIndex;
                }
                stack.push(i);
            }
        }
        return result;
    }
}
