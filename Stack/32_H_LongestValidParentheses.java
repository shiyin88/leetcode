/**
 * Longest Valid Parentheses Total Accepted: 19939 Total Submissions: 100691 My Submissions Question Solution
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.

Hide Tags Dynamic Programming String
**/
public class Solution {
    public static int longestValidParentheses(String s) {

        if (s == null) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();
        int maxLen = 0;
        int sum = 0;

        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                	//()())()
                	/**
                	 * 由于到i=4的时候为')'，stack中为空，已经
                	 * 破坏了括号的结构，故把sum重新赋值给0
                	 */
                    sum = 0;
                } else {
                    int left = stack.pop();
                    int count = i - left + 1;
                    //即可以总结了
                    if (stack.isEmpty()) {
                    	//当stack为空的时候，即一轮的一组组括号已经遍历完成
                    	//即可以总结当下的括号总数
                        sum += count;
                        count = sum;
                        /**
                         * 最后把count放入maxLen是因为，当出现
                         * sum的时候是stack中没有括号的时候，即()一组已经全部输出完成，开始
                         * 下一组的时候
                         * 但是最后把sum赋值给count去比较，是因为
                         * 有(()的情况，即pop一组括号后，仍然后(
                         * 无法判断下面时候还有括号，所以输出当前的count
                         */
                    } else {
                    //扔无法总结，需要核对当前
                        count = i - stack.peek();
                    }

                    maxLen = Math.max(maxLen, count);
                }
            }
        }
        return maxLen;
	}
}
