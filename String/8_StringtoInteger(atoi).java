/**
*Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases.
If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

1. only keeps '-' sign at index 0;
2. memory overflow
3. break if i is not number
*/
public class Solution {
    public int atoi(String str) {
        long value = 0;
        boolean isNegative = false;
        str = str.trim();

        for (int i = 0; i < str.length(); i++){
            if (i == 0 && (str.charAt(i) == '+' || str.charAt(i) == '-')){
                if (str.charAt(i) == '-'){
                isNegative = true;
                }
                continue;
            }

            if (str.charAt(i) <'0' || str.charAt(i) > '9') break;
            value = 10 * value + str.charAt(i) - '0';
        }

        if (isNegative) {
            value = value * (-1);
        }
        if (value > 2147483647) return 2147483647;
        if (value < -2147483648) return -2147483648;
        return (int)value;
    }
}
