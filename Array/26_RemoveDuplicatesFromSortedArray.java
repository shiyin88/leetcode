/**
*Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2].

Use Pointer and for loop
    Pointer points to the index that has no duplicate with other elements start from 0
  if A[pointer] != A[i]
      we put the element to the next index of the pointer
   And we return pointer + 1 as the final length
*/
public class Solution {
    public int removeDuplicates(int[] A) {

        if (A.length == 0 || A == null) return 0;

        int pointer = 0;
        for (int i = 1; i < A.length; i++){
            if (A[pointer] != A[i]){
                A[++pointer] = A[i];
            }
        }
        return pointer + 1;
    }
}
