/**
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
Hide Tags Dynamic Programming String

four operations include:
1) if A[i] == B[j] E(i, j) = E(i - 1, j - 1)
那我们就看它们之前的operation
e.x eat & et A[3] == B[2] 则我们看A[2]和B[1]的最小operation
2) if A[i] != B[j]
2-1 Deletion: E(i, j) = E(i - 1, j) + 1
ex eaty -> ebt : delete 'y' +1 operation
                 然后看E(i - 1, j)即 eat ->ebt的最优解
2-2 Replace: E(i, j) = E(i - 1, j - 1) + 1
ex eat -> ety : replace 't' to 'y' +1 operation
                然后看E(i - 1, j - 1)的最优解 即ea ->et的最优解
2-3 Insertion : E(i, j) = E(i, j - 1) + 1
e.x eat -> ebts : insert 's' +1operation
                然后看E(i, j - 1)的最优解 即eat ->ebt的最优解
取上面三个操作的最小值

reference : https://www.youtube.com/watch?v=zqZ9DetbpSs
http://codercareer.blogspot.com/2011/12/no-25-edit-distance.html
 **/
public class Solution {
    public int minDistance(String word1, String word2) {
       int[][] table = new int[word1.length() + 1][word2.length() + 1];
       //word1 is row (left), word2 is col(top)
       for (int i = 0; i <= word1.length(); i++){
           table[i][0] = i;//here represent the first col
       }
       for (int i = 0; i <= word2.length(); i++){
           table[0][i] = i;
       }

       for (int i = 0; i < word1.length(); i++){
           for (int j = 0; j < word2.length(); j++){
               if (word1.charAt(i) == word2.charAt(j)){
                   table[i + 1][j + 1] = table[i][j];
               }else{
                   int replace = table[i][j] + 1;
                   int delete = table[i][j + 1] + 1;
                   int insert = table[i + 1][j] + 1;
                   table[i + 1][j + 1] = Math.min(Math.min(replace, delete), insert);
               }
           }
       }
       return table[word1.length()][word2.length()];

    }
}
