package Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
Problem Description
Given a binary tree, return the preorder traversal of its nodes values.

Problem Constraints
1 <= number of nodes <= 10^5

Input Format
First and only argument is root node of the binary tree, A.

Output Format
Return an integer array denoting the preorder traversal of the given binary tree.

Example Input:
Input 1:
   1
    \
     2
    /
   3
Input 2:
   1
  / \
 6   2
    /
   3

Example Output:
Output 1: [1, 2, 3]
Output 2: [1, 6, 2, 3]

Example Explanation:
Explanation 1:
 The Preorder Traversal of the given tree is [1, 2, 3].
Explanation 2:
 The Preorder Traversal of the given tree is [1, 6, 2, 3].
 */
public class PreOrderTraversal {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 6, 2, null, null, 3, null));
        // Class to build an Integer Tree with left from an arrayList;
        BuildIntegerTree treeBuilder = new BuildIntegerTree();
        TreeNode root = treeBuilder.BuildIntegerTree(A);

        ArrayList<Integer> res = new ArrayList<>();
        preOrderTraversal(root, res);
        System.out.println(res);
        // Time O(N);
        // Space O(height of tree);
    }

    public static void preOrderTraversal(TreeNode root, ArrayList<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        preOrderTraversal(root.left, res);
        preOrderTraversal(root.right, res);
    }

}
