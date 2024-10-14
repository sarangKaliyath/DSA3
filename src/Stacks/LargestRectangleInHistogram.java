package Stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*
Problem Description
Given an array of integers A.
A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.
Find the area of the largest rectangle formed by the histogram.

Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 10000

Input Format
The only argument given is the integer array A.

Output Format
Return the area of the largest rectangle in the histogram.

Example Input
Input 1: A = [2, 1, 5, 6, 2, 3]
Input 2: A = [2]

Example Output
Output 1: 10
Output 2: 2

Example Explanation:
Explanation 1:
The largest rectangle has area = 10 unit. Formed by A[3] to A[4].
Explanation 2:
Largest rectangle has area 2.
 */
public class LargestRectangleInHistogram {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(90,58,69,70,82,100,13,57,47,18));
        int n = A.size();

        bruteForce(A, n);
        // Time O(N^2);
        // Space O(1);

        optimized(A, n);
        // Time O(N);
        // Space O(N);

    }

    public static void bruteForce(ArrayList<Integer> A, int n) {

        int ans = 0;

        for (int i = 0; i < n; i++) {

            int min = A.get(i);

            for (int j = i; j < n; j++) {

                min = Math.min(min, A.get(j));

                int area = (j - i + 1) * min;

                ans = Math.max(ans, area);
            }

        }
        System.out.println(ans);
    }

    public  static  void optimized(ArrayList<Integer> A, int n){

        int [] smallestToLeft = findNearestSmallestToLeft(A, n);
        int [] smallestToRight = findNearestSmallestToRight(A, n);

        int maxArea = 0;

        for(int i = 0; i < n; i++){

            int j = smallestToLeft[i];
            int k = smallestToRight[i];

            int length = A.get(i);
            int breadth = k - j - 1;
            int area = length * breadth;

            maxArea = Math.max(maxArea, area);
        }

        System.out.print(maxArea);
    }

    public  static int [] findNearestSmallestToLeft(ArrayList<Integer> A, int n){

        Stack<Integer> stack = new Stack<>();
        int [] res = new int [n];

        for(int i = 0; i < n; i++){

            while(!stack.isEmpty() && A.get(stack.peek()) >= A.get(i)){
                stack.pop();
            }

            if(stack.isEmpty()) res[i] = -1;
            else res[i] = stack.peek();

            stack.push(i);
        }

        return res;
        // Time O(N);
        // Space O(N);
    }

    public  static  int [] findNearestSmallestToRight(ArrayList<Integer> A, int n){

        Stack<Integer> stack = new Stack<>();

        int [] res = new int [n];

        for(int i = n - 1; i >= 0; i--){

            while (!stack.isEmpty() && A.get(stack.peek()) >= A.get(i)){
                stack.pop();
            }

            if(stack.isEmpty()) res[i] = n;
            else res[i] = stack.peek();

            stack.push(i);
        }

        return res;
        // Time O(N);
        // Space O(N);
    }
}
