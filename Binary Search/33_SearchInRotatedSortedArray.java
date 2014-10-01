/**
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Binary Search

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
