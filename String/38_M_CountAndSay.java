/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.

Hide Tags String

解题思路：
用两个循环：
while外循环：统计回合。即 N
内循环：遍历当前str的值，统计相同数，或是不同。**/
public class Solution {
    public String countAndSay(int n) {
        //initialization
        if (n == 1){
            return "1";
        }
        //by default, first round result is given
        String str = "1";
        int round = 1;
        StringBuilder sb = new StringBuilder();

        //representing round greater than 1
        while (round++ < n){ //if we need to get n sequence, then we need to generate it from 0 to n
            int count = 1;
            int i = 0;
            //遍历上一轮中str的char，并且根据char中是否有重复字节来判断当前round中所产生的新的string
            for (i = 1; i < str.length(); i++){
                if (str.charAt(i) == str.charAt(i - 1)){
                    count++;
                }else{
                    //当当前str[i] != str[i -1]我们把i-1轮之前的str append到sb中，
                    //并且count = 1(包含当前i不同的char的次数)
                    sb.append(count).append(str.charAt(i - 1));
                    count = 1;
                }
            }
            //当跳出当前round时，由于for loop里面只是append了 str[i - 1]的chars， 这里我们
            //append str[i]的字节。由于当 i = str.length - 1后，再进入for loop，i++ = str.length()
            //不满足条件后跳出，但是由于i +1了已经，我们要的最后一个字节实际已是 i - 1个字节了。
            sb.append(count).append(str.charAt(i - 1));
            str = sb.toString();//convert sb to string
            sb = new StringBuilder();//clear sb

        }
        return str;
    }
}
