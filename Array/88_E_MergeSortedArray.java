/**
Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note:
You may assume that A has enough space (size that is greater or equal to m + n)
to hold additional elements from B. The number of elements initialized in A and
B are m and n respectively.

Idea:
In the array A, index 0 to m - 1 positions are occupied.
Instead of merge elements forward, we put put b elements backward to A.
from A(m + 1) to 0

Template: Merge Two Array Into One Sorted Array
*/

public class Solution {
    public void merge(int A[], int m, int B[], int n) {

          int index = m + n;

          while (m > 0 && n > 0){
              //如果m和n的last index比较 把大的数放到A的index上
              if (A[m - 1] >= B[n - 1]){

                  A[--index] = A[--m];

              }else{

                  A[--index] = B[--n];
              }
          }
          //如果n的数没有遍历完，继续遍历
          while (n > 0){

              A[--index] = B[--n];
          }
    }
}
