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
        // 创建二维char数组，按照从0到9的按键顺序初始化，则用char[index][]就可以取到相应数字按键对应的字母
        //由于是和键盘相对应，所以index 0 和 1 为空
        char[][] map = {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'n', 'm', 'o'},
            {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, { 'w', 'x', 'y', 'z'}};
         //we put it this way in order to have each set of letters matches the position of the digits on the pad
        if (sb.length() == digits.length()){
            result.add(sb.toString());
            return; //once we find the value, we end the current recursion
        }
        // index表示当前应该取哪个数字里面的字母了，这里取到的数字应该是digits中对应上一外层递归的后面一个字符
        // 比如给定digits是23，由于最开始path.length()长度为0，则会取到digits.charAt(0)对应的数字
        // 由于for循环中path.append()操作，path.length()长度加1，此时进入内层递归后则会取到charAt(1)对应的数字
        int index = Character.getNumericValue(digits.charAt(sb.length()));//get each digit in the digits string

        for (int i = 0; i < map[index].length; i++){
            // 将当前对应数字中的第i个字母(char)append到sb中
            sb.append(map[index][i]);
            // 进入内层递归遍历检查digits中当前数字的后面一个数字
            helper(digits, result, sb);
            // 回溯，删除掉path中最后一个字母，for循环继续检查当前对应数字的下一个字母
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}


public class Solution {
    public List<String> letterCombinations(String digits) {
        char[][] map = {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'n', 'm', 'o'},
            {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, { 'w', 'x', 'y', 'z'}};

        List<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        letterHelper(digits, result, sb, 0, map);
        return result;
    }

    public void letterHelper(String digits,List<String> result, StringBuilder sb, int pos, char[][] map){
        if (sb.length() == digits.length()){
            result.add(new String(sb));
            return;
        }
        //get every single digit from String digits. Initiallay as sb is a empty,so the index = 0;
        int index = Character.getNumericValue(digits.charAt(sb.length()));
        /**
        此处i 不可以等于 pos， 因为随着每次i++,下次i会递增，相应着就取值map就一直是
            map[index][i] 和 map[index][i + 1] 两个数
            e.x 22
            Output:	["aa","ab","ac","bb","bc","cc"]
            Expected:	["aa","ab","ac","ba","bb","bc","ca","cb","cc"]
        **/
        for (int i = 0; i < map[index].length; i++){
            sb.append(map[index][i]);
            letterHelper(digits, result, sb, i, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
