package com.dong.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode22 {

    public static void main(String[] args) {
        LeetCode22 code = new LeetCode22();
        List<String> result = code.generateParenthesis(3);
        System.out.println(result);
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtracking(n,result,0,0,"");
        return result;
    }

    //回溯法
    private void backtracking(int n,List<String> result,int left,int right,String str) {
        //递归退出条件
        if(right > left){
            return;
        }
        //递归退出条件，字符串符合条件，加入到List
        if(left == right && left == n){
            result.add(str);
            return;
        }

        //添加左括号
        if(left < n){
            backtracking(n,result,left + 1,right,str + "(");
        }
        //添加右括号
        if(right < left){
            backtracking(n,result,left,right + 1,str + ")");
        }
    }
}
