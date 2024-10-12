package Stacks;

import java.util.Stack;

/*
Problem Description
Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.
Refer to the examples for more clarity.

Problem Constraints
1 <= |A| <= 100

Input Format
The first and the only argument of input contains the string A having the parenthesis sequence.

Output Format
Return 0 if the parenthesis sequence is not balanced.
Return 1 if the parenthesis sequence is balanced.

Example Input
Input 1: A = {([])}
Input 2: A = (){
Input 3: A = ()[]

Example Output
Output 1: 1
Output 2: 0
Output 3: 1

Example Explanation
You can clearly see that the first and third case contain valid parenthesis.
In the second case, there is no closing bracket for {, thus the parenthesis sequence is invalid.
 */
public class BalancedParenthesis {

    public static void main(String[] args) {

        String A = "(){";

        int res = isValid(A);
        System.out.println(res);
        // Time O(N);
        // Space O(N);
    }

    public static int isValid(String A) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < A.length(); i++) {
            char el = A.charAt(i);

            if (el == '(' || el == '[' || el == '{') {
                stack.push(el);
            } else {
                if (stack.isEmpty()) return 0;
                else if (el == ')' && stack.peek() != '(') return 0;
                else if (el == ']' && stack.peek() != '[') return 0;
                else if (el == '}' && stack.peek() != '{') return 0;
                else stack.pop();
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
