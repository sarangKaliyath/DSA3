package Trees;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
Given a root of binary tree A, determine if it is height-balanced.
A height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Problem Constraints
1 <= size of tree <= 100000

Input Format
First and only argument is the root of the tree A.

Output Format
Return 0 / 1 ( 0 for false, 1 for true ) for this problem.

Example Input:
Input 1:
    1
   / \
  2   3

Input 2:
       1
      /
     2
    /
   3

Example Output:
Output 1: 1
Output 2: 0

Example Explanation:
Explanation 1:
It is a complete binary tree.
Explanation 2:
Because for the root node, left subtree has depth 2 and right subtree has depth 0.
Difference = 2 > 1.

 */
public class BalancedBinaryTree {

    public static void main (String [] args){
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3, 4, null, null, null, 1));
        BuildIntegerTree treeBuilder = new BuildIntegerTree();
        TreeNode root = treeBuilder.BuildIntegerTree(A);

        boolean res = firstApproach(root);
        System.out.println(res ? 1 : 0);
        // Time O(N^2);
        // Space O(Height of tree);

        int ans = optimized(root);
        System.out.println(ans > 0 ? 1 : 0);
        // Time O(N);
        // Space O(Height of Tree);
    }

   public static  int optimized(TreeNode root){
        if(root == null) return 0;

        int leftHeight = optimized(root.left);
        if(leftHeight == -1) return -1;

        int rightHeight = optimized(root.right);
        if(rightHeight == -1) return  -1;

        if(Math.abs(leftHeight - rightHeight) > 1) return  -1;

        return Math.max(leftHeight, rightHeight) + 1;
   }

    public  static  boolean firstApproach(TreeNode root){

        if(root == null) return true;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if(Math.abs(leftHeight - rightHeight) > 1) return false;

        return firstApproach(root.left) && firstApproach(root.right);
    }

    public static int getHeight(TreeNode root){
        if(root == null) return -1;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
