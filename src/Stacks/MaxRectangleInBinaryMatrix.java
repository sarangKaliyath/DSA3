package Stacks;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*
Problem Description
Given a 2-D binary matrix A of size N x M filled with 0's and 1's,
find the largest rectangle containing only ones and return its area.

Problem Constraints
1 <= N, M <= 100

Input Format
The first argument is a 2-D binary array A.

Output Format
Return an integer denoting the area of the largest rectangle containing only ones.

Example Input

Input 1:
 A = [
       [1, 1, 1]
       [0, 1, 1]
       [1, 0, 0]
     ]

Input 2:
 A = [
       [0, 1, 0]
       [1, 1, 1]
     ]

Example Output:
Output 1: 4
Output 2: 3

Example Explanation:
Explanation 1:
 As the max area rectangle is created by the 2x2 rectangle created by (0, 1), (0, 2), (1, 1) and (1, 2).
Explanation 2:
 As the max area rectangle is created by the 1x3 rectangle created by (1, 0), (1, 1) and (1, 2).
 */
public class MaxRectangleInBinaryMatrix {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(0, 1, 0)),
                new ArrayList<>(Arrays.asList(1, 1, 1))

        ));

        int res = findMaxArea(A, A.size(), A.get(0).size());
        System.out.println(res);
        // Time O(N^M);
        // Space O(N^M);
    }

    public static int findMaxArea(ArrayList<ArrayList<Integer>> A, int n, int m) {

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int currentVal = A.get(i).get(j);
                if (currentVal != 0) {
                    int prevVal = A.get(i - 1).get(j);
                    A.get(i).set(j, currentVal + prevVal);
                }
            }
        }

        int[][] smallerToLeft = findNearestSmallerToLeft(A, n, m);
        int[][] smallerToRight = findNearestSmallerToRight(A, n, m);

        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                int area = ((smallerToRight[i][j] - smallerToLeft[i][j]) - 1) * A.get(i).get(j);

                maxArea = Math.max(maxArea, area);
            }

        }
        return maxArea;
    }

    public static int[][] findNearestSmallerToLeft(ArrayList<ArrayList<Integer>> A, int n, int m) {

        int[][] res = new int[n][m];

        for (int i = 0; i < n; i++) {

            Stack<Integer> stack = new Stack<>();

            for (int j = 0; j < m; j++) {

                while (!stack.isEmpty() && A.get(i).get(stack.peek()) >= A.get(i).get(j)) {
                    stack.pop();
                }

                if (stack.isEmpty()) res[i][j] = -1;
                else res[i][j] = stack.peek();

                stack.push(j);
            }

        }
        return res;
    }

    public static int[][] findNearestSmallerToRight(ArrayList<ArrayList<Integer>> A, int n, int m) {
        int[][] res = new int[n][m];

        for (int i = 0; i < n; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = m - 1; j >= 0; j--) {

                while (!stack.isEmpty() && A.get(i).get(stack.peek()) >= A.get(i).get(j)) {
                    stack.pop();
                }

                if (stack.isEmpty()) res[i][j] = m;
                else res[i][j] = stack.peek();

                stack.push(j);
            }
        }
        return res;
    }
}