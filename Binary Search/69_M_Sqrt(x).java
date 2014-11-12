/**
Implement int sqrt(int x).

Compute and return the square root of x.

Hide Tags Math Binary Search

 * 这道题用二分法做。
 * 把end设作 x
 * start为0
 * mid为两树中间。
 * 通过二分法和midsquare比较取得最后的结果**/
public class Solution {
    public int sqrt(int x) {
        long start = 0;
        long end = x;

        while (start + 1 < end){
            long mid = start + (end - start) / 2;
            long mid_square = mid * mid;
            if ((long)x == mid_square){
                return (int)mid;
            }else if ((long)x < mid_square){
                end = mid;
            }else{
                start = mid;
            }
        }

        if ((long)x == start * start){
            return (int)start;
        }else if ((long)x == end * end){
            return (int)end;
        }
        return (int)start;
    }
}
