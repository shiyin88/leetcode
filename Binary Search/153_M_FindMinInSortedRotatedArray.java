/**
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.

用二分法。前提： 数组是rotated
判断start 和 mid在数组的值
从而判断取舍
跳出while loop后，返回start， end在数组中最小值
**/
public class Solution {
    public int findMin(int[] num) {
         int start = 0;
         int end = num.length - 1;

         //for not rotated array
         if (num[start] < num[end]) return num[start];

         //rotated array
         while (start + 1 < end){
             int mid = start + (end - start) / 2;
             if (num[start] <= num[mid]){
                 start = mid;
             }else{
                 end = mid;
             }
         }

         return Math.min(num[start], num[end]);
    }
}
