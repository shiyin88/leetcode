/**
 * Write a function to find the longest common prefix string amongst an array of strings.

Hide Tags String
**/
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        //找出strs数组中最小长度的string
        int min_len = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++){
            min_len = Math.min(strs[i].length(), min_len);
        }
        //当strs数组中有一个空string，或是所以的string都没有相同的prefix
        //则返回空集。这个需要提前判断
        if (min_len == 0) return "";
        char prefix = '0';
        //两个for loop。outer loop判断每个digit的数值
        for (int i = 0; i < min_len; i++) {
            //k来循环string数组中每个string
            for (int k = 0; k < strs.length; k++) {
                /**
                当k=0时，因为是初始阶段；无法和其他string判断prefix
                所以需要给prefix赋值。
                **/
                if (k == 0) {
                    prefix = strs[k].charAt(i);
                    continue;
                }
                /**当k>0时，有两个string，则开始判断两个string的值
                 * 如果不等，则返回i前一位的index
                 **/
                if (prefix != strs[k].charAt(i)){
                    return strs[k].substring(0, i);
                }
            }
        }
        /**此处return，返回当strs数组中只有一个string时，
         * ex.strs[["a"]]
         * */
        return strs[0].substring(0, min_len);
    }
}
