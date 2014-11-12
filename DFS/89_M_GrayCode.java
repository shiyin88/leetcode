/*
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.

Hide Tags Backtracking
当n <= 1的时候，加入i到result，即0和1
一直做backtracking， 然后当n >=2的时候，我们把之前的result，倒序放入新的一个list reverse中
e.x result  [0,
             1]
    reverse [1,
             0]
为了保证相邻的字节只有一个是不同的，在做n >=2的时候，是在n - 1的基础上，在最左面加上0或是1
一直result已经是加上0的结构了，
需要把reverse的list最前面加上1，即reverse中当前的digit左面多加一位，需要用<<来左移一位，根据现在的n的位数
然后把左移的1 和现有reverse list的数相加，求得新的数
ex 当n = 2的时候
  result  [00,
           01]
  reverse [11,
           10]

更简便的方法：
http://blog.csdn.net/linhuanmars/article/details/24511221
**/
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        if (n <= 1){
            for (int i = 0; i <= n; i++){
                result.add(i);
            }
            return result;
        }
        result = grayCode(n - 1);
        List<Integer> reversed = reverseList(result);
        int shift = 1 << (n - 1);
        for (int i = 0; i < reversed.size(); i++){
            reversed.set(i, shift + reversed.get(i));
        }
        result.addAll(reversed);
        return result;
    }
    public List<Integer> reverseList(List<Integer> input){
        List<Integer> reversed = new ArrayList<Integer>();
        for (int i = 0; i < input.size(); i++){
            reversed.add(0, input.get(i));
        }
        return reversed;
    }
}
