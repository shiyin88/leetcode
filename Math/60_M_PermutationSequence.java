/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.

Hide Tags Backtracking Math

每次当第一个数字确定时，余下的为(n - 1)!种情况。 我们要求第k个，由于k是从1-k算起，
然后在list中是从0开始，实际上，我们是从k - 1开始。

k / (n - 1) ! 确定了数字所在的index
随后，我们要update k 和 （n - 1) ! 以及remove indx
update K ： k = k % factorial （在除去index的情况下）
factorial ： （n - 2)!

**/
public class Solution {
    public String getPermutation(int n, int k) {
        String result = "";
        int factorial = 1;
        for (int i = 1; i <= n; i++){
            factorial *= i;
        }
        k--;//update k to get current index

        ArrayList<Integer> number = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++){
            number.add(i);
        }

        for (int i = 0; i < n; i++){
            factorial = factorial / (n - i); //there are factorial / (n - i) ways to form numbers while the first digit is i
            int index = k / factorial;//get the selected index for the current digit
            result += number.get(k / factorial);
            k = k % factorial;//update k
            number.remove(index);//remove the digit from list
        }
        return result;
    }
}
