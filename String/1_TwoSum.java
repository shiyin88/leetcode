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

      int[] result = new int[2];

        for (int i = 0; i < numbers.length; i++){

            if (numbers[i] > target){
                continue;
            }

            for (int k = i + 1; k < numbers.length; k++){

                if (numbers[i] + numbers[k] == target){
                    result[0] = i + 1; //position of the number
                    result[1] = k + 1;//i < k so place i and k in order in the
                    //array to ensure value of index <value of index2
                    break;
                }
            }
        }

        return result;
    }
    /**
    *Use hashmap to downgrade the time complexity to 1
    *    Key stores the second number and value stores the index of the first number
    */
    public int[] twoSum2(int[] numbers, int target) {

      int[] result = new int[2];
      HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

      for (int i = 0; i < numbers.length; i++){
          if (map.containsKey(numbers[i])){//if the second number is the one found in the map after minus
            //from the first one
            result[0] = map.get(numbers[i]) + 1;
            result[1] = i + 1;
          }else{
            map.put(target - numbers[i], i); //store the target number, and the first index
          }

      }

      return result;
    }
}
