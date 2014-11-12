/**
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

click to show clarification.

Clarification:
What constitutes a word?
A sequence of non-space characters constitutes a word.
Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.
How about multiple spaces between two words?
Reduce them to a single space in the reversed string.
Hide Tags String
**/
public class Solution {
    public static String reverseWords(String s) {
        s = s.trim();
        int counter = 0;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (i = s.length() - 1; i >= 0; i--){
            /**
             * 在加入一个char的时候，我们是跳到char前面的空格
             * 为保证这里我们只加了一个空格，所以我们要检查是否
             * 之前我们以及加了一个空格。e.x a _ _ _ b
             * 在跳到s[1], s[2]的时候，由于在s[3]的位置已经加了空格
             * 所以这里我们不会再加入空格，直接跳出，i++）
             * 当指针扫过char，经过第一个空格的时候，
             * 把char 给append， 并且append一个空格
             * 把counter复位为0.由于counter记录的是当前char的字数。
             * 当我们把char append后，counter归0**/
            if (s.charAt(i) == ' ' && s.charAt(i + 1) != ' '){
                sb.append(s.substring(i + 1, i + counter + 1));
                sb.append(" ");
                counter = 0;
            }else{
                /**
                 * 为保证counter只是记录当前字母的长度，所以我们这里要保证
                 * 当前的char不是空格**/
            	if (s.charAt(i) != ' '){
            		 counter++;
            	}
            }
        }
        /**
         * 由于我们在记录单词的时候是跳到单词前的空格。但是当指针指向头的时候，
         * 由于我们之前已经把单词给trim了。所以第一个单词是没有空格的，直接跳出
         * for loop。但是我们已经记录的字节的长度在counter里面。所以我们直接
         * append最后一个字节。**/
        sb.append(s.substring(i + 1,counter));

        return new String(sb);
    }
}
