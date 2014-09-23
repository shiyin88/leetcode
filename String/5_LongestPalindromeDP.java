/**
*Given a string S, find the longest palindromic substring in S.
*You may assume that the maximum length of S is 1000,
*and there exists one unique longest palindromic substring.
* space 1 time n square
**/
public class Solution {

        public static String longestPalindrome(String s) {

          if (s == null){
            return null;
          }
          //1. if s is a single letter
          if (s.length() == 1){
            return s;
          }

          int[][] table = new int[s.length()][s.length()];
          String longStr = "";
          int length = s.length();
          int maxLen = 0;
          //All substrings of length 1 are palindromes
          for (int i = 0; i < length; i++){
            table[i][i] = 1;
          }

          // 2. check for sub-string of length 2.
          for (int i = 0; i< s.length() - 1; i++){
            if (s.charAt(i) == s.charAt(i + 1)){
              table[i][i + 1] = 1;
              longStr = s.substring(i,i + 2);//[i,i+1]
            }
          }

          // 3. Check for lengths greater than 2. k is length of substring
          for (int k = 3; k <= length; k++){
            // Fix the starting index
            for(int i = 0; i < length - k + 1; i++){
              // Get the ending index of substring from starting
              //index i and length k
              int j = i + k - 1;
              //if s[i] == s[j] && from string i+1 to j-1 is palindrome
              if (s.charAt(i) == s.charAt(j) && table[i + 1][j - 1] == 1){
                //table[i][j] = table[i + 1][j - 1];
                table[i][j] = 1;//changeable
                if (k > maxLen){
                  maxLen = k;
                  longStr = s.substring(i, j + 1);
                }
              }else{
                table[i][j] = 0;
              }

            }
          }

          return longStr;
        }


}
