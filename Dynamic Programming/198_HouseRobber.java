
/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Credits:
Special thanks to @ifanchu for adding this problem and creating all test cases. Also thanks to @ts for adding additional test cases.

Show Tags
Show Similar Problems

 * 这道题的本质相当于在一列数组中取出一个或多个不相邻数，使其和最大。那么我们对于这类求极值的问题首先考虑动态规划Dynamic Programming来解，我们维护一个一位数组dp，其中dp[i]表示到i位置时不相邻数能形成的最大和，经过分析，我们可以得到递推公式dp[i] = max(num[i] + dp[i - 2], dp[i - 1]), 由此看出我们需要初始化dp[0]和dp[1]，其中dp[0]即为num[0]，dp[1]此时应该为max(num[0], num[1])，代码如下：
 * **
 */
 public class Solution {
    public int rob(int[] nums) {
        //if (nums == null || nums.length == 0) return 0;
        if (nums.length <= 1) return nums.length == 0 ? 0 : nums[0];
        
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];//match the first index[0] with dp[1]
        //nums[i - 1] represents current the ith position number in the array
        for (int i = 2; i < nums.length + 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[nums.length];
    }
}
