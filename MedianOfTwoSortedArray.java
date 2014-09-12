/**from http://www.programcreek.com/2012/12/leetcode-median-of-two-sorted-arrays-java/
*There are two sorted arrays A and B of size m and n respectively.
*Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
*/
public class Solution {
    public static double findMedianSortedArrays(int A[], int B[]) {
        int sizeA = A.length;
        int sizeB = B.length;

        if ((sizeA + sizeB) % 2 != 0){

          return (double)findKth(A, B, (sizeA + sizeB)/2, 0, sizeA - 1, 0, sizeB - 1);

        }else{

          return (findKth(A, B, (sizeA + sizeB)/2 - 1, 0, sizeA - 1, 0, sizeB - 1)

            + findKth(A, B, (sizeA + sizeB)/2, 0, sizeA - 1, 0, sizeB - 1))*0.5;
        }

    }

    public static int findKth(int a[], int b[], int k, int aStart, int aEnd,

    int bStart, int bEnd){

      int alen = aEnd - aStart + 1;
      int blen = bEnd - bStart + 1;

      if (alen == 0) return b[bStart + k];
      if (blen == 0) return a[aStart + k];
      if (k == 0) return Math.min(a[aStart], b[bStart]);

      int aMid = alen*k / (alen + blen);
      int bMid = k - aMid - 1;
      //convert to be array index
      aMid = aMid + aStart;
      bMid = bMid + bStart;

      if (a[aMid] > b[bMid]){
        k = k - (bMid - bStart + 1);
        aEnd = aMid;
        bStart = bMid + 1;
      }else{
        k = k - (aMid - aStart + 1);
        bEnd = bMid;
        aStart = aMid + 1;
      }

      return findKth(a, b, k, aStart, aEnd, bStart, bEnd);
    }
}
