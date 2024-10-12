package Stacks;

import java.util.*;

/*
Problem Description
Given two strings A and B. Each string represents an expression consisting of lowercase English alphabets, '+', '-', '(' and ')'.
The task is to compare them and check if they are similar. If they are identical, return 1 else, return 0.
NOTE: It may be assumed that there are at most 26 operands from ‘a’ to ‘z’, and every operand appears only once.

Problem Constraints
1 <= length of each String <= 100

Input Format
The given arguments are string A and string B.

Output Format
Return 1 if they represent the same expression else return 0.

Example Input:
Input 1:
 A = "-(a+b+c)"
 B = "-a-b-c"
Input 2:
 A = "a-b-(c-d)"
 B = "a-b-c-d"

Example Output:
Output 1: 1
Output 2: 0

Example Explanation:
Explanation 1:
 The expression "-(a+b+c)" can be written as "-a-b-c" which is equal as B.
Explanation 2:
 Both the expression are different.

 */
public class CheckTwoBracketExpressions {

    public static void main(String[] args) {

        String A = "-(a-(-z-(b-(c+t)-x)+l)-q)";
        String B = "-a+l-b-(z-(c+t)-x-q)";

        boolean[] resolvedA = evaluate(A);
        boolean[] resolvedB = evaluate(B);

        int res = Arrays.toString(resolvedA).equals(Arrays.toString(resolvedB)) ? 1 : 0;
        System.out.println(res);
        // Time O(N);
        // Space O(N);
    }

    public static boolean[] evaluate(String str) {

        Stack<Boolean> stack = new Stack<>();
        boolean[] charArray = new boolean[26];
        Arrays.fill(charArray, true);

        boolean currentSign = true;

        for (int i = 0; i < str.length(); i++) {

            char val = str.charAt(i);

            if (val == '-' || val == '+') {

                if (stack.isEmpty()) currentSign = val == '+';
                else {
                    if (stack.peek() && val == '+') currentSign = true;
                    else if (!stack.peek() && val == '-') currentSign = true;
                    else currentSign = false;
                }

            } else if (val == '(') stack.push(currentSign);

            else if (val == ')') stack.pop();

            else if (Character.isLetter(val)) charArray[val - 'a'] = currentSign;

        }
        return charArray;
    }
}
