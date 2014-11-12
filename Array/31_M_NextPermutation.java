/**
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
Hide Tags Array

 * 大体思路：
 * 1. 从后往前，找到第一个 A[i-1] < A[i]的。并且记录两者的index
 *    保持i - 1的index是为了和i - n中的一个index替换
 * 2. 从index2，即i到n - 1中找到一个number(此数字大于num[i - 1]，但是是i到n-1中大于num[i-1]中的最小值)
 *    保留此点为index2
 * 3. swap index1 和index2的value
 * 4. sort range from [index1 + 1, length - 1] in ascending order
 *
 reference by http://blog.csdn.net/m6830098/article/details/17291259
 **/
public class Solution {
    public static void nextPermutation(int[] num) {
        if (num == null || num.length < 2){
            return;
        }
        int i = 0;
        int index1 = 0;
        int index2 = 0;
        for (i = num.length - 1; i > 0; i--){
            if (num[i - 1] < num[i]){
            	index1 = i - 1;
                index2 = i;
                break;
            }
        }

        for (int a = i; a < num.length; a++){
            if ((num[a] > num[index1]) && (num[a] < num[index2])){
                index2 = a;
            }
        }
        //if we didn't find a number i - 1 that num[i - 1] < num[i]
        //1. e.x 111 or 511 then we have to rearrange the array to the lowest
        if (index1 == 0 && index2 == 0){
	        	Arrays.sort(num);
        }else{
        //2. rearranges numbers into the lexicographically next greater permutation of numbers.
        	int temp = num[index1];//at index i - 1
	        num[index1] = num[index2];
	        num[index2] = temp;
	        /**sort(int[] a, int fromIndex, int toIndex)
	         * fromIndex : inclusive
	         * toIndex : exclusive**/
	        Arrays.sort(num, index1 + 1, num.length);
        }
    }
}
