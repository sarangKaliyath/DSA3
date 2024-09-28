package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
Given a sorted array of integers A (0-indexed) of size N,
find the left most and the right most index of a given integer B in the array A.
Return an array of size 2, such that
          First element = Left most index of B in A
          Second element = Right most index of B in A.
If B is not found in A, return [-1, -1].
Note : Note: The time complexity of your algorithm must be O(log n).

Problem Constraints
1, <= N <= 10^6
1, <= A[i], B <= 10^9

Input Format
The first argument given is the integer array A.
The second argument given is the integer B.

Output Format
Return the left most and right most index (0-based) of B in A as a 2-element array.
If B is not found in A, return [-1, -1].

Example Input
Input 1:
 A = [5, 7, 7, 8, 8, 10]
 B = 8
Input 2:
 A = [5, 17, 100, 111]
 B = 3

Example Output
Output 1: [3, 4,]
Output 2: [-1, -1]

Example Explanation

Explanation 1:
 The first occurrence of 8 ,in A is at index 3.
 The last occurrence of 8 ,in A is at index 4,.
 ans = [3, 4,]

Explanation 2:
 There is no occurrence of 3, in the array.
 */
public class SearchForARange {

    public static void main(String[] args) {

//        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(5, 7, 7, 8, 8, 8, 8, 8, 9, 10));
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10));
        int B = 3;

        int firstIndex = findFirstOccurrence(A, B);
        System.out.println(firstIndex);

        int lastIndex = findLastOccurrence(A, B);
        System.out.println(lastIndex);

        // Time O(log N) + O(log N) = O(log N);
        // Space O(1);
    }

    public static int findFirstOccurrence(ArrayList<Integer> A, int B) {

        int n = A.size();

        int left = 0;
        int right = n - 1;

        while (left <= right) {

            int mid = left + ((right - left) / 2);

            if (mid == 0 && A.get(mid) == B) return mid;
            else if (mid == n - 1 && A.get(mid) == B && A.get(mid) != A.get(mid - 1)) return mid;
            else if (A.get(mid) == B && A.get(mid - 1) < B) return mid;

            if (A.get(mid) < B) left = mid + 1;
            else if (A.get(mid) >= B) right = mid - 1;
        }

        return -1;
    }

    public static int findLastOccurrence(ArrayList<Integer> A, int B) {

        int n = A.size();

        int left = 0;
        int right = n - 1;

        while (left <= right) {

            int mid = left + ((right - left) / 2);

            if (mid == n - 1 && A.get(mid) == B && A.get(mid - 1) < B) return mid;
            if (mid == 0 && A.get(mid) == B && A.get(mid + 1) > B) return mid;
            else if (A.get(mid) == B && A.get(mid + 1) > B) return mid;

            if (A.get(mid) <= B) left = mid + 1;
            else if (A.get(mid) > B) right = mid - 1;

        }

        return -1;
    }
}
