package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

/*
Problem Description
Given a binary tree of integers denoted by root A.
Return an array of integers representing the right view of the Binary tree.
Right view of a Binary Tree is a set of nodes visible when the tree is visited from Right side.

Problem Constraints
1 <= Number of nodes in binary tree <= 100000
0 <= node values <= 10^9

Input Format
First and only argument is head of the binary tree A.

Output Format
Return an array, representing the right view of the binary tree.

Example Input:
Input 1:
            1
          /   \
         2    3
        / \  / \
       4   5 6  7
      /
     8

Input 2:
            1
           /  \
          2    3
           \
            4
             \
              5

Example Output:
Output 1: [1, 3, 7, 8]
Output 2: [1, 3, 4, 5]

Example Explanation:
Explanation 1:
Right view is described.
Explanation 2:
Right view is described.

 */
public class RightViewOfBinaryTree {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        BuildIntegerTree treeBuilder = new BuildIntegerTree();
        TreeNode root = treeBuilder.BuildIntegerTree(A);
        ArrayList<Integer> res = getVisibleNodesFromRight(root);
        System.out.print(res);
        // Time O(N);
        // Space O(N);
    }

    public static ArrayList<Integer> getVisibleNodesFromRight(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offerLast(root);
        TreeNode last = root;

        while (!q.isEmpty()) {
            TreeNode node = q.pollFirst();
            if (node.left != null) q.offerLast(node.left);
            if (node.right != null) q.offerLast(node.right);
            if (node == last) {
                res.add(node.val);
                last = q.peekLast();
            }
        }
        return res;
    }
}
