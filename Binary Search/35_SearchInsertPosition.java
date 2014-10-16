/**
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0

target在数组中有五种情况，当和start和end比较时
    1）< start ： 即在index 0
    2）= start : 即在start
    3) > start: 即在start + 1
    4) = end :  即在end处
    5) > end : 即在end + 1
*/
public class Solution {
    public int searchInsert(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        int mid = 0;

        if (target < A[0]) return 0;

        while (start + 1 < end){
            mid = start + (end - start)/2;
            if (A[mid] == target){
                return mid;
            }else if (A[mid] > target){
                end = mid;
            }else if (A[mid] < target){
                start = mid;
            }
        }//target must be in [start, end and end infinity
        if (A[end] == target) return end;
        if (A[end] < target) return end + 1;//greater than end
        if (A[start] == target) return start;
        return start + 1;//between start and end
    }
}
