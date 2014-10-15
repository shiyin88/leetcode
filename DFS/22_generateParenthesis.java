/**
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
DFS

这道题通过设两个integer的变量给left 和 right
在每次通过两次递归， 相应加左括号和右括号
通过加入限定条件，比如， 保证left > right来保证括号是 () format
*/
public class Solution {
    public List<String> generateParenthesis(int n) {

        if ( n <= 0) return new ArrayList<String>();
        List<String> result = new ArrayList<String>();
        //此题是通过新建一个空string，在原有string加上内容来承载content，随后赋给list
        helper("", result, n, n);
        return result;
    }

    public void helper(String str, List<String> result, int left, int right){

        //base case: ending position. Only used up all the left and right parenthesis
        if (left == 0 && right == 0){
            result.add(str);
            return;
        }
        /**
        left > right : to make sure the parenthese is correct. --> ()
                        if no this condition, --> )( would count
        if no condition for left and right < 0; the program will infinitely
        And the time will exceeeded. No condition to end the program**/
        if (left > right || left < 0 || right < 0){
            return;
        }
        //append parenthesis to the string in each recursion
        helper(str + "(", result, left - 1, right);
        helper(str + ")", result, left, right - 1);
    }
}
