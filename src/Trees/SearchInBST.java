package Trees;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
Given a Binary Search Tree A. Check whether there exists a node with value B in the BST.

Problem Constraints
1 <= Number of nodes in binary tree <= 10^5
0 <= B <= 10^6

Input Format
First argument is a root node of the binary tree, A.
Second argument is an integer B.

Output Format
Return 1 if such a node exist and 0 otherwise

Example Input:
Input 1:
            15
          /    \
        12      20
        / \    /  \
       10  14  16  27
      /
     8
     B = 16

Input 2:
            8
           / \
          6  21
         / \
        1   7
     B = 9

Example Output:
Output 1: 1
Output 2: 0

Example Explanation:
Explanation 1:
 Node with value 16 is present.
Explanation 2:
 There is no node with value 9.
 */
public class SearchInBST {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(15, 12, 20, 10, 14, 16, 27, 8));
        int B = 1;

        BuildIntegerTree treeBuilder = new BuildIntegerTree();
        TreeNode root = treeBuilder.BuildIntegerTree(A);

        int res = find(root, B);
        System.out.println(res);
        // Time O(Height of tree);
        // Best Case Space O(log N);
        // Worst Case Space O(N);
    }

    public static int find(TreeNode root, int target) {
        if (root == null) return 0;
        if (root.val == target) return 1;
        else if (root.val < target) return find(root.right, target);
        else return find(root.left, target);
    }

}
