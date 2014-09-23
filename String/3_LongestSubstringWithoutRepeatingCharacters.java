/**
*Given a string, find the length of the longest substring without repeating
*characters. For example, the longest substring without repeating letters for
*"abcabcbb" is "abc", which the length is 3. For "bbbbb" the
*longest substring is "b", with the length of 1.
*/
public class Solution {
    public static int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for (int i = 0; i < s.length(); i++){

            if (map.containsKey(s.charAt(i))){
                max = max > map.size() ? max : map.size();
                i = map.get(s.charAt(i));
                map.clear();

            }else{
                map.put(s.charAt(i), i);
            }
        }

        return map.size() > max ? map.size() : max;
    }
}
