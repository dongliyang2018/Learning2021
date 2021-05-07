package com.dong;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 一位数组和二维数组相互转换
 * @version 1.0 2021/4/19
 * @author dongliyang
 */
public class ArrayConvert {

    public static void main(String[] args) {
        ArrayConvert code = new ArrayConvert();
        char[][] grid = new char[][] {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        char[] chArr = code.toArr(grid);
        System.out.println("chArr = " + Arrays.toString(chArr));

        char[][] otherGrid = code.toTwoDimensional(chArr, 5);
        System.out.println("otherGrid = " + Arrays.deepToString(otherGrid));

        Object[] obj2 = otherGrid;
    }

    public char[] toArr(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        char[] chArr = new char[row * col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int index = col * i + j;
                chArr[index] = grid[i][j];
            }
        }
        return chArr;
    }

    public char[][] toTwoDimensional(char[] chArr,int col) {
        int row = chArr.length / col;
        char[][] grid = new char[row][col];
        for(int i = 0; i < chArr.length; i++) {
            int x = i / col;
            int y = i % col;
            grid[x][y] = chArr[i];
        }

        return grid;
    }
}
