/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

Follow up:
Could you do it without any loop/recursion in O(1) runtime?

Hint:

A naive implementation of the above process is trivial. Could you come up with other methods? Show More Hint 

这道题让我们求数根，所谓树根，就是将大于10的数的各个位上的数字相加，若结果还大于0的话，则继续相加，直到数字小于10为止。
**/
public class Solution {
    public int addDigits(int num) {
        if (num == 0) return 0;
        
        while (num > 9) {
            int left = num / 10;
            int right = num % 10;
            num = left + right;
        }
        return num;
    }
}
