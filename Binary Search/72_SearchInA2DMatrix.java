/**
Binary Search

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.*/
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0;
        int end = row * col - 1;
        int mid = 0;
        while (start <= end){
            mid = start + (end - start)/2;
            int digit = matrix[mid/col][mid%col];
            if (target == digit){
                return true;
            }else if (target < digit){
                end = mid - 1;
            }else if (target > digit){
                start = mid + 1;//plus 1 or minus one to avoid ifinite loop as the condition for the while loop is (start<=end)
            }
        }
        return false;
    }
}
