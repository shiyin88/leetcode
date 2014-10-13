/**
 *
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Dynamic Programming:
用矩阵来做
state： f[x][y] 从起点走到x，y的最短路径
function:
        x >= 1 && y >=1
            f[x][y] = Math.min(f[x - 1][y], f[x][y - 1]) + cost[x][y];
Initialization:
        f[0][0] = cost[0][0];
        f[i][0] = f[i - 1][0] + cost[i][0];
        f[0][i] = f[0][i - 1] + grid[0][i]
Answer: f[row - 1][col - 1]**/

public class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] sum = new int[row][col];

        //initialization
        /**
         * sum[0][0] = grid[0][0];
         * sum[i][0] = sum[i - 1][0] + grid[i][0]
         * sum[0][i] = sum[0][i - 1] + grid[0][i]**/
        sum[0][0] = grid[0][0];
        for (int i = 1; i < row; i++){
            sum[i][0] = sum[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < col; i++){
            sum[0][i] = sum[0][i - 1] + grid[0][i];
        }

        /**
         * function:
         *          maximum path = index相邻的左边格和上边格的最小值加上当前index的值
         *          即： sum[i][k] = Math.min(sum[i - 1][k], sum[i][k - 1]) + grid[i][k];**/

         for (int i = 1; i < row; i++){
             for (int k = 1; k < col; k++){
                 sum[i][k] = Math.min(sum[i - 1][k], sum[i][k - 1]) + grid[i][k];
             }
         }

        return sum[row - 1][col - 1];


    }
}
