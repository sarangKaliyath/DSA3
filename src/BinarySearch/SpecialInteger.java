package BinarySearch;

import java.util.*;

/*
Problem Description
Given an array of integers A and an integer B,
find and return the maximum value K such that
there is no sub-array in A of size K with the sum of elements greater than B.

Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 10^9
1 <= B <= 10^9

Input Format
The first argument given is the integer array A.
The second argument given is integer B.

Output Format
Return the maximum value of K (sub array length).

Example Input

Input 1:
A = [1, 2, 3, 4, 5]
B = 10

Input 2:
A = [5, 17, 100, 11]
B = 130

Example Output

Output 1: 2
Output 2: 3

Example Explanation

Explanation 1:
For K = 5, There are subarrays [1, 2, 3, 4, 5] which has a sum > B
For K = 4, There are subarrays [1, 2, 3, 4], [2, 3, 4, 5] which has a sum > B
For K = 3, There is a subarray [3, 4, 5] which has a sum > B
For K = 2, There were no subarray which has a sum > B.
Constraints are satisfied for maximal value of 2.

Explanation 2:
For K = 4, There are subarrays [5, 17, 100, 11] which has a sum > B
For K = 3, There were no subarray which has a sum > B.
Constraints are satisfied for maximal value of 3.

 */
public class SpecialInteger {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(5, 17, 100, 11));
        int B = 130;

        int res = findSubArrayLength(A, B);
        System.out.println(res);
        // Time O(NlogN);
        // Space O(1);
    }


    public static int findSubArrayLength(ArrayList<Integer> A, int maxSubArraySum) {

        int smallestSubArray = 1;
        int largestSubArray = A.size();

        int res = 0;

        while (smallestSubArray <= largestSubArray) {

            int medianSubArrayLength = smallestSubArray + ((largestSubArray - smallestSubArray) >> 1);

            if (isSubArraySumLessThanK(A, maxSubArraySum, medianSubArrayLength)) {
                res = medianSubArrayLength;
                smallestSubArray = medianSubArrayLength + 1;
            } else largestSubArray = medianSubArrayLength - 1;
        }
        return res;
    }

    public static boolean isSubArraySumLessThanK(ArrayList<Integer> A, int maxSubArraySum, int K) {

        long windowSum = 0;

        if (K > A.size()) return false;

        for (int i = 0; i < K; i++) windowSum += A.get(i);

        if (windowSum > maxSubArraySum) return false;

        for (int i = K; i < A.size(); i++) {
            windowSum = windowSum - A.get(i - K) + A.get(i);
            if (windowSum > maxSubArraySum) return false;
        }

        return true;
    }
}
