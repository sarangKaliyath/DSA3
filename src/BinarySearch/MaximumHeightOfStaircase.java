package BinarySearch;

/*
Problem Description

Given an integer A representing the number of square blocks.
The height of each square block is 1. The task is to create a staircase of max-height using these blocks.
The first stair would require only one block, and the second stair would require two blocks, and so on.
Find and return the maximum height of the staircase.

Problem Constraints
0 <= A <= 10^9

Input Format
The only argument given is integer A.

Output Format
Return the maximum height of the staircase using these blocks.

Example Input

Input 1: A = 10
Input 2: A = 20

Example Output

Output 1: 4
Output 2: 5

Example Explanation

Explanation 1:
 The stairs formed will have height 1, 2, 3, 4.
Explanation 2:
 The stairs formed will have height 1, 2, 3, 4, 5.

 */
public class MaximumHeightOfStaircase {

    public  static  void main (String [ ] args){

        int A = 20;

        int res = findMaxHeight(A);
        System.out.println(res);
        // Time O(log N);
        // Space O(1);
    }

    public  static  int findMaxHeight(int A){

        if(A == 0) return A;

        int left = 1;
        int right = A;
        int res = 0;

        while (left <= right){

            int mid = left + ((right - left) / 2);

            long sum = (long) mid * (mid + 1) / 2;

            if(sum <= A){
                res = mid;
                left = mid + 1;
            }
            else right = mid - 1;

        }

        return res;
    }
}
