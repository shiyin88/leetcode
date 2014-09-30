/**
For a given sorted array (ascending order) and a target number,
find the first index of this number in O(log n) time complexity.
If the target number does not exist in the array, return -1.
Example If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.
*/
/**
*@return the first occurrence position of target
O(log n)
*/
public class Solution{
    public int binarySearch(int[] A, int target) {

        int start = 0;
        int end = A.length - 1;
        int mid = 0;
        //exit时start and end 相邻或是交错
        while (start + 1 < end){//+ 1 avoid infinite loop
              mid = start + (end - start)/2;//write (start + end)/2 may cause overflow
              if (A[mid] == target){
                end = mid; //find first occurrence. so we can keep searching from [start, mid]
                //and get the first occurrence
              }else if (A[mid] < target){
                start = mid;
              }else if (A[mid] > target){
                end = mid;
              }
        }

        if (A[start] == target){
          return start;
        }

        if (A[end] == target){
          return end;
        }
        return -1;
    }
}
