package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
Problem Description
Given an integer array A of size N.
If we store the sum of each triplet of the array A in a new list,
then find the Bth smallest element among the list.
NOTE: A triplet consists of three elements from the array.
Let's say if A[i], A[j], A[k] are the elements of the triplet then i < j < k.

Problem Constraints
3 <= N <= 500
1 <= A[i] <= 10^8
1 <= B <= (N*(N-1)*(N-2))/6

Input Format
The first argument is an integer array A.
The second argument is an integer B.

Output Format
Return an integer denoting the Bth element of the list.

Example Input

Input 1:
 A = [2, 4, 3, 2]
 B = 3

Input 2:
 A = [1, 5, 7, 3, 2]
 B = 9

Example Output

Output 1: 9
Output 2: 14

Example Explanation

Explanation 1:
All the triplets of the array A are:

 (2, 4, 3) = 9
 (2, 4, 2) = 8
 (2, 3, 2) = 7
 (4, 3, 2) = 9

So the 3rd smallest element is 9.

 */
public class FindSmallestAgain {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 5, 7, 3, 2));
        int B = 9;

        bruteForce(A, A.size(), B);
        // Time O(N^3 log N^3);
        // Space O(B) -> Gives OUT OF MEMORY ERROR FOR LARGE VALUES;

        optimized(A, B);
    }

    public static void bruteForce(ArrayList<Integer> A, int n, int B) {

        ArrayList<Integer> resSum = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                for (int k = j + 1; k < n; k++) {

                    int sum = A.get(i) + A.get(j) + A.get(k);

                    resSum.add(sum);

                }

            }

        }

        Collections.sort(resSum);

        System.out.println(resSum.get(B - 1));

    }

    public static void optimized(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int n = A.size();

        int left = 1;
        int right = A.get(n - 1) + A.get(n - 2) + A.get(n - 3);
        int ans = 0;

        while (left <= right) {

            int mid = left + ((right - left) / 2);

            if (check(A, n, B, mid)) {
                ans = mid;
                right = mid - 1;
            } else left = mid + 1;

        }

        System.out.println(ans);

    }

    public static boolean check(ArrayList<Integer> A, int n, int B, int mid) {

        int count = 0;

        for (int i = 0; i < n; i++) {

            int left = i + 1;
            int right = n - 1;

            while (left < right) {

                if (A.get(i) + A.get(left) + A.get(right) <= mid) {
                    count += right - left;
                    left++;
                } else right--;
            }

        }

        return count >= B;
    }
}
