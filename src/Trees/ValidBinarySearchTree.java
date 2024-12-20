package Trees;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
You are given a binary tree represented by root A. You need to check if it is a Binary Search Tree or not.
Assume a BST is defined as follows:
1) The left subtree of a node contains only nodes with keys less than the node's key.
2) The right subtree of a node contains only nodes with keys greater than the node's key.
3) Both the left and right subtrees must also be binary search trees.

Problem Constraints
1 <= Number of nodes in binary tree <= 10^5
0 <= node values <= 2^32-1

Input Format
First and only argument is head of the binary tree A.

Output Format
Return 0 if false and 1 if true.

Example Input

Input 1:
   1
  /  \
 2    3

Input 2:
  2
 / \
1   3

Example Output:
Output 1: 0
Output 2: 1

Example Explanation:
Explanation 1: 2 is not less than 1 but is in left subtree of 1.
Explanation 2: Satisfies all conditions.

 */
public class ValidBinarySearchTree {
    private static int prev = Integer.MIN_VALUE;

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(5, 2, 6, 1, 3, null, 7));
        BuildIntegerTree treeBuilder = new BuildIntegerTree();
        TreeNode root = treeBuilder.BuildIntegerTree(A);

        boolean res = isBalanced(root);
        System.out.println(res + " " + prev);
        // Time O(N);
        // Space O(Height of Tree);

        boolean out = betterApproach(root, Long.MIN_VALUE, Long.MAX_VALUE);
        System.out.println(out);
        // Time O(N);
        // Space O(Height of tree);
    }

    public static boolean betterApproach(TreeNode root, long min, long max){
        if(root == null) return  true;
        if(root.val < min || root.val > max) return  false;
        return betterApproach(root.left, min, root.val) && betterApproach(root.right, root.val, max);
    }
    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (!isBalanced(root.left) || root.val < prev) return false;
        prev = root.val;
        return isBalanced(root.right);
    }
}
