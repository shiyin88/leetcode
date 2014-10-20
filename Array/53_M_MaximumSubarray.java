/**
 *
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.
**/

//DYNAMIC PROGRAMMING
public class Solution {
    public int maxSubArray(int[] A) {

        int[] sum = new int[A.length];
        sum[0] = A[0];//the index i in the array represents the maximum value from [0, i]
        int max = sum[0];//initialize the first maximum value at indx i
        for (int i = 1; i < sum.length; i++){
            sum[i] = Math.max(A[i], sum[i - 1] + A[i]);//compare with A[i] with max[0, i -1] + i
            //if add A[i] to sum[i - 1] > A[i] we add A[i] to sum[i - 1] otherwise we discard sum[i - 1] and take A[i] as sum
            max = Math.max(max, sum[i]);
        }
        return max;
    }
}

//ITERATION
/**
此题即判断：
  1）取两个变量，sum 和 max
  2）如果sum + i < 0 即重新加，把sum 赋值 0
  3）max 时刻记录着最大值

public class Solution {
    public int maxSubArray(int[] A) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i : A){
            sum += i; // add i to sum
            max = Math.max(max, sum); //compare sum with max, take the larger one
            if (sum < 0){ // if i + sum < 0; we reassign sum to 0
                sum = 0;
            }
        }
        return max;

    }
}
