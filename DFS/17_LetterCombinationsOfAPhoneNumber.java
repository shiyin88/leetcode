/**
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below
Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/
public class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        helper(digits, result, sb);
        return result;
    }

    public void helper (String digits, List<String> result, StringBuilder sb){
        char[][] map = {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'n', 'm', 'o'},
            {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, { 'w', 'x', 'y', 'z'}};
         //we put it this way in order to have each set of letters matches the position of the digits on the pad
        if (sb.length() == digits.length()){
            result.add(sb.toString());
            return; //once we find the value, we end the current recursion
        }

        int index = Character.getNumericValue(digits.charAt(sb.length()));//get each digit in the digits string

        for (int i = 0; i < map[index].length; i++){
            sb.append(map[index][i]);
            helper(digits, result, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}
