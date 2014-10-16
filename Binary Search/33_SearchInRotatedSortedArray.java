/**
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Binary Search

在一个rotated array里面
先要判断mid 和 start 以及 mid 和 end 看是否mid也一并被旋转了
在while loop 里面
if (A[start] >= A[mid]) 证明mid被旋转了 （及时被旋转了，mid到end也是递增序列）
  然后判断target和mid的关系
    1）target是否在[mid, end]中的递增数列
    2）反之 在start和mid中的旋转数列
if(A[start] < A[mid]) 证明mid没有被旋转
    然后判断target和mid的关系
    1）判断target是否在start和mid中的递增数列
    2）或是在mid和end中的旋转数列
跳出while loop后 判断A[start] / A[end] 是否为target 如不是，则返回-1

*/
public class Solution {
    public int search(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        int mid = 0;

        while (start + 1 < end){
            mid = start + (end - start)/2;
            //situation 1
            if (A[start] >= A[mid]){
              //target is in the right bound [mid, end]
                if (A[mid] <= target && target <= A[end]){
                    start = mid;
                }else{//left bound [start, mid]
                    end = mid;
                }
            }else{//situation 2 A[start] < A[mid]
                //target is in the left bound [start, mid]
                if (A[start] <= target && target <= A[mid]){
                    end = mid;
                }else{//right bound [mid, end]
                    start = mid;
                }
            }
       }
        if (A[start] == target) return start;
        if (A[end] == target) return end;
        return -1;
    }
}
