package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
Given a sorted array of integers A of size N and an integer B,
where array A is rotated at some pivot unknown beforehand.
For example, the array [0, 1, 2, 4, 5, 6, 7] might become [4, 5, 6, 7, 0, 1, 2].
Your task is to search for the target value B in the array. If found, return its index; otherwise, return -1.
You can assume that no duplicates exist in the array.
NOTE: You are expected to solve this problem with a time complexity of O(log(N)).

Problem Constraints
1 <= N <= 1000000
1 <= A[i] <= 10^9
All elements in A are Distinct.

Input Format
The First argument given is the integer array A.
The Second argument given is the integer B.

Output Format
Return index of B in array A, otherwise return -1

Example Input

Input 1:
A = [4, 5, 6, 7, 0, 1, 2, 3]
B = 4

Input 2:
A : [ 9, 10, 3, 5, 6, 8 ]
B : 5

Example Output

Output 1: 0
Output 2: 3

Example Explanation

Explanation 1:
Target 4 is found at index 0 in A.

Explanation 2:
Target 5 is found at index 3 in A.

 */
public class RotatedSortedArraySearch {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(101, 103, 106, 109, 158, 164, 182, 187, 202, 205, 2, 3, 32, 57, 69, 74, 81, 99, 100));
        int B = 202;

        initialApproach(A, B);
        // Time O(log N);
        // Space O(1);

        int res = optimized(A, B);
        System.out.println(res);
        // Time O(log N);
        // Space O(1);

    }

    public  static int optimized (ArrayList<Integer> A, int B){

        int left = 0;
        int right = A.size() - 1;

        if(A.get(left) < A.get(right)){

           return findB(A, B, left, right);

        }
        else {
            while (left <= right) {

                int mid = left + ((right - left) / 2);

                if (A.get(mid) == B) return mid;

                if (B < A.get(0)) {
                    if (A.get(mid) < A.get(0)) {
                        if (A.get(mid) < B) left = mid + 1;
                        else right = mid - 1;
                    } else left = mid + 1;
                } else {
                    if (A.get(mid) > A.get(0)) {
                        if (A.get(mid) < B) left = mid + 1;
                        else right = mid - 1;
                    } else right = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void initialApproach(ArrayList<Integer> A, int B) {

        int res = findSmallestElement(A, B);

        int ans = -1;

        ans = findB(A, B, 0, res);

        if (ans == -1) {
            ans = findB(A, B, res, A.size() - 1);
        }

        System.out.println(ans);
    }

    public static int findSmallestElement(ArrayList<Integer> A, int B) {

        int left = 0;
        int right = A.size() - 1;

        while (left <= right) {

            int mid = left + ((right - left) / 2);

            if (mid != 0 && A.get(mid) < A.get(mid - 1)) return mid;

            if (A.get(mid) < A.get(0)) right = mid - 1;
            else left = mid + 1;

        }
        return A.get(0);
    }

    public static int findB(ArrayList<Integer> A, int B, int left, int right) {
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (A.get(mid) == B) return mid;
            else if (A.get(mid) < B) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
