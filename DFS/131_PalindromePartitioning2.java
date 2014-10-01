/**
分析：

题意给我们一个字符串，求出所有这个字符串的子串，并且子串都为回文字符串的情况，输出它的集合结果



解题思路：（跟DFS深度遍历有点像!）

字符串Str = "aab";

分析了题目的数据之后，我们知道它的结果，可能是 a, a, b 或者  aa, b 这样的情况！

也就是说，我们需要去考虑 i = 1,  2 ....  n 的情况，比如

Str = "aaa"

结果集


[[a, a, a], [a, aa], [aa, a], [aaa]]

根据这样的情况，我们用类似于DFS的算法

str1 = str.substr(0, i); 取出前面下标从 0 开始到 i 结束的子串，判断str1是否满足回文字符串的要求，

1. 满足：这样子，有可能成为一种分割的情况，所以我们new出一个list集合，把str1放入到list中，然后我们求出str剩余的子串  str2 = str.substr(i); 取出前面下标从 i 开始到整个字符串结尾的子串， 然后将str2 作为新的字符串，同时把list集合也传入到函数中，递归调用。递归的结束条件就是到传入的这个字符串的长度为0（这样就意味着已经到了字符串的末尾了），此时证明这种情况下得到的list集合是满足条件的，我们把这个list集合 加入到 结果集合result中。

2. 不满足的话，继续 i++， 直到 i == str.length();

3. 全部结束之后，返回 最终的结果集合 result


*/


public class Solution {
    /*
     * 供外部调用
     * */
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<String> list = new ArrayList<String>();

        if (s == null || s.length() == 0)
            return result;

        calResult(result,list,s);
        return result;
    }
    /**
     * 判断一个字符串是否是回文字符串
     * i -> str[0]
     * j -> str[len-1]
     * i:往后移
     * j:往前移
     * @param str
     * @return
     */
    private boolean isPalindrome(String str){

        int i = 0;
        int j = str.length() - 1;
        while (i < j){
            if (str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     *
     * @param result : 最终要的结果集 ArrayList<ArrayList<String>>
     * @param list : 当前已经加入的集合 ArrayList<String>
     * @param str : 当前要处理的字符串
     */
    private void calResult(ArrayList<ArrayList<String>> result
            , ArrayList<String> list
            , String str)
    {
        //当处理到传入的字符串长度等于0,则这个集合list满足条件，加入到结果集中
        if (str.length() == 0)
            result.add(new ArrayList<String>(list));
        int len = str.length();
        //递归调用
        //字符串由前往后，先判断str.substring(0, i)是否是回文字符串
        //如果是的话，继续调用函数calResult，把str.substring(i)字符串传入做处理
        for (int i=1; i<=len; ++i){
            String subStr = str.substring(0, i);
            if (isPalindrome(subStr)){
                list.add(subStr);
                String restSubStr = str.substring(i);
                calResult(result,list,restSubStr);
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().partition("aabaa"));
    }
}  
