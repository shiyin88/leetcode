/**
Given an array of integers,
every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity.
Could you implement it without using extra memory?

*/

public class Solution {
    public int singleNumber(int[] A) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++){
          if (!map.containsKey(A[i])){
            map.put(A[i], 1);
          }else{
            if (map.get(A[i]) == 1){
              map.put(A[i], 2);
            }else{
              map.remove(A[i]);
            }

          }
        }
        int key = (Integer)map.keySet().toArray()[0];
        return key;
    }
}
