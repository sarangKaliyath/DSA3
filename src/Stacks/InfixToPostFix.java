package Stacks;

import java.util.Stack;

/*
Problem Description
Given string A denoting an infix expression. Convert the infix expression into a postfix expression.
String A consists of ^, /, *, +, -, (, ) and lowercase
English alphabets where lowercase English alphabets are operands and ^, /, *, +, - are operators.
Find and return the postfix expression of A.
NOTE:
    ^ has the highest precedence.
    / and * have equal precedence but greater than + and -.
    + and - have equal precedence and lowest precedence among given operators.

Problem Constraints
1 <= length of the string <= 500000

Input Format
The only argument given is string A.

Output Format
Return a string denoting the postfix conversion of A.

Example Input:
Input 1: A = "x^y/(a*z)+b"
Input 2: A = "a+b*(c^d-e)^(f+g*h)-i"

Example Output
Output 2: "abcd^e-fgh*+^*+i-"

Example Explanation:
Explanation 1:
 Output denotes the postfix expression of the given input.

 */
public class InfixToPostFix {

    public static void main(String[] args) {
        String A = "a*(r+o*h)";
        String res = convertToPostFix(A);
        System.out.println(res);
        // Time O(N);
        // Space O(N);
    }

    public static String convertToPostFix(String A) {

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);

            if (Character.isLetter(ch)) sb.append(ch);

            else if (ch == '(') stack.push(ch);

            else if (ch == ')') {
                while (stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && getPrecedence(ch) <= getPrecedence(stack.peek())) {
                    sb.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static int getPrecedence(char x) {
        return switch (x) {
            case '^' -> 3;
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            default -> -1;
        };
    }
}
