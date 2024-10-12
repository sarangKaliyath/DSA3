package Stacks;

import java.util.Stack;

/*
Problem Description
Given a string A denoting an expression. It contains the following operators '+', '-', '*', '/'.
Check whether A has redundant braces or not.
NOTE: A will be always a valid expression and will not contain any white spaces.

Problem Constraints
1 <= |A| <= 10^5

Input Format
The only argument given is string A.

Output Format
Return 1 if A has redundant braces else, return 0.

Example Input:
Input 1: A = "((a+b))"
Input 2: A = "(a+(a+b))"

Example Output:
Output 1: 1
Output 2: 0

Example Explanation:
Explanation 1:
 ((a+b)) has redundant braces so stackwer will be 1.
Explanation 2:
 (a+(a+b)) doesn't have have any redundant braces so stackwer will be 0.
 */
public class RedundantBraces {

    public static void main(String[] args) {

        String A = "(a+(a+b))";

        int res = isRedundant(A);
        System.out.println(res);
        // Time O(N);
        // Space O(N);
    }

    public static int isRedundant(String A) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);

            if (ch == '(') stack.push(ch);
            else {
                if (ch == ')') {
                    boolean containsOperator = false;

                    while (!stack.isEmpty() && stack.peek() != '(') {
                        char temp = stack.pop();
                        if (temp == '+' || temp == '-' || temp == '*' || temp == '/') containsOperator = true;
                    }
                    stack.pop();
                    if (!containsOperator) return 1;
                } else stack.push(ch);
            }
        }
        return 0;
    }

}
