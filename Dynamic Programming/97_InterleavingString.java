/**
 * 1) 用递归，但是最后一个大数据通不过
 * 我们从头到尾遍历这三个String，比如取名s1,s2,s3，然后取p1,p2,p3三个指针来对应每个String里当前遍历到的字符位置
这么想，如果s1的p1位，和s2的p2位，和s3的p3位都相等，那么在s3挑选的字符的时候，我们可以挑s1的那一位，也可以挑s2的那一位，所以在递归的时候我们用或（｜｜）把两种情况连接起来，传入s1的下一位，或者s2的下一位
如果只有s1的p1位和s3的p3位相等，那只能传入s1的下一位
如果只有s2的p2位和s3的p3位相等，那只能传入s2的下一位
如果没有发现相等，return false 退回到上一层
reference http://blog.csdn.net/u011095253/article/details/9248073
2) DP
reference :
http://huntfor.iteye.com/blog/2086539
http://blog.csdn.net/u011095253/article/details/9248073
**/

//Dynamic Programming
public class Solution {
   public boolean isInterleave(String s1, String s2, String s3) {
       if (s1 == null || s2 == null || s3 == null) return false;
       if (s1.length() + s2.length() != s3.length()){
           return false;
       }
       boolean[][] table = new boolean[s2.length() + 1][s1.length() + 1];
       table[0][0] = true;
       //top row表示是s1的值 先检查s1的index所得的值是否和s3的index的值相等
       for (int i = 1; i <= s1.length(); i++){//start from i. represent table行数而不是index
           table[0][i] = table[0][i - 1] && (s1.charAt(i - 1) == s3.charAt(i - 1));
       }
       //left column表示s2的值 先检查s2的index所得的值是否和s3的index的值相等
       for (int i = 1; i <= s2.length(); i++){//start from i. represent table行数而不是index
           table[i][0] = table[i - 1][0] && (s2.charAt(i - 1) == s3.charAt(i - 1));
       }

       for (int i = 1; i <= s2.length(); i++){
           for (int j = 1; j <= s1.length(); j++){
               /**即table[i][j]的值为：
                * table[i - 1][j]即s2的前一个值和s3相等，在table中为true。现index（即i-1)由于用table
                * 表示，每个index都加了1，现index的值和s3中的值相等
                * 或是
                * table[i][j - 1]即s1的前一个值和s3相等，在table中为true。现index（即i-1)由于用table
                * 表示，每个index都加了1，现index的值和s3中的值相等
               **/
               table[i][j] = (table[i - 1][j] && s2.charAt(i - 1) == s3.charAt(i + j - 1))
                    ||(table[i][j - 1] && s1.charAt(j - 1) == s3.charAt(i + j - 1));
           }
       }
       return table[s2.length()][s1.length()];
    }
}

//Recursion
public class Solution {
   public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()){
            return false;
        }
        return helper(s1, 0, s2, 0, s3, 0);
    }
    public boolean helper(String s1, int p1, String s2, int p2, String s3, int p3){
        if (p3 == s3.length()){
            return true;
        }
        if (p1 == s1.length()){//即看s3剩余部分是否和s2剩余部分相同
            return s2.substring(p2).equals(s3.substring(p3));
        }
        if (p2 == s2.length()){
            return s1.substring(p1).equals(s3.substring(p3));
        }
        if (s3.charAt(p3) == s1.charAt(p1) && s3.charAt(p3) == s2.charAt(p2)){
            return helper(s1, p1 + 1, s2, p2, s3, p3 + 1) || helper(s1, p1, s2, p2 + 1, s3, p3 + 1);
        }else if (s1.charAt(p1) == s3.charAt(p3)){
            return helper(s1, p1 + 1, s2, p2, s3, p3 + 1);
        }else if (s2.charAt(p2) == s3.charAt(p3)){
            return helper(s1, p1, s2, p2 + 1, s3, p3 + 1);
        }

		return false;
    }
}
