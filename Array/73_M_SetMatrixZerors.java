/**
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

Show Tags
**/

//solution 1 : constant space
public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstCol = false;
        boolean firstRow = false;
        //check if the first row contains zero
        for (int i = 0; i < matrix.length; i++){
            if (matrix[i][0] == 0){
                firstCol = true;
                break;
            }
        }
        //check if the first column contains zero
        for (int i = 0; i < matrix[0].length; i++){
            if (matrix[0][i] == 0){
                firstRow = true;
                break;
            }
        }
        //start from i = 1 and j = 1, find if any row or col have 0. if has, mark the col & row position in the zero col & row
        for (int i = 1; i < matrix.length; i++){
            for (int j = 1; j < matrix[0].length; j++){
                if (matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        //since we already marked the col/rows with 0 at index = 0 position. now from i= 1, and j = 1, we just need to retrieve
        //0 in the top row/col and mark the rest to zero
        for (int i = 1; i < matrix.length; i++){
            for (int j = 1; j < matrix[0].length; j++){
                if (matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        //if first row contains zero, then mark the entire row zero
        if (firstRow){
            for (int i = 0; i < matrix[0].length; i++){
                matrix[0][i] = 0;
            }
        }
        if (firstCol){
            for (int i = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
/**solution 2 : space(m + n)
 * create two boolean arrays : row and col
 * if a matrix == 0; we its row and col in the boolean array to 0
 * for loop : if given row or col is zero, then we set the matrix to zero
 * 给定两个boolean分别表示row和col
 首先遍历matrix的每个cell， 如果cell = 0，则标注cell所在的row和col 为0
 然后再次遍历，如果matrix[i][k]的cell的i在row 以及k在col的boolean为true，则表示
 这行以及这列为0，则把matrix[i][k]设为0
 **/
public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++){
            for (int k = 0; k < matrix[0].length; k++){
                if (matrix[i][k] == 0){
                    row[i] = true;
                    col[k] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++){
            for (int k = 0; k < matrix[0].length; k++){
                if (row[i] || col[k]){
                    matrix[i][k] = 0;
                }
            }
        }
    }
}
