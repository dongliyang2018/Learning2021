package com.dong.leetcode;

import java.time.chrono.MinguoDate;

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
public class LeetCode14_04 {

    public static void main(String[] args) {
        LeetCode14_04 code = new LeetCode14_04();
        System.out.println("code.longestCommonPrefix(new String[]{ \"flower\",\"flow\",\"flight\" }) = " +
                code.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));

        System.out.println("code.longestCommonPrefix(new String[]{ \"dog\",\"racecar\",\"car\" }) = " +
                code.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

    //二分查找
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLen = minLen(strs);
        int low = 0;
        int high = minLen;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (isCommonPrefix(strs, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, low);
    }

    private boolean isCommonPrefix(String[] strs, int length) {
        String str0 = strs[0].substring(0, length);
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            String str = strs[i];
            for (int j = 0; j < length; j++) {
                if (str0.charAt(j) != str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    //找到数组中长度最小值
    private int minLen(String[] strs) {
        int min = Integer.MAX_VALUE;
        for (String str : strs) {
            min = Math.min(min, str.length());
        }
        return min;
    }
}
