/**
 *
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
**/

//Dynamic Programming
public class Solution {

    public int climbStairs(int n){
        int[] result = new int[n + 1];//represents the maximum ways of climbing stairs

        result[0] = 1;
        result[1] = 1;

        for (int i = 2; i <= n; i++){
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n];
    }
}

//recursion
public class Solution{

    public int climbStairs(int n) {
        if (n == 1){
            return 1;
        }

        if (n == 2){ // if there are two stairs, you can either climb 1 or two steps. So there are two ways to climb
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

}
