package Queues;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/*
Problem Description
Given an integer, A. Find and Return first positive A integers in ascending order containing only digits 1, 2, and 3.
NOTE: All the A integers will fit in 32-bit integers.

Problem Constraints
1 <= A <= 29500

Input Format
The only argument given is integer A.

Output Format
Return an integer array denoting the first positive A integers in ascending order containing only digits 1, 2 and 3.

Example Input:
Input 1: A = 3
Input 2: A = 7

Example Output
Output 1: [1, 2, 3]
Output 2: [1, 2, 3, 11, 12, 13, 21]

Example Explanation:
Explanation 1:
 Output denotes the first 3 integers that contains only digits 1, 2 and 3.
Explanation 2:
 Output denotes the first 7 integers that contains only digits 1, 2 and 3.
 */
public class NIntegersContainingOnlyOneTwoAndThree {

    public  static void main (String [] args){

        int A = 7;
        ArrayList<Integer> res = findFirstPositiveNIntegers(A);
        System.out.println(res);
        // Time O(A);
        // Space O(A);
    }

    public static ArrayList<Integer> findFirstPositiveNIntegers(int A){

        ArrayList<Integer> res = new ArrayList<>();
        Deque<Integer> q = new ArrayDeque<>();

        q.offerLast(1);
        q.offerLast(2);
        q.offerLast(3);

        while(res.size() < A){

            int firstEl = q.pollFirst();
            res.add(firstEl);

            q.offerLast(firstEl * 10 + 1);
            q.offerLast(firstEl * 10 + 2);
            q.offerLast(firstEl * 10 + 3);
        }
        return res;
    }
}
