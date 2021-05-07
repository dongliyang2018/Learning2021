package com.dong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LeetCode57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] newIntervals = getNewIntervals(intervals,newInterval);

        List<int[]> result = new ArrayList<>();

        for(int[] interval : newIntervals) {
            if(result.size() == 0 || interval[0] > result.get(result.size() - 1)[1]) {
                result.add(interval);
            } else {
                result.get(result.size() - 1)[1] = Math.max(interval[1],result.get(result.size() - 1)[1]);
            }
        }

        return result.toArray(new int[result.size()][2]);
    }

    private int[][] getNewIntervals(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        for(int[] interval : intervals) {
            list.add(interval);
        }
        list.add(newInterval);
        list.sort((a,b) -> a[0] - b[0]);

        return list.toArray(new int[list.size()][2]);
    }
}
