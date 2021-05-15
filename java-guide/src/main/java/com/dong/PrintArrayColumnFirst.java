package com.dong;

/**
 * 打印数组，竖向打印
 * @version 1.0 2021/5/15
 * @author dongliyang
 */
public class PrintArrayColumnFirst {

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                { 1,2,3,4,5 },
                { 6,7,8,9,10},
                { 11,12,13,14,15},
                { 16,17,18,19,20}
        };

        int colCount = grid[0].length;
        int rowCount = grid.length;

        for (int col = 0; col < colCount; col++) {
            for (int row = 0; row < rowCount; row++) {
                int num = grid[row][col];
                System.out.print(num + " ");

            }
        }
    }

}
