/**
 *
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
 * http://tech-wonderland.net/blog/summary-of-ksum-problems.html
 fix one side with loop
    in the loop use two pointers: left starts at i + 1, and right starts at length - 1
    sum up three numbers together
      while (left < right){
          compare with target
          then pointer at left++ and right--
          Repeat the loop until i = length -3
    }    

 * */
public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (num.length < 3 || num == null){
            return result;
        }

        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++){//i < num.length - 2 to leave two indexes for another two pointers
            //at i - 1 we already moved so here we CONTINUE to avoid repetitive move
            if (i != 0 && num[i] == num[i - 1]){
                continue;
            }
            int left = i + 1;
            int right = num.length - 1;
            while (left < right){
                int sum = num[i] + num[left] + num[right];
                if (sum == 0){
                    List<Integer> path = new ArrayList<Integer>();
                    path.add(num[i]);
                    path.add(num[left]);
                    path.add(num[right]);
                    result.add(path);

                    left++;
                    right--;
                    //if num[left] == num[left - 1] at i = left - 1 we already moved here at i = left we don't need to
                    //repeat the action, so that avoid repetition
                    while(left < right && num[left] == num[left - 1]){
                        left++;
                    }

                    while (left < right && num[right] == num[right + 1]){
                        right--;
                    }
                }else if(sum < 0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return result;
    }
}
