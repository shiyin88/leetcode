/**
 *Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].

Hide Tags Backtracking

考虑“去重”。先对数组进行排序，这样在DFS的时候，可以
1) 先判断前面的一个数是否和自己相等，相等的时候则前面的数必须使用了，自己才能使用，这样就不会产生重复的排列了。
    即 visited[i - 1] = 1 and visited[i] = 0;
2)或是当前数已经参观过了，我们就不用重复参观了
    即 visited[i] = 1
**/
public class Solution {
    public static List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        Arrays.sort(num);
        int[] visited = new int[num.length];
        if (num == null){
            return result;
        }
        helper(num, result, path, visited);
        return result;
    }

    public static void helper(int[] num, List<List<Integer>> result, List<Integer> path, int[] visited){
        if (path.size() == num.length){
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = 0; i < num.length; i++){
            if (visited[i] == 1 || (i != 0 && num[i] == num[i - 1] && visited[i - 1] == 1)){
               continue;
            }
            visited[i] = 1;
            path.add(num[i]);
            helper(num, result, path, visited);
            path.remove(path.size() - 1);
            visited[i] = 0;
        }
    }
}
