/**
 * Implement pow(x, n).

Hide Tags Math Binary Search

接下来我们介绍二分法的解法，如同我们在Sqrt(x)的方法。
不过这道题用递归来解比较容易理解，
把x的n次方划分成两个x的n/2次方相乘，然后递归求解子问题，
结束条件是n为0返回1。因为是对n进行二分，
算法复杂度和上面方法一样，也是O(logn)。
reference : http://blog.csdn.net/linhuanmars/article/details/20092829**/
public class Solution {
    public double pow(double x, int n) {
         if (n == 0){
             return 1;
         }

         double half = pow(x, n / 2);
         //当n为偶数的时候，当n无论是positive还是negative，都只要和自身相乘就行了
         //如果n为负数，ex. x = 2, n = -2, (1 /2) * (1 / 2)
         if (n % 2 == 0){

             return half * half;

         }else if (n > 0){
             //但是当n 为奇数的时候，> 0的时候，我们需要和x相乘
             return half * half * x;

         }else { //表达的为 else if (n < 0)
             //同理，n为奇数的时候，n < 0 我们需要和 1/x 相乘
             return half * half * (1 / x);
         }

    }
}
