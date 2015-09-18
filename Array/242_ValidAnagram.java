/**
 * 
 * Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

主要用了Arrays.sort来sort string中的字母。但是不能直接sort，
只有先把string转化成toCharArray，再进行比较。
**/
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        if (s == null && t == null) return true;
        
        if (s.length() != t.length()) return false;
        
        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();
        
        Arrays.sort(schar);
        Arrays.sort(tchar);
        for (int i = 0; i < s.length(); i++){
            if (schar[i] != tchar[i]){
                return false;
            }
        }
        return true;
    }
}
