/**
*Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
*
*For example, given
*s = "leetcode",
*dict = ["leet", "code"].
*
*Return true because "leetcode" can be segmented as "leet code".
*/
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] table = new boolean[s.length() + 1];
        table[0] = true;

        for (int i = 0; i < s.length(); i++){
            /**
            如果table[i] == false 证明从0到i之间没有发现有单词给填满，所以我们先
            要填满之前的单词。只有在i = true的情况下继续找单词**/
            if (!table[i]) continue;

            for (String str: dict){
                int leng = str.length();//单词的长度
                int end = i + leng;//end包括之前已找到的单词 + 现单词的长度
                //如加完现单词导致长度大于String s的长度，要continue
                if (end > s.length()) continue;//adding new word cause the length > String s.length()
                //如果已经遍历到end，切已经有单词分割，使index = end为true了，就无需要遍历，继续查找下一个
                if (table[end]) continue;//indicates already having word with length = end found
                //如果s的substring的单词是str 则是true
                if (s.substring(i, end).equals(str)){
                    table[end] = true;
                }
            }
        }

        return table[s.length()];//最终返回目标是table的最后一个index的是否为true
    }

}
