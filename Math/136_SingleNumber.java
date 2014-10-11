/**
*
Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity.
Could you implement it without using extra memory?
*/

//use XOR. 思路就是每位bit出现2次就清零，所以可以不断异或运算得出最终结
public static int singleNumber(int[] A) {

		int bit = 0;
		for (int x : A){

				bit ^= x;
		}
		return bit;
}

public static int singleNumber(int[] A) {
	        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	        for (int i = 0; i < A.length; i++){
	        	if (!map.containsKey(A[i])){
	        		map.put(A[i], 1);
	        	}else{
	        		map.remove(A[i]);
	        	}
	        }
	        int key = (Integer)map.keySet().toArray()[0];
	        return key;
}
