/***
 * Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.

Hide Tags Math String

 * 1. +/- : 1)如果在index = 0的位置，continue去下一个index
 *          2)如果前面为E后面为整数 如： e+6 可以
 * 2. e ：  1) e不可以在首位和末尾 e.x 3e or e3
 *          2) e不可以出现一次以上
 *          3) e之前必须有数字 比如 6e可以， .e不可以
 *          4) e后面不可以有. 比如： 5e. ; 5e4.3不可以 13.5e2可以
 * 3. 。 :  1)不能只有.并且length = 1 的情况
 *          2)当。出现在末尾，不能有前一位不是数字的情况，比如3e. +.
 *          3)。只能出现一次
 *  在层层检验false的情况下（包括空格），剩余的return true
 *
 * **/
public class Solution {
    public static boolean isNumber(String s) {

        s = s.trim();
        if (s == null || s.length() < 1){
            return false;
        }
        boolean period = false;
        boolean hasE = false;
        boolean hasNumber = false;

        if (s.length() > 1 && (s.charAt(0) == '-' || s.charAt(0) == '+')){
              s = s.substring(1);
        }
        for (int i = 0; i < s.length(); i++){

            if (s.charAt(i) == 'e'){
                if (i == 0 || i == s.length() - 1){//cases like : 'e1' or '1e'
                	return false;
                }

                if (!hasNumber){
                    return false;
                }

                if (!hasE){
                    hasE = true;
                    continue;
                }else{
                    return false;
                }

            }
            if (s.charAt(i) == '.'){
                if (s.length() == 1){
                    return false;
                }
                if (i == s.length() - 1){
                    if (s.charAt(i - 1) >'9' || s.charAt(i - 1) < '0')
                    {
                        return false;
                    }
                }
                if (!period && !hasE){//if cases like 14e6.6
                    period = true;
                    continue;
                }else{
                    return false;
                }
            }
           if (s.charAt(i) == '+' || s.charAt(i) == '-'){
                if (i > 0 && i < s.length() - 1){
                    if ( (s.charAt(i - 1) == 'e')
                    && (s.charAt(i + 1) <= '9' && s.charAt(i + 1) >= '0')){
                        continue;
                    }
                }
            }
            if (s.charAt(i) > '9' || s.charAt(i) < '0'){
                return false;
            }
            hasNumber = true;
        }

        return true;
    }

}
