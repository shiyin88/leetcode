/**Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example,
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Hide Tags Array Stack Two Pointers

这道题用两个数组维护i的左边和右边最大的值。
i的储水量是由i两边较小的高来决定的。

leftmost数组：从0到n-1扫，leftmost[i]由A[0..i - 1]中最大值决定。
rightmost数组：从 n - 1到0扫，rightmost[i]由A[i + 1...n - 1]中最大值决定
其当前i的储水量由它的左右最小的容量Math.min(leftmost[i], rightmost[i]) - 自身的高度A[i]决定

题目：给一个凹凸不平的积木组合，问能盛住的水的体积为多少？
思路：每一点能接住的水量取决于它左边的最高高度，和右边的最高高度中相对低的那个。
water[i] = min(leftHighest[i], rightHighest[i]) - A[i];
如果左右两边的最高高度都比它低，water[i] < 0，说明没法接住水。
leftHighest[]和rightHighest[]可以通过两遍扫描，用O(n)的时间求出来。

http://obcerver.com/post/view/p/21
 * */
public class Solution {
    public int trap(int[] A) {
        if (A == null || A.length == 0){
            return 0;
        }
        int[] leftMost = new int[A.length];
        int[] rightMost = new int[A.length];

        int max = A[0];
        leftMost[0] = A[0];
        for (int i = 1; i < A.length; i++){
            leftMost[i] = max;//the leftmost取决于它左面 i - 1的最高度，是否能使在i的时候储住水
            if (A[i] > max){
                max = A[i];
            }
        }

        max = A[A.length - 1];
        rightMost[A.length - 1] = max;
        for (int i = A.length - 2; i >= 0; i--){
            rightMost[i] = max;//the rightmost取决于它右面 i + 1的最高度，是否能使在i的时候储住水
            if (A[i] > max){
                max = A[i];
            }
        }

        int result = 0;
        for (int i = 0; i < A.length; i++){
            int cur_trap = Math.min(rightMost[i], leftMost[i]) - A[i];
            if (cur_trap > 0){
                result += cur_trap;
            }
        }
        return result;
    }
}
