package Stacks;

import java.util.*;

/*
Problem Description
You have a string, denoted as A.
To transform the string, you should perform the following operation repeatedly:
    Identify the first occurrence of consecutive identical pairs of characters within the string.
    Remove this pair of identical characters from the string.
    Repeat steps 1 and 2 until there are no more consecutive identical pairs of characters.
The final result will be the transformed string.

Problem Constraints
1 <= |A| <= 100000

Input Format
First and only argument is string A.

Output Format
Return the final string.

Example Input
Input 1: A = "abccbc"
Input 2: A = "ab"

Example Output
Output 1: "ac"
Output 2: "ab"

Example Explanation

Explanation 1:
The Given string is "abccbc".
Remove the first occurrence of consecutive identical pairs of characters "cc".
After removing the string will be "abbc".
Again Removing the first occurrence of consecutive identical pairs of characters "bb".
After removing, the string will be "ac".
Now, there is no consecutive identical pairs of characters.
Therefore, the string after this operation will be "ac".

Explanation 2:
 No removals are to be done.

 */
public class DoubleCharacterTrouble {

    public static void main(String[] args) {

        String A = "aaaaa";

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < A.length(); i++){
            char ch = A.charAt(i);
            if(!stack.isEmpty() && stack.peek() == ch){
                stack.pop();
            }
            else stack.push(ch);
        }

        ArrayList<Character> res = new ArrayList<>();

        while(!stack.isEmpty()){
            res.add(stack.pop());
        }

        System.out.println(reverse(res));
        // Time O(N);
        // Space O(N);
    }

    public static String reverse(ArrayList<Character> A){
        int l = 0;
        int r = A.size() - 1;

        while(l < r){
            Character temp = A.get(l);
            A.set(l, A.get(r));
            A.set(r, temp);
            l++; r--;
        }

        StringBuilder sb = new StringBuilder();
        for(char el : A) sb.append(el);
        return sb.toString();
    }
}
