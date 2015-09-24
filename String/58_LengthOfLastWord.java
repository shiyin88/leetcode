/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.

We just need a flag to mark the start of letters from the end. If a letter starts and the next character is not a letter, return the length.
*/
public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        int count = 0;
        boolean flag = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
            || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')){
                flag = true;
                count++;
            }else{
                if (flag == true) {
                    return count;
                }
            }
        }
        return count;
    }
}
