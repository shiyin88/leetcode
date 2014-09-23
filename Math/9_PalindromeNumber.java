/**
Determine whether an integer is a palindrome. Do this without extra space.
comparing from the two ends.
First, compare the first and last digit. If they are not the same,
it must not be a palindrome.
If they are the same, chop off one digit from both ends and continue until
you have no digits left, which you conclude that it must be a palindrome.
*/

public class Solution {
    public boolean isPalindrome(int x) {

        int div = 1;
        if (x < 0) return false;
        while (x / div >= 10){//to see how many zeros left behind 看进制
            div = 10 * div;
        }

        while(x != 0){
          int left = x / div;
          int right = x % 10;
          if (left != right) return false;
          x = (x % div) / 10;//x % div 得出余数 去除百位， 进而 /10去除个位数
          div = div / 100;
        }
        return true;

    }
}
