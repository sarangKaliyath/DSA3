package Stacks;

import java.util.*;

/*
Problem Description

An arithmetic expression is given by a string array A of size N.
Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, /. Each string may be an integer or an operator.
Note: Reverse Polish Notation is equivalent to Postfix Expression, where operators are written after their operands.

Problem Constraints
1 <= N <= 10^5

Input Format
The only argument given is string array A.

Output Format
Return the value of arithmetic expression formed using reverse Polish Notation.

Example Input
Input 1: A =   ["2", "1", "+", "3", "*"]
Input 2: A = ["4", "13", "5", "/", "+"]

Example Output
Output 1: 9
Output 2: 6

Example Explanation:

Explanation 1:
starting from backside:
    * : () * ()
    3 : () * (3)
    + : (() + ()) * (3)
    1 : (() + (1)) * (3)
    2 : ((2) + (1)) * (3)
    ((2) + (1)) * (3) = 9

Explanation 2:
starting from backside:
    + : () + ()
    / : () + (() / ())
    5 : () + (() / (5))
    13 : () + ((13) / (5))
    4 : (4) + ((13) / (5))
    (4) + ((13) / (5)) = 6

 */
public class EvaluateExpression {

    public static void main(String[] args) {

        ArrayList<String> A = new ArrayList<>(Arrays.asList("2", "2", "/"));

        int res = evaluate(A);
        System.out.println(res);
    }

    public static int evaluate(ArrayList<String> A) {

        Stack<Integer> stack = new Stack<>();

        for (String el : A) {

            int res = 0;

            if (isNumber(el)) {
                stack.push(Integer.parseInt(el));
            } else {

                int y = stack.pop();
                int x = stack.pop();

                if (el.equals("+")) res = x + y;
                else if (el.equals("-")) res = x - y;
                else if (el.equals("/")) res = x / y;
                else if (el.equals("*")) res = x * y;

                stack.push(res);
            }

        }
        return stack.peek();
    }


    public static boolean isNumber(String el) {
        return !(el.equals("+") || el.equals("-") || el.equals("*") || el.equals("/"));
    }
}
