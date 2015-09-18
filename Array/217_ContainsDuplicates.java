/**Given an array of integers, find if the array contains any duplicates. 
 * Your function should return true if any value appears at least twice in the array, 
 * and it should return false if every element is distinct.
 * set 只能容纳不重复数列。
 * 比较，如果set里面没有此integer，则放进去
 * 用set.contain来判断，如果有此integer，则表明有重复
 * 数，则返回true
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null) return true;
        
        Set<Integer> set = new HashSet<Integer>();
        for (int i : nums){
            if (set.contains(i)){
                return true;
            }
            set.add(i);
        }
        return false;
    }
}
