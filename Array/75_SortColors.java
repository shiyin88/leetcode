/**
 *
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

Time Complexity : O(n)
Space Complexity: O(1)

cur从0到j扫描，
遇到0，放在i位置，i后移；
遇到2，放在j位置，j前移；
遇到1，cur后移。
扫描一遍得到排好序的数组。

**/

public class Solution {
     public static void sortColors(int[] A) {
	        int red = 0;
	        int blue = A.length - 1;
	        int i = 0;
	        while (i <= blue){//i should iterate every index including the last index
	            if (A[i] == 0){
	                swap(A, i, red);
	                red++;
	                i++;
	            }else if (A[i] == 2){//if A[i] is blue, we swap them but don't increase i cause the exchanged value maybe 0
	                swap(A, i, blue);
	                blue--;
	            }else{
	            	i++;
	            }
	        }
	}

    public static void swap(int[] A, int k, int j){
        int temp = A[k];
        A[k] = A[j];
        A[j] = temp;
    }
}
