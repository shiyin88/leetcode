/**
 *
Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most two transactions.
Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

O(n^2)的算法很容易想到：
找寻一个点j，将原来的price[0..n-1]分割为price[0..j]和price[j..n-1]，分别求两段的最大profit。
进行优化：
对于点j+1，求price[0..j+1]的最大profit时，很多工作是重复的，在求price[0..j]的最大profit中已经做过了。
类似于Best Time to Buy and Sell Stock，可以在O(1)的时间从price[0..j]推出price[0..j+1]的最大profit。
但是如何从price[j..n-1]推出price[j+1..n-1]？反过来思考，我们可以用O(1)的时间由price[j+1..n-1]推出price[j..n-1]。
最终算法：
数组l[i]记录了price[0..i]的最大profit，
数组r[i]记录了price[i..n]的最大profit。
已知l[i]，求l[i+1]是简单的，同样已知r[i]，求r[i-1]也很容易。
最后，我们再用O(n)的时间找出最大的l[i]+r[i]，即为题目所求。
http://blog.csdn.net/fightforyourdream/article/details/14503469
O(n) Dynamic Programming
**/
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1){
            return 0;
        }
        //分别求0-i 和 i-n两个区间内最大的profit
        int[] left = new int[prices.length];//i represents 当值在i时已知最大的profit
        int[] right = new int[prices.length];

        left[0] = 0;//initialize the max profit for the first digit
        int min = prices[0];
        for(int i = 1; i < left.length - 1; i++){
            min = Math.min(min, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - min);//compare max profit from [0, i-1] and current profit
        }

        right[right.length - 1] = 0;//initialize the max profit for the first digit
        int max = prices[right.length - 1];
        for (int i = right.length - 2; i >= 0; i--){
            max = Math.max(max, prices[i]);
            right[i] = Math.max(right[i + 1], max - prices[i]);
        }

        int profit = 0;
        for (int i = 0; i < prices.length; i++){
            profit = Math.max(profit, left[i] + right[i]);
        }
        return profit;
    }
}
