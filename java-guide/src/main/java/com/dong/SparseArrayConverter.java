package com.dong;

import java.util.Arrays;

public class SparseArrayConverter {

    public static void main(String[] args) {

        SparseArrayConverter converter = new SparseArrayConverter();

        int[][] twoDimension = new int[][]{
                {0,0,0,0,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0,0},
                {0,0,0,2,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0},
        };
        int[][] sparseArray = converter.twoDimensionToSparseArray(twoDimension);
        System.out.println("sparseArray = " + Arrays.deepToString(sparseArray));

        int[][] twoDim = converter.sparseArraytoTwoDimension(sparseArray);
        System.out.println("twoDim = " + Arrays.deepToString(twoDim));
    }

    public int[][] twoDimensionToSparseArray(int[][] twoDimension) {
        int valCount = 0;
        for(int i = 0; i < twoDimension.length; i++) {
            for(int j = 0; j < twoDimension[i].length; j++) {
                if(twoDimension[i][j] != 0) {
                    valCount++;
                }
            }
        }

        int[][] sparseArray = new int[valCount + 1][3];
        sparseArray[0][0] = twoDimension.length;
        sparseArray[0][1] = twoDimension[0].length;
        sparseArray[0][2] = valCount;

        int row = 1;
        for(int i = 0; i < twoDimension.length; i++) {
            for(int j = 0; j < twoDimension[i].length; j++) {
                if(twoDimension[i][j] != 0) {
                    sparseArray[row][0] = i;
                    sparseArray[row][1] = j;
                    sparseArray[row][2] = twoDimension[i][j];
                    row++;
                }
            }
        }
        return sparseArray;
    }

    public int[][] sparseArraytoTwoDimension(int[][] sparseArray) {
        int[][] twoDimension = new int[sparseArray[0][0]][sparseArray[0][1]];

        for(int i = 1; i < sparseArray.length; i++){
            twoDimension[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        return twoDimension;
    }
}
