/**
Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.

Hide Tags Array Binary Search

这道题和上道题唯一区别为duplicate，多加了两个条件。题目和Search in Rotated Sorted Array相似。
保证num[start] 和num[mid] 不相等。如果相等，让start++
当两者不相等后，如 10, 1, 10, 10, 10 (在start++ 后， start = 1, mid = 10)
由于1, 10, 10, 10 这个是一个升序排列，不满足下面的二分法程序的。
所以我们在whileloop最开始要判断 num[strt] & num[end]的关系。就如在while loop之前判断两者的关系。如果是升序排列
则直接返回start的值。
在while里面判断后，和while外面最初判断的重复，删去最开始的判断，简化程序。
**/
public class Solution {
    public int findMin(int[] num) {
        int start = 0;
        int end = num.length - 1;

       // if (num[start] < num[end]){
         //   return num[start];
        //}

        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (num[start] < num[end]){
                return num[start];
            }
            if (num[start] < num[mid]){
                start = mid;
            }else if (num[start] > num[mid]){
                end = mid;
            }else{
                start++;
            }
        }

        return Math.min(num[start], num[end]);
    }
}
