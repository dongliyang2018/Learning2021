package com.dong.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.IntStream;

/**
 * 爬楼梯
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 *
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * @version 1.0 2021/5/8
 * @author dongliyang
 */
public class LeetCode70 {

    public static void main(String[] args) {
        LeetCode70 code = new LeetCode70();
        System.out.println(code.climbStairs(2) == 2);
        System.out.println(code.climbStairs(3) == 3);
        System.out.println(code.climbStairs(35));
    }

    public int climbStairs(int n) {
        AtomicInteger result = new AtomicInteger(0);
        backtracking(result, n,new AtomicInteger(0));
        return result.get();
    }

    //回溯法，速度有点慢
    private void backtracking(AtomicInteger result,int n,AtomicInteger sum) {
        if(sum.get() > n) {
            return;
        }
        if (sum.get() == n) {
            result.getAndIncrement();
            return;
        }
        for(int i = 1; i <=2; i++){
            sum.getAndAdd(i);
            backtracking(result, n, sum);
            sum.getAndAdd(-i);
        }
    }

//    private void backtracking(List<List<Integer>> result,int n, List<Integer> cur,AtomicInteger sum) {
//        if(sum.get() > n) {
//            return;
//        }
//        if (sum.get() == n) {
//            System.out.println(cur);
//            result.add(new ArrayList<>(cur));
//            return;
//        }
//        for(int i = 1; i <=2; i++){
//            cur.add(i);
//            sum.getAndAdd(i);
//            backtracking(result, n, cur,sum);
//            cur.remove(cur.size() - 1);
//            sum.getAndAdd(-i);
//        }
//    }
}
