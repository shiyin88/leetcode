/**Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction
(ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
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
        for (int price : prices){
           min = price < min ? price : min;
           profit = (price - min) > profit ? (price - min) : profit;
        }
        return profit;
    }
}
