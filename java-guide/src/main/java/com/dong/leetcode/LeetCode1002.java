package com.dong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 查找常用字符
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 *
 * 示例 2：
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *  
 * 提示：
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-common-characters
 * @version 1.0 2021/5/18
 * @author dongliyang
 */
public class LeetCode1002 {

    public static void main(String[] args) {
        LeetCode1002 code = new LeetCode1002();
        System.out.println("code.commonChars(new String[]{ \"bella\",\"label\",\"roller\" }) = " + code.commonChars(new String[]{"bella", "label", "roller"}));
    }

    public List<String> commonChars(String[] words) {
        //存储26个小写英文字母出现的最小次数
        int[] minFrequency = new int[26];
        //由于要求最小次数，因此先填充最大值，作为一个无效值的标记
        Arrays.fill(minFrequency, Integer.MAX_VALUE);

        for (String word : words) {
            //求出每个单词中，26个英文字母出现的次数
            int[] freq = new int[26];
            for (char ch : word.toCharArray()) {
                freq[ch - 'a']++;
            }

            for (int i = 0; i < freq.length; i++) {
                //如果某个字母始终没有出现过，那么minFrequency中就会为0。如果出现过，就存储出现的最小次数
                minFrequency[i] = Math.min(freq[i],minFrequency[i]);
            }
        }

        List<String> result = new ArrayList<>();
        //minFrequency中，存储的就是每个单词中，字母出现的最小次数。找到不为0的，然后重复minFrequence[i]次
        for (int i = 0; i < minFrequency.length; i++) {
            if (minFrequency[i] != 0) {
                for (int j = 0; j < minFrequency[i]; j++) {
                    result.add(String.valueOf((char)('a' + i)));
                }
            }
        }
        return result;
    }
}
