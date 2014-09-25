/**
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.

Google Question
Use variable carry
*/
public class Solution {
    public int[] plusOne(int[] digits) {
        int sum = 0;
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--){
            sum = digits[i] + carry;
            carry = sum / 10;
            digits[i] = sum % 10;
        }
        if (carry ==1){
            int[] result = new int[digits.length + 1];
            result[0] = 1;//cause if in the end we have carry = 1, then the original number must be something 9, 99, 999
            //after adding one, the leftover all become 0
            return result;
        }
        return digits;
    }
}
