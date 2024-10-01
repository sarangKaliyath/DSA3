package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
Given an integer A. Compute and return the square root of A.
If A is not a perfect square, return floor(sqrt(A)).
NOTE:
   The value of A*A can cross the range of Integer.
   Do not use the sqrt function from the standard library.
   Users are expected to solve this in O(log(A)) time.

Problem Constraints
0 <= A <= 10^9

Input Format
The first and only argument given is the integer A.

Output Format
Return floor(sqrt(A))

Example Input

Input 1: 11
Input 2: 9

Example Output

Output 1: 3
Output 2: 3



Example Explanation

Explanation 1:
When A = 11 , square root of A = 3.316. It is not a perfect square so we return the floor which is 3.
Explanation 2:
When A = 9 which is a perfect square of 3, so we return 3.

 */
public class SquareRootOfInteger {
    public static void main(String[] args) {
        int A = 2147483647;
        int res = (int) binarySearch(A);
        System.out.println(res);
        // Time O(lon N);
        // Space O(1);
    }

    public static long binarySearch(int A) {
        long left = 0;
        long right = A;

        while (left <= right) {

            long mid = left + ((right - left) / 2);
            long prod = mid * mid;

            if (prod == A) return mid;

            else if (prod < A) left = mid + 1;

            else right = mid - 1;
        }

        return left - 1;
    }
}
