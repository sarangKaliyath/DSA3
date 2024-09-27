package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
Given an array of integers A, find and return the peak element in it.
An array element is considered a peak if it is not smaller than its neighbors.
For corner elements, we need to consider only one neighbor.
NOTE:
    It is guaranteed that the array contains only a single peak element.
    Users are expected to solve this in O(log(N)) time. The array may contain duplicate elements.

Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 10^9

Input Format
The only argument given is the integer array A.

Output Format
Return the peak element.

Example Input

Input 1: A = [1, 2, 3, 4, 5]
Input 2: A = [5, 17, 100, 11]

Example Output

Output 1: 5
Output 2: 100

Example Explanation

Explanation 1: 5 is the peak.
Explanation 2: 100 is the peak.

 */
public class FindPeakElement {

    public  static void main (String [] args){

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(5, 17, 100, 11));

        int res = findPeak(A);
        System.out.println(res);

        // Time O(log N);
        // Space O(1);
    }

    public  static int findPeak (ArrayList<Integer> A){

        int n = A.size();

        int left = 0;
        int right = n;

        while (left <= right){

            int mid = left + ((right - left) / 2);

            if((mid == 0 || A.get(mid - 1) < A.get(mid)) && (mid == n - 1 || A.get(mid + 1) < A.get(mid))){
                return A.get(mid);
            }

            if(mid == 0 || A.get(mid - 1) < A.get(mid)){
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return A.get(left);
    }
}
