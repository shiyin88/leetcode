/**
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.

Hide Tags Two Pointers String
**/
public class Solution {
   public static boolean isPalindrome1(String s) {
       /**
        * 这样做的好处是： 把所有非alphanumeric的char用""来代替，
        * 避免string = null 空指针异常。比如："."
        * 执行后s = 0, and end = -1 避免了s.length() - 1时是
        * nullpointerexception**/
        s = s.replaceAll("[^0-9a-zA-Z]", "").toLowerCase();

        int start = 0;
        int end = s.length() - 1;

        while (start < end){
            if (s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
