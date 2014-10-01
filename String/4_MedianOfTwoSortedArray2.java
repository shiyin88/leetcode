public class Solution {
    public static double findMedianSortedArrays(int A[], int B[]) {

        int sizeA = A.length;
        int sizeB = B.length;
        if ((sizeA + sizeB) % 2 != 0){

            return findKthElement(A, 0, B, 0, (sizeA + sizeB) / 2 + 1);
            // here k represents the kth value not the index in the array

        }else{

            return ( findKthElement(A, 0, B, 0, (sizeA + sizeB) / 2)

                    + findKthElement(A, 0, B, 0, (sizeA + sizeB) / 2 + 1)) / 2.0;
                    //if the length of A and B is an even number, so we need to find both Ks and divide them to 2 to get the
                    //double return result
        }
    }

    private static double findKthElement(int A[], int start_A, int B[], int start_B, int k){

        if (start_A >= A.length) return B[start_B + k - 1];//if A has no more elements, just need to find the kth element in B

        if (start_B >= B.length) return A[start_A + k - 1];

        if (k == 1) return Math.min(A[start_A], B[start_B]);// base : finally we decrease k to 1 and get the result

        int key_A = start_A + k / 2 - 1 < A.length
                    ? A[start_A + k / 2 - 1]
                    : Integer.MAX_VALUE;
        int key_B = start_B + k / 2 - 1 < B.length
                    ? B[start_B + k / 2 - 1]
                    : Integer.MAX_VALUE;

        if (key_A < key_B){

            return findKthElement(A, start_A + k / 2, B, start_B, k - k / 2);

        }else{

            return findKthElement(A, start_A, B, start_B + k / 2, k - k / 2);
        }


    }

}
