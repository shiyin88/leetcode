/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

Similar solution with 3Sum
    Still use one loop and inside the loop it has two pointers
DIFFERENCE:
    use closest to keep track of the current closest distance to target
    if Abs(sum - target) < last closest
        stores new closest distance to target
        store the sum of three numbers leading to the closest distance to target
    But we need to keep searching until we find the closest value
        if (closest <= target) left++ to add new left and make it closer to target
        if (closest > target) right-- to add new right and make it farther to target

**/
public class Solution {
    public int threeSumClosest(int[] num, int target) {
        if (num.length < 3 || num == null){
            return 0;
        }

        Arrays.sort(num); //need to sort the array first to better manipulate it

        int closest = Integer.MAX_VALUE;//reserve the minimum distance to target
        int result = 0;
        for (int i = 0; i < num.length - 2; i++){
            int left = i + 1;
            int right = num.length -1;
            while (left < right){
                int sum = num[i] + num[left] + num[right];
                if (Math.abs(sum - target) < closest){
                    closest = Math.abs(sum - target);
                    result = sum;//stores current the sum of the three integers.
                }
                //although we stored the result but we need to keep finding the closer distance from i to target
                if (sum <= target){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return result;
    }
}
