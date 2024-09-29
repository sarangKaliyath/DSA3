package findLowerBound;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
Problem Description
You are given a 2-D matrix C of size A × B.
You need to build a new 1-D array of size A by taking one element
from each row of the 2-D matrix in such a way that the cost of the newly built array is minimized.
The cost of an array is the minimum possible value of the absolute difference between any two adjacent elements of the array.
So if the newly built array is X, the element picked from row 1 will become X[1],
element picked from row 2 will become X[2], and so on.
Determine the minimum cost of the newly built array.

Problem Constraints
2 <= A <= 1000
2 <= B <= 1000
1 <= C[i][j] <= 10^6

Input Format
The first argument is an integer A denoting number of rows in the 2-D array.
The second argument is an integer B denoting number of columns in the 2-D array.
The third argument is a 2-D array C of size A x B.

Output Format
Return an integer denoting the minimum cost of the newly build array.

Example Input

Input 1:
 A = 2
 B = 2
 C = [ [8, 4]
      [6, 8] ]

Input 2:
 A = 3
 B = 2
 C = [ [7, 3]
       [2, 1]
       [4, 9] ]

Example Output
Output 1: 0
Output 2: 1

Example Explanation

Explanation 1:
 Newly build array : [8, 8]. The minimum cost will be 0 since the absolute difference will be 0(8-8).
Explanation 2:
 Newly build array : [3, 2, 4]. The minimum cost will be 1 since the minimum absolute difference will be 1(3 - 2).

 */
public class MinimumDifference {

    public static void main(String[] args) {

        int A = 2;
        int B = 2;
        ArrayList<ArrayList<Integer>> C = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(1, 2)),
                new ArrayList<>(Arrays.asList(3, 2))
        ));

        for (int i = 0; i < A; i++) {
            Collections.sort(C.get(i));
        }

        int res = findMinCost(C, A, B);
        System.out.println(res);
    }


    public static int findMinCost(ArrayList<ArrayList<Integer>> C, int n, int m) {

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n - 1; i += 2) {

            for (int j = 0; j < m; j++) {

                int num = C.get(i).get(j);

                int lowerBound = findLowerBound(C.get(i + 1), m, num);
                int upperBound = findUpperBound(C.get(i + 1), m, num);

                int absLow = Math.abs(num - lowerBound);
                int absUpper = Math.abs(num - upperBound);

                ans = Math.min(ans, Math.min(absLow, absUpper));

            }

        }

        return ans;

    }

    public static int findLowerBound(ArrayList<Integer> A, int n, int B) {

        int left = 0;
        int right = n - 1;
        int ans = -1;

        while (left <= right) {

            int mid = left + ((right - left) / 2);

            if (A.get(mid) == B) return A.get(mid);

            else if (A.get(mid) < B) {
                ans = A.get(mid);
                left = mid + 1;
            } else right = mid - 1;

        }

        return ans;

    }

    public static int findUpperBound(ArrayList<Integer> A, int n, int B) {

        int left = 0;
        int right = n - 1;

        int ans = -1;

        while (left <= right) {

            int mid = left + ((right - left) / 2);

            if (A.get(mid) == B) return A.get(mid);

            else if (A.get(mid) < B) left = mid + 1;

            else {
                ans = A.get(mid);
                right = mid - 1;
            }

        }

        return ans;

    }
}
