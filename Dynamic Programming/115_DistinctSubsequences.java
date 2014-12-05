/**Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.

Hide Tags Dynamic Programming String
S为长度大的数，T为长度小的数
把S设为col， T设为row， 即S在top，T在left side
如果T为空，T也属于S，则table[0][i] = 1即当T为0时，和Smatch都为1
但是如果S为空，则table[i][0] = 0
initialize一个table[S + 1][T + 1] 包括初始化0
如果： s[j] == T[k] 则table[i + 1][j + 1] = table[i + 1][j] + table[i][j]
                    否则                  = table[i + 1][j]；

 * reference http://blog.csdn.net/abcbc/article/details/8978146**/
public class Solution {
    public int numDistinct(String S, String T) {
        int[][] table = new int[T.length() + 1][S.length() + 1];
        for (int i = 0; i <= S.length(); i++){
            table[0][i] = 1;
        }

        for (int i = 0; i < T.length(); i++){
            for (int j = 0; j < S.length(); j++){
                table[i + 1][j + 1] = table[i + 1][j]
                    + (S.charAt(j) == T.charAt(i) ? table[i][j] : 0);
            }
        }
        return table[T.length()][S.length()];
    }
}
