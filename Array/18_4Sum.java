/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)

Almost same with 3Sum
The only difference here is that we use two loops instead of three loops
Time Complexity: O(n^3);

The outer loop: i < length - 3
The inner loop: k < length - 2
    left = k + 1;
    right = length - 1;
    while(left < k){
        sum = num[left] + num[right]+ num[k] + num[i];
        compare:
            1) sum = target
                add value to the List and List<List>
            2) sum < target
            3) sum > target
    }
return List<List>
**/

public class Solution {
    public static List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (num == null || num.length < 4){
            return result;
        }

        Arrays.sort(num);
        for (int i = 0; i < num.length - 3; i++){
            if (i != 0 && num[i] == num[i - 1]){
                continue; //avoid duplicates
            }
            for (int k = i + 1; k < num.length - 2; k++){
                if (k != i + 1 && num[k] == num[k - 1]){
                    continue;
                }
               int left = k + 1;
               int right = num.length - 1;
               while(left < right){
            	   int sum = num[i] + num[k] + num[left] + num[right];
                   if (sum == target){
                       List<Integer> path = new ArrayList<Integer>();
                       path.add(num[i]);
                       path.add(num[k]);
                       path.add(num[left]);
                       path.add(num[right]);
                       result.add(path);
                       left++;
                       right--;
                       while(left < right && num[left] == num[left - 1]){//avoid duplicates
                           left++;
                       }
                       while(left < right && num[right] == num[right + 1]){
                           right--;
                       }
                   }else if(sum < target){
                       left++;
                   }else{
                       right--;
                   }
               }

            }
        }
        return result;
    }

}
