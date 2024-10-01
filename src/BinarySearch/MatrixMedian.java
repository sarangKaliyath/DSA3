package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
Given a matrix of integers A of size N x M in which each row is sorted.
Find and return the overall median of matrix A.
NOTE: No extra memory is allowed.
NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.

Problem Constraints
1 <= N, M <= 10^5
1 <= N*M <= 10^6
1 <= A[i] <= 10^9
N*M is odd

Input Format
The first and only argument given is the integer matrix A.

Output Format
Return the overall median of matrix A.

Example Input

Input 1:
A = [   [1, 3, 5],
        [2, 6, 9],
        [3, 6, 9]   ]

Input 2:
A = [   [5, 17, 100]    ]

Example Output

Output 1: 5
Output 2: 17

Example Explanation

Explanation 1:
A = [1, 2, 3, 3, 5, 6, 6, 9, 9]
Median is 5. So, we return 5.

Explanation 2:
Median is 17.

 */
public class MatrixMedian {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(1, 3, 5)),
                new ArrayList<>(Arrays.asList(2, 6, 9)),
                new ArrayList<>(Arrays.asList(3, 6, 9))
        ));

        int res = findMedian(A);
        System.out.println(res);
        // Time O(30 * N * log M);
        // Space O(1);
    }

    public static int findMedian(ArrayList<ArrayList<Integer>> A) {

        int left = 0;
        int right = 0;

        int n = A.size();
        int m = A.get(0).size();

        int ans = -1;

        int req = ((n * m) / 2) + 1;

        for (ArrayList<Integer> row : A) {
            right = Math.max(right, row.get(m - 1));
        }

        while (left <= right) {

            int mid = left + ((right - left) / 2);

            int count = 0;

            for (ArrayList<Integer> row : A) {
                count += binarySearch(row, mid);
            }

            if (count >= req) {
                ans = mid;
                right = mid - 1;
            } else left = mid + 1;

        }

        return ans;
    }

    public static int binarySearch(ArrayList<Integer> A, int B) {

        int left = 0;
        int right = A.size() - 1;

        int ans = -1;

        while (left <= right) {

            int mid = left + ((right - left) / 2);

            if (A.get(mid) > B) {
                ans = mid;
                right = mid - 1;
            } else left = mid + 1;

        }

        if (ans == -1) return A.size();
        else return ans;
    }
}
