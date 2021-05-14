package com.dong.leetcode;

/**
 * 最长公共前缀
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 *
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * @version 1.0 2021/5/14
 * @author dongliyang
 */
public class LeetCode14_03 {

    public static void main(String[] args) {
        LeetCode14_03 code = new LeetCode14_03();
        System.out.println("code.longestCommonPrefix(new String[]{ \"flower\",\"flow\",\"flight\" }) = " +
                code.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));

        System.out.println("code.longestCommonPrefix(new String[]{ \"dog\",\"racecar\",\"car\" }) = " +
                code.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

    //分治
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int start, int end) {
        //递归退出条件，最小的求解单位
        if (start == end) {
            //start等于end，自身是它自己的最长公共前缀
            return strs[start];
        }
        //开始分治
        int mid = start + (end - start) / 2;
        String leftLongest = longestCommonPrefix(strs, 0, mid);
        String rightLongest = longestCommonPrefix(strs, mid + 1, end);
        //求出左边一部分的最长公共前缀，右边一部分的最长公共前缀，结果是这两部分的最长公共前缀
        return commonPrefix(leftLongest, rightLongest);

    }

    private String commonPrefix(String str1, String str2) {
        int minLen = Math.min(str1.length(), str2.length());
//        for (int i = 0; i < minLen; i++) {
//            if (str1.charAt(i) != str2.charAt(i)) {
//                return str1.substring(0, i);
//            }
//        }
//        return str1.substring(0, minLen);

        //另外一种写法
        int i = 0;
        while(i < minLen && str1.charAt(i) == str2.charAt(i)) {
            i++;
        }
        return str2.substring(0, i);
    }
}
