/**
Given an array of integers, find the subarray with smallest sum.

Return the sum of the subarray.

Note
The subarray should contain at least one integer.

Example
For [1, -1, -2, 1], return -3

http://lintcode.com/en/problem/minimum-subarray/#
**/

public class Solution {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {

        int[] sum = new int[nums.size()];
        sum[0] = nums.get(0);
        int min = sum[0];
        for (int i = 1; i < nums.size(); i++){

            sum[i] = Math.min(nums.get(i), sum[i - 1] + nums.get(i));
            min = Math.min(sum[i], min);
        }
        return min;
    }
}
