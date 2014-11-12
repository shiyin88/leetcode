/**
Multiply Strings Total Accepted: 16439 Total Submissions: 80284 My Submissions Question Solution
Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.

Hide Tags Math String

 * 1. 由于两个大整数相乘，会有溢出的情况，这里我们按照做正常的乘法运算，
 * 把num1中的每个digit 和 num2乘，得出的数按照正常的顺序放入result数组中。
 * 得出的为一个result数组。但是我们需要把数组convert成String
 * 2. 用StringBuilder把数组的数变成一个StringBuilder，但是有可能当0 * 0 最后result里为【0，0】
 * 3. 这样，我们通过while loop消除首位是0的情况
 * 4.最后return的值需要判断，如果如上文，当0*0的结果中【0，0】在3中都消除了，我们就return 0 otherwise return sb.toString();
 * */
public class Solution {
    public static String multiply(String num1, String num2) {

		int length = num1.length() + num2.length();
        int[] result = new int[length];

        for (int i = 0; i < num1.length(); i++){
        	int carry = 0;
        	int a = num1.charAt(num1.length() - 1 - i) - '0';//the last digit in the num1
            for (int k = 0; k < num2.length(); k++){
            	int b = num2.charAt(num2.length() - 1 - k) - '0';//the last digit in the num2
                result[length - 1 - i - k] += a * b + carry;
                carry = result[length - 1 - i - k] / 10;
                result[length - 1 - i - k] %= 10;
            }
            result[length - i - num2.length() - 1] += carry;

        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++){
        	sb.append(result[i]);
        }
        while (sb.length() > 0 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

}
