/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.

Hide Tags Dynamic Programming

 * 首先我们先定义几个变量，并对这几个量做一定的说明！为了方便理解，下面这些为伪码!!!
len  = str.length();   // 字符串的长度

int[] cuts = new int[len + 1]; //cuts数组，cuts[i] 表示 以 i 开头到len结尾的子串 要达到题意需要的最少切割数（这样子最终 cuts[0]就是我们要的结果）【初始化 cuts[i] = len - i, 因为最坏情况以 i 开头到len结尾的子串要切割数就是每个字符都切一次】

int[][] matrix = new  int[len][len]; //设置出一个邻接矩阵数组，它所表示的意思：如matrix[i][j] = true, 表示 子串 sub(i, j) 是满足回文字符串条件的！
那么判断matrix[i][j] 是否满足回文字符串的条件是：
matrix[i+1][j-1] == true (表示sub(i+1,j-1)是满足回文字符串) && str[i] == str[j]
或者
j - i < 2 && str[i] == str[j] （即如果j - i == 1时，为两个字符相等，如果j - i == 0时，为同一个字符）
这两种情况，我们都将matrix[i][j]设置成true，方便下一次的DP，并且我们可以求出最小的切割次数
cuts[i] = min{cuts[i], cuts[j+1] + 1};  状态转移方程式
这样最后cuts[0] - 1便为 字符串str的最小的切割数！！！！
reference : http://blog.csdn.net/ljphhj/article/details/22573983
http://www.cnblogs.com/springfor/p/3891896.html
**/
public class Solution {
    public int minCut(String s) {
        if (s == null || s.length() < 0){
            return 0;
        }
        //表示i到j间是否为palindrome
        boolean[][] matrix = new boolean[s.length()][s.length()];
        //i shows the min cut from i to length
        int[] res = new int[s.length() + 1];
        //表示每段的最大切割数。如果s.length() == 3 则最大切割为3
        for (int i = 0; i <= s.length(); i++){
            res[i] = s.length() - i;
        }

        for (int i = s.length() - 1; i >= 0; i--){
            //表示i ~ j段 检查i~j段是否为palindrome
            for (int j = i; j < s.length(); j++){
                //s和j是同一个字母，或是s和j相邻
                if (s.charAt(i) == s.charAt(j) &&
                    (j - i < 2 || matrix[i + 1][j - 1])){
                    //或是s和j相等，s.substring(s + 1, j)为palindrome
                    matrix[i][j] = true; //update i ~ j的status
                    res[i] = Math.min(res[i], res[j + 1] + 1);
                }
            }
        }
        return res[0] - 1; //index 0 表示从0 ~length()的绳长的最小切割数
    }
}
