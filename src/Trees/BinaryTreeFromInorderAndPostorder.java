package Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
Problem Description
Given the inorder and postorder traversal of a tree, construct the binary tree.
NOTE: You may assume that duplicates do not exist in the tree.

Problem Constraints
1 <= number of nodes <= ^105

Input Format
First argument is an integer array A denoting the inorder traversal of the tree.
Second argument is an integer array B denoting the postorder traversal of the tree.

Output Format
Return the root node of the binary tree.

Example Input:
Input 1:
 A = [2, 1, 3]
 B = [2, 3, 1]
Input 2:
 A = [6, 1, 3, 2]
 B = [6, 3, 2, 1]

Example Output:
Output 1:
   1
  / \
 2   3

Output 2:
   1
  / \
 6   2
    /
   3

Example Explanation:
Explanation 1:
 Create the binary tree and return the root node of the tree.
 */
public class BinaryTreeFromInorderAndPostorder {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(6, 1, 3, 2));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(6, 3, 2, 1));

        TreeNode root = build(A, B);
        // Time O(N);
        // Space O(N);
    }

    private static HashMap<Integer, Integer> hm = new HashMap<>();

    public static TreeNode build(ArrayList<Integer> inorderArray, ArrayList<Integer> postorderArray) {
        int n = inorderArray.size();
        for (int i = 0; i < n; i++) {
            hm.put(inorderArray.get(i), i);
        }
        return buildTree(inorderArray, 0, n - 1, postorderArray, n - 1);
    }

    public static TreeNode buildTree(ArrayList<Integer> inorderArray, int i, int j, ArrayList<Integer> postorderArray, int k) {
        if (i > j) return null;

        TreeNode root = new TreeNode(postorderArray.get(k));
        int rootIndex = hm.get(postorderArray.get(k));

        int sizeOfRightSubTree = j - rootIndex;

        root.left = buildTree(inorderArray, i, rootIndex - 1, postorderArray, k - 1 - sizeOfRightSubTree);
        root.right = buildTree(inorderArray, rootIndex + 1, j, postorderArray, k - 1);

        return root;
    }
}
