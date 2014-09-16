/**
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
*/
public class Solution {
    public static int romanToInt(String s) {
	        String symbol[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
	        int value[] =     {1000,900,500,400, 100, 90, 50,  40, 10,   9,  5,  4,  1};
	        Map<Character, Integer> map = new HashMap<Character, Integer>();
	        map.put('M', 1000);
	        map.put('D', 500);
	        map.put('C', 100);
	        map.put('L', 50);
	        map.put('X', 10);
	        map.put('V', 5);
	        map.put('I', 1);

	        int result = 0;
	        int i = 1;
	        int pre, nex, cur;
	        for (i = 1; i < s.length(); i++){
	        	 pre = map.get(s.charAt(i - 1));
	        	 cur = map.get(s.charAt(i));
	        	 //nex = map.get(s.charAt(i + 1));
	        	 if (cur <= pre){
	                 result += pre;
	             }else{
	                 result += (cur - pre);
	                 i = i + 1;
	             }

	        }
	        if (i == s.length()){
	        	result += map.get(s.charAt(i - 1));
	        }
	        return result;
	    }
}
