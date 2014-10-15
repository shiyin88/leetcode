/**
Given a string s, partition s such that every substring of the partition is a palindrome.
Return all possible palindrome partitioning of s.
For example, given s = "aab",
Return
  [
    ["aa","b"],
    ["a","a","b"]
  ]
  Solution:
 * We use s.substring(position, i + 1) to get prefix. then recurse s!
 * At first, every partition will be one char. After that, i++, interval will be 2, 3, 4 ...
 * First time use position as termination condition.
 */
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> path = new ArrayList<String>();

        if (s == null || s.length() == 0) return null;

        helper(s, result, path, 0);
        return result;
    }

    public void helper(String s, List<List<String>> result, List<String> path, int pos){
        if (pos == s.length()){
            result.add(new ArrayList<String>(path));
            return;
        }

        for (int i = pos; i < s.length(); i++){
            //get the substring of s 处理字符的DFS题都要用到substring来获取字符
            String prefix = s.substring(pos, i + 1);
            //instead of getting the char at index i, we want to get the partition
            //from pos to i
            //if prefix is not a palindrome we continue; otherwise add it to list
            if (!isPalindrome(prefix)){
                continue;
            }
            path.add(prefix);
            helper(s, result, path, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public boolean isPalindrome(String prefix){
        int start = 0;
        int end = prefix.length() - 1;
        while (start < end){
            if (prefix.charAt(start) != prefix.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


}
