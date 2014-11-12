/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

Hide Tags Stack String
这道题通过stack和map来完成，很巧妙
分别把括号的左边和右边放入map内
在for循环里面，分别提取string s的每个index

如果index为括号左边，放入stack内
如果index为括号右边，
        1）那首先要保证stack里面有值，并且stack的最上面的char为 和index相对应的 括号的左边
            即： !stack.isEmpty() 和 查看stack里面的值用stack.peek(), 然后通过map.get(keyset == stack.peek()) 看是否== current
                 如果符合条件，pop stack()上面的值 然后进行下一次循环
        2）如果不满足条件，则说明符号排列不满足条件，即return false
**/
public class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++){
            char current = s.charAt(i);
            if (map.keySet().contains(current)){
                stack.push(current);//push left part of parentheses to the stack
            }else if (map.values().contains(current)){
                if (!stack.isEmpty() && map.get(stack.peek()) == current){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
