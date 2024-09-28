package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
Given a sorted array of integers A where every element appears twice except for one element which appears once,
find and return this single element that appears only once.
Elements which are appearing twice are adjacent to each other.
NOTE: Users are expected to solve this in O(log(N)) time.

Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 10^9

Input Format
The only argument given is the integer array A.

Output Format
Return the single element that appears only once.

Example Input
Input 1: A = [1, 1, 7]
Input 2: A = [2, 3, 3]

Example Output
Output 1: 7
Output 2: 2

Example Explanation
Explanation 1: 7 appears once
Explanation 2: 2 appears once

 */
public class SingleElementInSortedArray {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(13, 13, 21, 21, 27, 50, 50, 102, 102, 108, 108, 110, 110, 117, 117, 120, 120, 123, 123, 124, 124, 132, 132, 164, 164, 166, 166, 190, 190, 200, 200, 212, 212, 217, 217, 225, 225, 238, 238, 261, 261, 276, 276, 347, 347, 348, 348, 386, 386, 394, 394, 405, 405, 426, 426, 435, 435, 474, 474, 493, 493));

        int res = findUnique(A, A.size());
        System.out.println(res);
        // Time O(log N);
        // Space O(1);

        int ans = better(A,A.size());
        System.out.println(ans);
        // Time O(log N);
        // Space O(1);
    }

    public static int findUnique(ArrayList<Integer> A, int n) {

        int left = 0;
        int right = n - 1;

        while (left <= right) {

            int mid = left + ((right - left) / 2);

            if ((mid == 0 || !A.get(mid).equals(A.get(mid - 1))) && ((mid == n - 1) || !A.get(mid).equals(A.get(mid + 1)) )) {
                return A.get(mid);
            }


            if(mid != 0 && A.get(mid).equals(A.get(mid - 1))) {
                if((mid & 1) == 0) right = mid - 1;
                else left = mid + 1;
            }
            else {
                if((mid & 1) == 0) left = mid + 1;
                else right = mid - 1;
            }

        }

        return A.get(left);
    }

    public  static int better (ArrayList<Integer> A, int n){

        int left = 0;
        int right = n - 1;

        while (left < right){

            int mid = left + ((right - left) / 2);

            if((mid & 1) == 1) mid--;

            if(A.get(mid).equals(A.get(mid + 1))){
                left = mid + 2;
            }
            else right = mid;

        }

        return A.get(left);

    }
}
