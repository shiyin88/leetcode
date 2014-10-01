public class Solution {
    public static ArrayList<ArrayList<Integer>> subsetsWithDup (int[] num) {

			Arrays.sort(num);
			ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> list = new ArrayList<Integer>();

			subsetsWithDupHelper(result, list, num, 0);

			return result;
		}


		private static void subsetsWithDupHelper(ArrayList<ArrayList<Integer>> result,
				ArrayList<Integer> list, int[] num, int position) {
			result.add(new ArrayList<Integer>(list));
	 //只在回溯的时候比较i 和 i-1的值。ex 回溯到i=2， 必然i=2下面有i=3，i=4. 2即为position
   //为回溯到2的时候 的起点。当i++ 到 3 或是 4的时候，需要和起点position = 2 来比较，如果
   //值相同，即continue
			for (int i = position; i < num.length; i++) {
				if (i != position && num[i] == num[i-1]){
					continue;
				}

				list.add(num[i]);
				subsetsWithDupHelper(result, list, num, i+1);
				list.remove(list.size() - 1);
			}
		}
}
