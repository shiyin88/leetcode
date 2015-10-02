/**
 * 题目大意：
编写一个算法判断某个数字是否是“快乐数”。

快乐数的定义过程如下：从任意一个正整数开始，将原数替换为其每一位的平方和，重复此过程直到数字=1（此时其值将不再变化），或者进入一个不包含1的无限循环。那些以1为过程终止的数字即为“快乐数”。

例如：19是一个快乐数，演算过程见题目描述。

解题思路：
模拟题，循环过程中用set记录每次得到的平方和

当出现非1的重复平方和时，返回False

否则，返回True
https://sisijava.wordpress.com/2015/05/26/leetcode-happy-number/
http://bookshadow.com/weblog/2015/04/22/leetcode-happy-number/
**/
public class Solution {
    public boolean isHappy(int n) {
        
        Set<Integer> set = new HashSet<Integer>();
        int sum = 0;
        while (!set.contains(n)) {
            sum = 0;
            set.add(n);
            while (n > 0) {
                int temp = n % 10;
                n = n / 10;
                sum = sum + temp * temp;
            }
            if (sum == 1) {
                return true;
            }
            n = sum;
        }
        return false;
    }
}
