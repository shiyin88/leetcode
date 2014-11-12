/**
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?

每个旋转的点，顺时针看，必有一个row/col 和上一个col/row相等， 另一个点是 n - 1 - j/i
**/
public class Solution {
    public void rotate(int[][] matrix) {

        int n = matrix.length;
        for (int i = 0; i < n / 2; i++){
            for (int j = 0; j < Math.ceil((double)n / 2.); j++){
                int temp = matrix[i][j];
                //left --> top
                matrix[i][j] = matrix[n - 1 - j][i];
                // bottom -> left
                matrix[n - 1- j][i] = matrix[n - 1 - i][n - 1 - j];
                // right -> bottom
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                // top -> right
                matrix[j][n - 1 - i] = temp;
            }
        }

    }
}
