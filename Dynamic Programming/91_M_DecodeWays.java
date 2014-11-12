/**A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.

Hide Tags Dynamic Programming String

 * 1. two for loops : time Complexity : O(n square)
 *     outer loop : count from i = 0 to s.length - 1;
 *     inner loop: count the combination of number at index [i] and index [i - 1]. If that can form a two digits number
 * 2. one loop : time complexity : O(n)
 *    1) initialization : result[0], result[1]
 *    2) result[i] 代表0 - i个digit中的解法
 *    3) 算每个single digit有多少个case
 *      if 当前i在string中即i - 1的char不为0， 则result[i] = result[i - 1]
 *          如果为0，则当把每个char代表一个个digit表示的时候，不可以。ex 101 表示为[1,0,1]这种分解不可以。
 *    4)计算当前i和它的前一位是否组成的数是一个在[10, 26]的数。
 *      如果是的话，则result[i] += result[i - 2] 即i 和 i - 1组成的数为result[i - 2]的解法加上result[i]的解法
 **/
public class Solution {
    public int numDecodings(String s) {
        if (s.length() < 1 || s == null){
            return 0;
        }
        int[] result = new int[s.length() + 1];
        result[0] = 1;
        result[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= s.length(); i++){
            //single digit
            if (s.charAt(i - 1) != '0'){
                result[i] = result[i - 1];
            }

            int digit = Integer.parseInt(s.substring(i - 2, i));
            if (digit >= 10 && digit <= 26){
                result[i] += result[i - 2];
            }
        }
        return result[s.length()];
    }
}
