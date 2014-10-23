/**
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
这道题和I做法相似，但是I是建造一个pascal triangle，并且储存
这道题可以借鉴的时，当建造 i = rowIndex 的triangle的时候，我们可以建造 i = [0, rowIndex - 1]的triangle，
并且，声明两个变量，result 和 prevResult。 当curTriangle建造完成，在i++的时候，prevResult即为curTriangle，
然后再建造newTriangle放到result中
由此直到for loop结束

所以这里我们一直有两个ArrayList ： curResult 和 PrevResult
一次循环结束后，再把curResult赋值到PreResult，再次遍历
**/
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(1);

        for (int i = 0; i < rowIndex; i++){
            List<Integer> prevResult = result;//assign result to prevResult
            result = new ArrayList<Integer>();
            result.add(1);//in the initial point, when index = 0; the result needs to add 1
            /**elements in between [1, 1]**/
            for (int k = 0; k < prevResult.size() - 1; k++){
               result.add(prevResult.get(k) + prevResult.get(k + 1)); //loop prevResult
            }
            result.add(1);//in the last index, the result needs to add 1 as well
        }
        return result;
    }
}
