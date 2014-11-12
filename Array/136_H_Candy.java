/**
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

Hide Tags Greedy

 * 用greedy来做
1. 初始化所有小孩糖数目为1，
2. 从前往后扫描，如果第i个小孩等级比第i-1个高，那么i的糖数目等于i-1的糖数目+1；
3. 从后往前扫描，如果第i个的小孩的等级比i+1个小孩高,但是糖的数目却小或者相等，那么i的糖数目等于i+1的糖数目+1。
参考自： http://www.cnblogs.com/TenosDoIt/p/3389479.html**/
该算法时间复杂度为O(N)
public class Solution {
    public int candy(int[] ratings) {
        int[] candynum = new int[ratings.length];
        for (int i = 0; i < candynum.length; i++){
            candynum[i] = 1;
        }
        for (int i = 1; i < candynum.length; i++){
            if ((ratings[i] > ratings[i - 1]) && (candynum[i] <= candynum[i - 1])){
                candynum[i] = candynum[i - 1] + 1;
            }
        }
        for (int i = candynum.length - 2; i >= 0; i--){
            if ((ratings[i] > ratings[i + 1]) && (candynum[i] <= candynum[i + 1])){
                candynum[i] = candynum[i + 1] + 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < candynum.length; i++){
            sum += candynum[i];
        }
        return sum;
    }
}
