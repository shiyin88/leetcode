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
