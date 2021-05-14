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
public class LeetCode14 {

    public static void main(String[] args) {
        LeetCode14 code = new LeetCode14();
        System.out.println("code.longestCommonPrefix(new String[]{ \"flower\",\"flow\",\"flight\" }) = " +
                code.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));

        System.out.println("code.longestCommonPrefix(new String[]{ \"dog\",\"racecar\",\"car\" }) = " +
                code.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        //横向扫描
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            result = longestCommonPrefix(strs[i], result);
            if (result.equals("")) {
                break;
            }
        }
        return result;
    }

    private String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while(index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        };
        return str1.substring(0,index);
    }
}
