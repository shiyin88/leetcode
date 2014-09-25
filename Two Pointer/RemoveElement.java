/**
Analysis:
Idea is to use double pointer (i and j )
i scans all the elements in the array and j only passes not elem and
stores the final result. e.g.

A = 1 2 3 4 5 3 6 7;
i j are set to start position.
i goes from 1 to 7, if this element is not the element requested,A[j]=A[i]
(no change at start because i and j are same.), then i ++, j++, otherwise, i++, means to skip this element,but j stays, from next element, continue the above step, when set A[j]=A[i], which means A[j] was originally stored the removed element but now stores the next one.
A = 1 2 3 4 5 3 6 7,  elem=3
       i   i  i
       j   j  j

then
A = 1 2 3 4 5 3 6 7
        i i      i
        j j  j

and A = 1 2 4 4 5 3 6 7
                          i
                      j
finally, A= 1 2 4 5 6 7
*/
public class Solution {
    public int removeElement(int[] A, int elem) {
        int i = 0;//pointer loop the array from start to end
        int j = 0;//matches the index of elements after removel
        //if find elem, then move the latter elements forward
        while (i < A.length){
            if (A[i] != elem){
                A[j] = A[i];
                j++;
            }
            i++;
        }
        return j;
    }
}
