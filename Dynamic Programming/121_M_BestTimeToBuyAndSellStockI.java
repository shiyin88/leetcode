/**Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction
(ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
这里，在所以的transaction中，只能交易一次（买和卖）
即，要在所以值中找寻minBuy and maxSell;

有两个变量我们应该keep track of
1) 买入价
2）profit
当买入价为最小，以及profit最大的时候，就是我们应该买入卖出的时候。
所以在for loop中，我们应该通过寻找最小值找到最小买入价，
以及通过寻找最大profit找到maximum profit
**/

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null){
            return 0;
        }

        int min = Integer.MAX_VALUE;//initialize it with the MAX_VALUE
        //need to notice that the sell day must be latter than the buy day
        //keep track of CURRENT minimum buying price and maximum profit
        int profit = 0;

        for (int i : prices){
            min = Math.min(min, i);
            profit = Math.max(i - min, profit);
        }
        return profit;
    }
}
