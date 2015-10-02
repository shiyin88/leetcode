/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.

Hide Tags Array Hash Table
Show Similar Problems
**/
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            //在以当前index为i时，得出Num[i]
            //如果map中已经有此key，说明已经存放过了相同value的值，但是index不同
            if (map.containsKey(nums[i])){
                //则通过map得出之前prev的index
                int j = map.get(nums[i]);
                //求证 difference between i and j is at most k.
                if (i - j <= k) {
                    return true;
                }
            }
            //把每个值和index都放入到map内，num[i]为值
            map.put(nums[i], i);
            
        }
        return false;
    }
}
