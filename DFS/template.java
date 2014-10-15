public class Solution {
    public void subsets(int[] num){

        ArrayList<Integer> result = new ArrayList<Integer>();
        Arrays.sort(num);
        subsetHelper(result, num, 0);
    }

    void subsetHelper(ArrayList<Integer> path, int[] num, int pos){
        outputToResult(path);

        for (int i = pos; i < num.length; i++){
            path.add(num[i]);
            subsetHelper(path, num, i + 1);
            path.remove(path.size() - 1);
        }
    }

}
