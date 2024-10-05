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

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(5, 17, 100, 11));
        int B = 2;
        Collections.sort(A);
        int res = findLargestMinimumDistance(A, B);
        System.out.println(res);
        // Time O(( Nlog(max(A) - min(A)) ) + NlogN); -> O(NlogN);
        // Space O(1);
    }

    public static int findLargestMinimumDistance(ArrayList<Integer> A, int noOfCows) {

        Collections.sort(A);

        int minDistance = 1;
        int maxDistance = A.get(A.size() - 1) - A.get(0);

        int largestPossibleDistance = 0;

        while (minDistance <= maxDistance) {

            int medianDistance = minDistance + ((maxDistance - minDistance) >> 1);

            int cowsThatCanFitWithMedianDistance = findNoOfCowsThatCanFit(A, medianDistance);

            if (cowsThatCanFitWithMedianDistance >= noOfCows) {
                largestPossibleDistance = medianDistance;
                minDistance = medianDistance + 1;
            } else maxDistance = medianDistance - 1;
        }

        return largestPossibleDistance;
    }

    public static int findNoOfCowsThatCanFit(ArrayList<Integer> A, int minDistance) {

        int noOfCows = 1;
        int lastStallWhereCowWasPlaced = A.get(0);

        for (int stall = 1; stall < A.size(); stall++) {

            int currentStall = A.get(stall);

            int distanceBetweenStalls = currentStall - lastStallWhereCowWasPlaced;

            if (distanceBetweenStalls >= minDistance) {
                noOfCows++;
                lastStallWhereCowWasPlaced = currentStall;
            }

        }

        return noOfCows;
    }
}

