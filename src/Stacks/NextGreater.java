package Stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/*
Problem Description
Given an array A, find the next greater element G[i] for every element A[i] in the array.
The next greater element for an element A[i] is the first greater element on the right side of A[i] in the array, A.
More formally:
G[i] for an element A[i] = an element A[j] such that
    j is minimum possible AND
    j > i AND
    A[j] > A[i]
Elements for which no greater element exists, consider the next greater element as -1.

Problem Constraints
1 <= |A| <= 10^5
1 <= A[i] <= 10^7

Input Format
The first and the only argument of input contains the integer array, A.

Output Format
Return an integer array representing the next greater element for each index in A.

Example Input
Input 1: A = [4, 5, 2, 10]
Input 2: A = [3, 2, 1]

Example Output
Output 1: [5, 10, 10, -1]
Output 2: [-1, -1, -1]

Example Explanation

Explanation 1:
For 4, the next greater element towards its right is 5.
For 5 and 2, the next greater element towards their right is 10.
For 10, there is no next greater element towards its right.

Explanation 2:
As the array is in descending order, there is no next greater element for all the elements.
 */
public class NextGreater {

    public static void main (String [] args){

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(34,35,27,42,5,28,39,20,28));
        int n = A.size();

        bruteForce(A, n);
        // Time O(N^2);
        // Space O(1);

        optimized(A, n);
        // Time O(N);
        // Space O(1);
    }

    public static  void bruteForce(ArrayList<Integer> A, int n){

        ArrayList<Integer> res = new ArrayList<>(Collections.nCopies(n, -1));

        for(int i = 0; i < n; i++){

            for (int j = i + 1; j < n; j++){
                if(A.get(j) > A.get(i)) {
                    res.set(i, A.get(j));
                    break;
                }
            }

        }

        System.out.print(res);
        System.out.println();
    }

    public  static void optimized(ArrayList<Integer> A, int n){

        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>(Collections.nCopies(n, -1));

        for(int i = n-1; i >= 0; i--){

            while(!stack.isEmpty() && stack.peek() <= A.get(i)){
                stack.pop();
            }

            if(stack.isEmpty()) res.set(i, -1);
            else res.set(i,stack.peek());

            stack.push(A.get(i));
        }

        System.out.println(res);
    }
}
