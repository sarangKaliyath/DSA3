package Stacks;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*
Problem Description
Given a stack of integers A, sort it using another stack.
Return the array of integers after sorting the stack using another stack.

Problem Constraints
1 <= |A| <= 5000
0 <= A[i] <= 10^9

Input Format
The only argument is a stack given as an integer array A.

Output Format
Return the array of integers after sorting the stack using another stack.

Example Input
Input 1: A = [5, 4, 3, 2, 1]
Input 2: A = [5, 17, 100, 11]

Example Output:
Output 1: [1, 2, 3, 4, 5]
Output 2: [5, 11, 17, 100]

Example Explanation:
Explanation 1:
 Just sort the given numbers.
Explanation 2:
 Just sort the given numbers.

 */
public class SortStackUsingAnotherStack {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(5, 4, 3, 3, 2, 1));

        Stack<Integer> temp = new Stack<>();

        int n = A.size();

        while (!A.isEmpty()) {
            int x = A.remove(A.size() - 1);

            while (!temp.isEmpty() && temp.peek() > x) {
                int y = temp.pop();
                A.add(y);
            }
            temp.push(x);
        }

        for(int i = 0; i < n; i++){
            A.add(0);
        }

        while(!temp.isEmpty()){
            int val = temp.pop();
            A.set(n - 1, val);
            n--;
        }

        System.out.print(A);
        // Time O(N^2);
        // Space O(N);
    }
}
