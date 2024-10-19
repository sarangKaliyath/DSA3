package Queues;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

/*
Problem Description
Given an array A of both positive and negative integers.
Your task is to compute the sum of minimum and maximum elements of all sub-array of size B.
NOTE: Since the answer can be very large, you are required to return the sum modulo 10^9 + 7.

Problem Constraints
1 <= size of array A <= 10^5
-10^9 <= A[i] <= 10^9
1 <= B <= size of array

Input Format
The first argument denotes the integer array A.
The second argument denotes the value B

Output Format
Return an integer that denotes the required value.

Example Input:
Input 1:
 A = [2, 5, -1, 7, -3, -1, -2]
 B = 4
Input 2:
 A = [2, -1, 3]
 B = 2

Example Output:
Output 1: 18
Output 2: 3

Example Explanation:
Explanation 1:
 Sub-arrays of size 4 are :
    [2, 5, -1, 7],   min + max = -1 + 7 = 6
    [5, -1, 7, -3],  min + max = -3 + 7 = 4
    [-1, 7, -3, -1], min + max = -3 + 7 = 4
    [7, -3, -1, -2], min + max = -3 + 7 = 4
    Sum of all min & max = 6 + 4 + 4 + 4 = 18
Explanation 2:
 Sub-arrays of size 2 are :
    [2, -1],   min + max = -1 + 2 = 1
    [-1, 3],   min + max = -1 + 3 = 2
    Sum of all min & max = 1 + 2 = 3

Expected Output
Provide sample input and click run to see the correct output for the provided input.
Use this to improve your problem understanding and test edge cases

 */
public class SumOfMinAndMax {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2, 5, -1, 7, -3, -1, -2));
        int B = 4;

        int res = findMinMaxSum(A, B);
        System.out.println(res);
    }

    public static int findMinMaxSum(ArrayList<Integer> A, int B) {

        int MOD = (int) Math.pow(10, 9) + 7;
        long sum = 0;

        Deque<Integer> minQ = new ArrayDeque<>();
        Deque<Integer> maxQ = new ArrayDeque<>();

        for (int i = 0; i < B; i++) {
            enqueue(A, maxQ, i, 1);

            enqueue(A, minQ, i, 0);
        }

        if (!minQ.isEmpty() && !maxQ.isEmpty()) {
            sum = (sum + A.get(minQ.peekFirst()) + A.get(maxQ.peekFirst())) % MOD;
        }

        for (int i = B; i < A.size(); i++) {

            enqueue(A, maxQ, i, 1);

            if (!maxQ.isEmpty() && maxQ.peekFirst() == i - B) maxQ.pollFirst();

            enqueue(A, minQ, i, 0);

            if (!minQ.isEmpty() && minQ.peekFirst() == i - B) minQ.pollFirst();

            if (!minQ.isEmpty() && !maxQ.isEmpty()) {
                sum = (sum + A.get(minQ.peekFirst()) + A.get(maxQ.peekFirst())) % MOD;
            }
        }

        if(sum < 0) sum+= MOD;
        return (int) sum;
    }

    public static void enqueue(ArrayList<Integer> A, Deque<Integer> q, int i, int type) {
        while (!q.isEmpty() && compareValue(type, A.get(q.peekLast()), A.get(i))) {
            q.pollLast();
        }
        q.offerLast(i);
    }

    public static boolean compareValue(int type, int rear, int el) {
        return type == 1 ? rear <= el : rear >= el;
    }
}
