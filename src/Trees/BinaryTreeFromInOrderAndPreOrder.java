package Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
Problem Description
Given preorder and inorder traversal of a tree, construct the binary tree.
NOTE: You may assume that duplicates do not exist in the tree.

Problem Constraints
1 <= number of nodes <= 10^5

Input Format:
First argument is an integer array A denoting the preorder traversal of the tree.
Second argument is an integer array B denoting the inorder traversal of the tree.

Output Format
Return the root node of the binary tree.

Example Input:
Input 1:
 A = [1, 2, 3]
 B = [2, 1, 3]

Input 2:
 A = [1, 6, 2, 3]
 B = [6, 1, 3, 2]

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
public class BinaryTreeFromInOrderAndPreOrder {
    private static HashMap<Integer, Integer> hm = new HashMap<>();

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(2, 1, 3));

        int n = B.size();
        for (int i = 0; i < n; i++) {
            hm.put(B.get(i), i);
        }

        TreeNode res = buildTree(B, 0, n - 1, A, 0);
        System.out.print(res);
        // Time O(N);
        // Space O(N);
    }

    public static TreeNode buildTree(ArrayList<Integer> inorder, int i, int j, ArrayList<Integer> preorder, int k) {
        if (i > j) return null;

        TreeNode root = new TreeNode(preorder.get(k));
        int rootIndex = hm.get(preorder.get(k));
        int sizeOfLeftSubTree = rootIndex - i;

        root.left = buildTree(inorder, i, rootIndex - 1, preorder, k + 1);
        root.right = buildTree(inorder, rootIndex + 1, j, preorder, k + sizeOfLeftSubTree + 1);

        return root;
    }
}
