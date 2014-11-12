/**
 * Write a function to find the longest common prefix string amongst an array of strings.

Hide Tags String

首先声明一个值，为res = strs[0]， 然后for 循环从i = 1 到i = strs.length - 1，并且所有的string和res比较每一个char
如果相等，则index++ 否则break
最后的result为 res.substring(0, index); 由于是找公共的common prefix， 所以肯定是在res的基础上做substring找最小的substring
即为res**/
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1){
            return "";
        }
        String res = strs[0];
        for (int i = 1; i < strs.length; i++){
            int index = 0;
            String temp = strs[i];
            while (index < res.length() && index < temp.length()){
                if (temp.charAt(index) == res.charAt(index)){
                    index++;
                }else{
                    break;
                }
            }

            res = res.substring(0, index);
        }
        return res;
    }
}
