/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].

Hide Tags Dynamic Programming Backtracking
http://blog.csdn.net/linhuanmars/article/details/22452163
用了dfs但是会超时
只有先用wordBreakI检查一下，再用wordbreakII才可以
**/
public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> result = new ArrayList<String>();
        List<String> path = new ArrayList<String>();
        if (s == null || s.length() == 0){
            return result;
        }
        if (wordBreakI(s,dict)){
            helper(s, dict, result, path, 0);
        }
        return result;
    }
    //wordBreakI
    public boolean wordBreakI(String s, Set<String> dict) {
        if(s==null || s.length()==0)
            return true;
        boolean[] res = new boolean[s.length()+1];
        res[0] = true;
        for(int i=0;i<s.length();i++)
        {
            StringBuilder str = new StringBuilder(s.substring(0,i+1));
            for(int j=0;j<=i;j++)
            {
                if(res[j] && dict.contains(str.toString()))
                {
                    res[i+1] = true;
                    break;
                }
                str.deleteCharAt(0);
            }
        }
        return res[s.length()];
    }
    //wordBreakII
    public void helper(String s, Set<String> dict, List<String> result, List<String> path, int start){
        if (start == s.length()){
            String word = "";
            for (String str : path){
                word += str + " ";
            }
            result.add(word.substring(0, word.length() - 1));
            return;
        }

        for (String str : dict){
            int end = start + str.length();
            if (end > s.length()){
                continue;
            }
            if (s.substring(start, end).equals(str)){
                path.add(str);
                helper(s, dict, result, path, end);
                path.remove(path.size() - 1);
            }
        }
    }
}
