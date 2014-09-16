/**
*Given a string S, find the longest palindromic substring in S.
*You may assume that the maximum length of S is 1000,
*and there exists one unique longest palindromic substring.
* space 1 time n square
**/
public class Solution {

        public String longestPalindrome(String s) {
          String longest = "";

          for (int i = 0; i < s.length(); i++){
            //center with odd numbers, and expand from center to both sides
            String temp = helper(i, i, s);
            if (temp.length() > longest.length()){
              longest = temp;
            }
            //center with even numbers, and expand from center to both sides.
            temp = helper(i, i + 1, s);
            if (temp.length() > longest.length()){
              longest = temp;
            }
          }

          return longest;
        }

        public String helper(int start, int end, String s){
          while (start >= 0 && end <= s.length() - 1 && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
          }
          return s.substring(start + 1, end);
        }
}
