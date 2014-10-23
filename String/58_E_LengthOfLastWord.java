/**
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example,
Given s = "Hello World",
return 5.
*/
//use method String.split() and return the last index in the array
public class Solution {
    public static int lengthOfLastWord(String s) {
        if (s == null || s == "") return 0;
        s = s.trim();//remove spaces in the head and tail
        String[] arr = s.split(" ");

        return arr[arr.length - 1].length();
    }
  //use s.substring to remove chars before space
    public static int lengthOfLastWord2(String s) {
            if (s == null || s == "") return 0;
            s = s.trim();
            for (int i = 0; i < s.length(); i++){
                if (s.charAt(i) == ' '){
                    s = s.substring(i + 1);
                    i = -1;
                }
            }
            return s.length();
    }
}
