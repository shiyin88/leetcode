/**
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
DFS
*/
public class Solution {
    public List<String> generateParenthesis(int n) {

        if ( n <= 0) return new ArrayList<String>();
        List<String> result = new ArrayList<String>();
        helper("", result, n, n);
        return result;
    }

    public void helper(String str, List<String> result, int left, int right){

        if (left == 0 && right == 0){
            result.add(str);
            return;
        }

        if (left > right || left < 0 || right < 0){
            return;
        }

        helper(str + "(", result, left - 1, right);
        helper(str + ")", result, left, right - 1);
    }
}
