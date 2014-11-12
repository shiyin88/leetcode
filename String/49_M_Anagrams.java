/**
Anagrams Total Accepted: 19305 Total Submissions: 80882 My Submissions Question Solution
Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.

Hide Tags Hash Table String

 * 1. 通过toCharArray把String转换成char数组
 * 2. sort char数组， 作为map的key
 * 3. 在map中，如果存在key，则放入，否则则新建一个
 * 4. 通过map.values().iterator()来得到所有values的collection
 * 5. 如果当前的value的arrayList size 大于1，则把当前所有arrayList中的值加入到result中
 **/
public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<String>();
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        /**
         * 1. convert the string to charArray, and sort it.
         * 2. Create a hashmap, if the map contains the key, put it to the list.
         *    Otherwise, create a list, and add it to the list
         * */
        for (int i = 0; i < strs.length; i++){
            char[] word = strs[i].toCharArray();
            Arrays.sort(word);
            String key = new String(word);
            if (map.containsKey(key)){
                map.get(key).add(strs[i]);
            }else{
                ArrayList<String> anagram = new ArrayList<String>();
                anagram.add(strs[i]);
                map.put(key, anagram);
            }
        }
        //values() : Returns a Collection view of the values contained in this map.
        /**
         * iterate over every value (the type of data stored is ArrayList<String>) in the map
         * and save the values while the arraylist size is greater than 1 **/
        Iterator<ArrayList<String>> iterator = map.values().iterator();
        while(iterator.hasNext()){
            List<String> str = (ArrayList<String>)iterator.next();
            if (str.size() > 1){
                result.addAll(str);
            }
        }
        return result;
    }
}
