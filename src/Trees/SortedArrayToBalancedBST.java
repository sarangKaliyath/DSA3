package Trees;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

/*
Problem Description
Given an array where elements are sorted in ascending order,
convert it to a height Balanced Binary Search Tree (BST).
Balanced tree : a height-balanced binary tree is defined as a binary tree in which,
the depth of the two subtrees of every node never differ by more than 1.

Problem Constraints
1 <= length of array <= 100000

Input Format
First argument is an integer array A.

Output Format
Return a root node of the Binary Search Tree.

Example Input:
Input 1: A : [1, 2, 3]
Input 2: A : [1, 2, 3, 5, 10]

Example Output

Output 1:
      2
    /   \
   1     3

Output 2:
      3
    /   \
   2     5
  /       \
 1         10

Example Explanation:
Explanation 1:
 You need to return the root node of the Binary Tree.
 */
public class SortedArrayToBalancedBST {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 10));
        TreeNode root = createHeightBalancedTree(A, 0, A.size() - 1);
        // Time O(N);
        // Space O(Height of Tree == log N);

        // For a BST Inorder Traversal will print output elements,
        // in ascending order if structure is correct.
        ArrayList<Integer> res = new ArrayList<>();
        printInorder(root, res);
    }

    public static TreeNode createHeightBalancedTree(ArrayList<Integer> A, int left, int right) {
        if (left > right) return null;
        int mid = left + ((right - left) >> 1);
        TreeNode root = new TreeNode(A.get(mid));
        root.left = createHeightBalancedTree(A, left, mid - 1);
        root.right = createHeightBalancedTree(A, mid + 1, right);
        return root;
    }


    public  static void printInorder(TreeNode root, ArrayList<Integer> res){
        if(root == null) return;
        printInorder(root.left, res);
        res.add(root.val);
        printInorder(root.right, res);
    }
}
