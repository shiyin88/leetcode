/**
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
解决了Letter Combination of a Phone Number，我们再看这道题

首先我们要明确传统IP 地址的规律是分4个Part，每个Part是从0-255的数字

0-255的数字，转换成字符，即每个Part 可能由一个字符组成，二个字符组成，或者是三个字符组成。那这又成为组合问题了，dfs便呼之欲出

所以我们写一个For循环每一层从1个字符开始取一直到3个字符，再加一个isValid的函数来验证取的字符是否是合法数字，如果是合法的数字，我们再进行下一层递归，否则跳过。
*/
public class Solution {
    public List<String> restoreIpAddresses(String s) {

        List<String> result = new ArrayList<String>();

        /**
         * 提前规范输入的长度符合IP规范，即[4,12]**/
        if (s.length() > 12 || s.length() < 4) return result;

        helper(s, result, "", 0);
        return result;
    }

    public void helper(String s, List<String> result, String temp, int pos){
        if (pos == 3 && isValid(s)){
            result.add(temp + s);
            return;
        }

        for (int i = 1; i < 4 && i < s.length(); i++){
            String prefix = s.substring(0, i);
            if (isValid(prefix)){
                 helper(s.substring(i), result, temp + prefix + ".", pos + 1);
            }
        }
    }
    public boolean isValid(String s){
        if (s.charAt(0) == '0') return s.equals("0");//01 011 011 : false;  0 : true;
        int num = Integer.parseInt(s);
        if (num > 255 || num <= 0) return false; // 0 <= length() < 255
        return true;
    }


}
