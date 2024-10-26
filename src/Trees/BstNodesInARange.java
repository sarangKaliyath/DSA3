package Trees;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
Given a binary search tree of integers. You are given a range B and C.
Return th of the number of nodes that lie in the given range.

Problem Constraints
1 <= Number of nodes in binary tree <= 100000
0 <= B < = C <= 10^9

Input Format:
First argument is a root node of the binary tree, A.
Second argument is integer B.
Third argument is integer C.

Output Format
Returns th of the number of nodes that lies in the given range.

Example Input:
Input 1:
            15
          /    \
        12      20
        / \    /  \
       10  14  16  27
      /
     8

     B = 12
     C = 20

Input 2:
            8
           / \
          6  21
         / \
        1   7

     B = 2
     C = 20

Example Output:
Output 1: 5
Output 2: 3

Example Explanation:
Explanation 1: Nodes which are in range [12, 20] are : [12, 14, 15, 20, 16]
Explanation 2: Nodes which are in range [2, 20] are : [8, 6, 7]
 */
public class BstNodesInARange {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(8, 6, 21, 1, 7));
        int B = 2;
        int C = 20;

        BuildIntegerTree treeBuilder = new BuildIntegerTree();
        TreeNode root = treeBuilder.BuildIntegerTree(A);

        int count = getCount(root, B, C);
        System.out.println(count);

        // Time O( Height Of Tree + nodes in range B & C); -> if Tree is unbalanced;
        // Time O(log N + nodes in range B & C); -> if Tree is balanced;
        // Space O(Height of tree);
    }

    public static int getCount(TreeNode root, int B, int C) {
        if (root == null) return 0;
        if (root.val >= B && root.val <= C) return getCount(root.left, B, C) + getCount(root.right, B, C) + 1;
        else if (root.val < B) return getCount(root.right, B, C);
        else return getCount(root.left, B, C);
    }
}
