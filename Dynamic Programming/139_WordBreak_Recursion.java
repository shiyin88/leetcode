/**
*Given a string s and a dictionary of words dict,
determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*******Exceeds time limit. Time: O(2^n)
*/

public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        return wordBreakHelper(s, dict, 0);

    }

    public boolean wordBreakHelper(String s, Set<String> dict, int start){
       if (s.length() == start){
          return true;
        }

        for (String str : dict){

          int end = start + str.length();
          if (end > s.length()){
        	  continue;
          }

          if (s.substring(start, end).equals(str)){

             if (wordBreakHelper(s, dict, end)){
            	 return true;
             }
          }
        }

        return false;
    }
}
