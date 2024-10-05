package BinarySearch;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
Problem Description
Farmer John has built a new long barn with N stalls.
Given an array of integers A of size N where each element of the array
represents the location of the stall and an integer B which represents the number of cows.
His cows don't like this barn layout and become aggressive towards each other once put into a stall.
To prevent the cows from hurting each other, John wants to assign the cows to the stalls,
such that the minimum distance between any two of them is as large as possible.
What is the largest minimum distance?

Problem Constraints
2 <= N <= 100000
0 <= A[i] <= 109
2 <= B <= N

Input Format
The first argument given is the integer array A.
The second argument given is the integer B.

Output Format
Return the largest minimum distance possible among the cows.

Example Input

Input 1:
A = [1, 2, 3, 4, 5]
B = 3

Input 2:
A = [1, 2]
B = 2

Example Output

Output 1: 2
Output 2: 1

Example Explanation

Explanation 1:
 John can assign the stalls at location 1, 3 and 5 to the 3 cows respectively. So the minimum distance will be 2.
Explanation 2:
 The minimum distance will be 1.

 */
public class AggressiveCows {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(5,17,100,11));
        int B = 2;
        Collections.sort(A);
        int res = findLargestMinDistance(A, B);
        System.out.println(res);
        // Time O(( Nlog(max(A) - min(A)) ) + NlogN); -> O(NlogN);
        // Space O(1);
    }

    public static int findLargestMinDistance(ArrayList<Integer> A, int totalCows) {

        int n = A.size();

        int left = 1;
        int right = A.get(n - 1) - A.get(0);
        int minLargestDistance = 0;

        while (left <= right) {

            int distanceInRange = left + ((right - left) >> 1);

            int totalCowsThatCanFit = findNoOfCows(A, distanceInRange);

            if (totalCowsThatCanFit >= totalCows) {
                minLargestDistance = distanceInRange;
                left = distanceInRange + 1;
            } else right = distanceInRange - 1;
        }

        return minLargestDistance;
    }

    public static int findNoOfCows(ArrayList<Integer> A, int minDistance) {

        int totalCows = 1;
        int lastPosition = A.get(0);

        for (int i = 1; i < A.size(); i++) {

            int stalls = A.get(i);

            if (stalls - lastPosition >= minDistance) {
                totalCows++;
                lastPosition = stalls;
            }

        }

        return totalCows;
    }
}

