

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result= new ArrayList<List<Integer>>();
        
        for (int i = 0; i < nums.length - 2; i++){
            int start = i + 1;
            int end = nums.length - 1;
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            while(start < end){
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == 0) {
                    List<Integer> path = new ArrayList<Integer>();
                    path.add(nums[i]);
                    path.add(nums[start]);
                    path.add(nums[end]);
                    result.add(path);
                    start++;
                    end--;
                    while (start < end && nums[start] == nums[start - 1]){
                        start++;
                    }
                    while(start < end && nums[end] == nums[end + 1]) {
                        end--;
                    }
                }else if (sum > 0) {
                    end--;
                }else{
                    start++;
                }
                
            }
            
        }
        return result;
    }
}
