/**
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
**/

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int col = obstacleGrid[0].length;
        int row = obstacleGrid.length;
        int[][] result = new int[row][col];

        //initialization
        for (int i = 0; i < row; i++){
            if (obstacleGrid[i][0] != 1){
                result[i][0] = 1;
            }else{
                //index after obstacles are all set to 0
                //As no path through obstacles
                break;
            }
        }

        for (int i = 0; i < col; i++){
            if(obstacleGrid[0][i] != 1){
                result[0][i] = 1;
            }else{
                break;
            }
        }

        for (int i = 1; i < row; i++){
            for (int k = 1; k < col; k++){
                if (obstacleGrid[i][k] != 1){
                    result[i][k] = result[i - 1][k] + result[i][k - 1];
                }else{
                    result[i][k] = 0;
                }
            }
        }

        return result[row - 1][col - 1];

    }
}
