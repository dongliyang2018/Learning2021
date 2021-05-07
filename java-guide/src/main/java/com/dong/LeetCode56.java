package com.dong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LeetCode56 {

    public static void main(String[] args) {

        LeetCode56 code = new LeetCode56();
        int[][] intervals = new int[][] { {1,3},{2,6},{8,10},{15,18} };
        int[][] merge = code.merge(intervals);
        System.out.println("merge = " + Arrays.deepToString(merge));
    }

    public int[][] merge(int[][] intervals) {

        if(intervals == null || intervals.length < 2) {
            return intervals;
        }

        //因为不确定合并后有多少个区间，所以使用List
        List<int[]> result = new ArrayList<int[]>();

        //按照二维数组的第一个元素，对数组进行排序。升序，按照第一个元素由小到大
        Arrays.sort(intervals,new Comparator<int[]>() {
            public int compare(int[] a,int[] b) {
                return a[0] - b[0];
            }
        });

        for(int[] interval : intervals) {

            //当是第一个元素，或者当前数组的开区间，比List中最后一个数组的闭区间还大，说明不用合并，直接加入
            if(result.size() == 0 || interval[0] > result.get(result.size() - 1)[1]) {
                result.add(interval);
            } else {
                //当前数组的开区间小于等于List最后一个数组的的闭区间，说明需要合并
                //直接修改List最后一个数组的闭区间，比较两个闭区间谁大
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1],interval[1]);
            }
        }

        return result.toArray(new int[result.size()][2]);

    }
}
