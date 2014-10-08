/**
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.


 * if s, m and e are same; can't use binary search as no comparison among three numbers. we have to use recursion from left to right.
 * if s, m and e are different, or at least two are different, we can use binary search.

 * if two of them same, we can use binary search. Answer is in solutionII
    e.x. s and m same meaning from s to m they are equal.
    and the target needs to be found in [m, e]

 * Time Complexity: O(n) in worst senario, all numbers are same except target number, and it is the last to found
 * Can't use binary search in this question because there are cases s, m and e are same

 time complexity of this question is O(n) regardless of binary search is applied or not.

 * */

public class Solution {
    public boolean search(int[] A, int target) {

        for (int i = 0; i < A.length; i++){
            if (A[i] == target){
                return true;
            }
        }
        return false;
    }
    //Sol II:
    //almost same with I. the only difference is from line 38 to line 41.
    //we just avoid three numbers are different
    public int search(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        int mid = 0;

        while (start + 1 < end){
            mid = start + (end - start)/2;
            //this if statement is for dealing with the case when all three elements are same
            if (A[start] == A[mid]
                    && A[mid] == A[end]){
                ++start;
            }
            if (A[start] >= A[mid]){
                if (A[mid] <= target && target <= A[end]){
                    start = mid;
                }else{
                    end = mid;
                }
            }else{
                if (A[start] <= target && target <= A[mid]){
                    end = mid;
                }else{
                    start = mid;
                }
            }
       }
        if (A[start] == target) return start;
        if (A[end] == target) return end;
        return -1;
    }
}
