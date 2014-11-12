/**
 * Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Update (2014-11-02):
The signature of the function had been updated to return the index instead of the pointer. If you still see your function signature returns a char * or String, please click the reload button  to reset your code definition.

Hide Tags Two Pointers String
本文求，needle这个string是否是在haystack这个string内。如果在，即返回index
 * get the length of both string
 * The last index of char we scan in the haystack is (length1 - length2)
 * so we just loop the string every time and find if the string == needle
    if haystack == null then needle is not part of haystack, return -1
    if needle.length == 0, then return 0
 **/
public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null){
            return -1;
        }
        if (needle.length() == 0){
                return 0;
        }

        int length1 = haystack.length();
        int length2 = needle.length();

        for (int i = 0; i < length1 - length2 + 1; i++){
            if (haystack.substring(i, i + length2).equals(needle)){
                return i;
            }
        }

        return -1;
    }
}
