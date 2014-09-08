/**
* space 1 time n square
**/
public class Solution {

        public String longestPalindrome(String s) {
          String longest = "";

          for (int i = 0; i < s.length(); i++){

            String temp = helper(i, i, s);
            if (temp.length() > longest.length()){
              longest = temp;
            }

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
