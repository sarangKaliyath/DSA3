package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

/*
Problem Description
Given preorder traversal of a binary tree,
check if it is possible that it is also a preorder traversal of a Binary Search Tree (BST),
where each internal node (non-leaf nodes) have exactly one child.

Problem Constraints
1 <= number of nodes <= 100000

Input Format
First and only argument is an integer array denoting the preorder traversal of binary tree.

Output Format
Return a string "YES" if true else "NO".

Example Input:
Input 1: A : [4, 10, 5, 8]
Input 2: A : [1, 5, 6, 4]

Example Output:
Output 1: "YES"
Output 2: "NO"

Example Explanation:
Explanation 1:
 The possible BST is:
            4
             \
             10
             /
             5
              \
              8

Explanation 2:
 There is no possible BST which have the above preorder traversal.
 */
public class CheckForBSTWithOneChild {

    private static int prev = Integer.MIN_VALUE;

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(12, 1, 9, 6, 2));

        System.out.println(isValidOptimized(A));
        // Time O(N);
        // Space O(1);

        // Create a Tree with the given preorder list
        // check if the tree is valid BST;
        TreeNode root = createTree(A, A.size());
        boolean res = isBalanced(root);
        System.out.println(res ? "Yes" : "No");

    }

    public static String isValidOptimized(ArrayList<Integer> A) {
        int minValue = Integer.MIN_VALUE;
        int maxValue = Integer.MAX_VALUE;
        int prevVal = A.get(0);

        for (int i = 1; i < A.size(); i++) {
            if (A.get(i) > prevVal) minValue = prevVal;
            else maxValue = prevVal;

            if (A.get(i) <= minValue || A.get(i) >= maxValue) return "NO";
            prevVal = A.get(i);
        }
        return "YES";
    }

    public static TreeNode createTree(ArrayList<Integer> A, int n) {
        TreeNode root = new TreeNode(A.get(0));
        TreeNode prev = root;
        for (int i = 1; i < n; i++) {
            TreeNode temp = new TreeNode(A.get(i));
            if (A.get(i) <= A.get(i - 1)) {
                prev.left = temp;
            } else {
                prev.right = temp;
            }
            prev = temp;
        }
        return root;
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (!isBalanced(root.left) || root.val < prev) return false;
        prev = root.val;
        return isBalanced(root.right);
    }
}
