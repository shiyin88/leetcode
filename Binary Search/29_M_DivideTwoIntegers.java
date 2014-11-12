/*
Divide two integers without using multiplication, division and mod operator.

Hide Tags Math Binary Search


这道题通过做位运算来做除法运算。
通过b << shift，即 b * 2 * shift来获得商
在第二个while loop里面求得shift
从而加在answer里面，
而后，a = a - (b << (shift - 1));求得余数，
如果余数 >= b 继续位运算来求得商**/
public class Solution {
    public int divide(int dividend, int divisor) {
        boolean isNegative = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int ans = 0;

        while (a >= b){
            int shift = 0;
            while ((b << shift) <= a){
                shift++;
            }
            ans += 1 << (shift - 1);
            a = a - (b << (shift - 1));
        }
        return isNegative ? -ans : ans;
    }
}
