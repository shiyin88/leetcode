/**
*Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2

Time: n^2 Space: n
*/

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int index1 = 0;
        int index2 = 0;

        for (int i = 0; i < numbers.length; i++){

            if (numbers[i] > target){
                continue;
            }

            for (int k = i + 1; k < numbers.length; k++){
                int num1 = numbers[i];
                int num2 = numbers[k];
                if (num1 + num2 == target){
                    index1 = i + 1; //position of the number
                    index2 = k + 1;
                    break;
                }
            }
        }

        if (index1 > index2){
            int temp = index1;
            index1 = index2;
            index2 = index1;
        }

        int[] result = {index1, index2};
        return result;
    }
}
