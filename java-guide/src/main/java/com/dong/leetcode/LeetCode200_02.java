package com.dong.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 示例 1：
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 *
 * 示例 2：
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 * @version 1.0 2021/4/19
 * @author dongliyang
 */
public class LeetCode200_02 {

    public static void main(String[] args) {
        LeetCode200_02 code = new LeetCode200_02();
        char[][] grid = new char[][] {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        int num = code.numIslands(grid);
        System.out.println("num = " + num);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int result = 0;
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j] == '1') {
                    result++;
                    q.offer(new int[]{ i,j });
                    grid[i][j] = '0';
                    while(q.size() > 0) {
                        int[] cur = q.poll();
                        int x = cur[0];
                        int y = cur[1];
                        if(x - 1 >= 0 && grid[x - 1][y] == '1'){
                            grid[x - 1][y] = '0';
                            q.offer(new int[] { x - 1,y});
                        }
                        if(y - 1 >= 0 && grid[x][y - 1] == '1'){
                            grid[x][y - 1] = '0';
                            q.offer(new int[]{x,y -1});
                        }
                        if(x + 1 < row && grid[x + 1][y] == '1'){
                            grid[x + 1][y] = '0';
                            q.offer(new int[]{ x + 1,y });
                        }
                        if(y + 1 < col && grid[x][y + 1] == '1'){
                            grid[x][y + 1] = '0';
                            q.offer(new int[]{x,y + 1});
                        }
                    }
                }
            }
        }

        return result;
    }
}
