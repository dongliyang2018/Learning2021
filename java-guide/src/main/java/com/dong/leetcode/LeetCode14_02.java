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
public class LeetCode14_02 {

    public static void main(String[] args) {
        LeetCode14_02 code = new LeetCode14_02();
        System.out.println("code.longestCommonPrefix(new String[]{ \"flower\",\"flow\",\"flight\" }) = " +
                code.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));

        System.out.println("code.longestCommonPrefix(new String[]{ \"dog\",\"racecar\",\"car\" }) = " +
                code.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        //竖向扫描
        int columnCount = strs[0].length();
        int rowCount = strs.length;

        for (int i = 0; i < columnCount; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < rowCount; j++) {
                if (strs[j].length() == i || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
