package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

/*
Problem Description
Given the root node of a Binary Tree denoted by A. You have to Serialize the given Binary Tree in the described format.
Serialize means encode it into a integer array denoting the Level Order Traversal of the given Binary Tree.
NOTE:
In the array, the NULL/None child is denoted by -1.
For more clarification check the Example Input.

Problem Constraints
1 <= number of nodes <= 10^5

Input Format
Only argument is A denoting the root node of a Binary Tree.

Output Format
Return an integer array denoting the Level Order Traversal of the given Binary Tree.

Example Input:
Input 1:
           1
         /   \
        2     3
       / \
      4   5

Input 2:
            1
          /   \
         2     3
        / \     \
       4   5     6

Example Output:
Output 1: [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]
Output 2: [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]
 */
public class SerializeBinaryTree {
    private static ArrayList<Integer> res = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, null, 6));
        BuildIntegerTree treeBuilder = new BuildIntegerTree();
        TreeNode root = treeBuilder.BuildIntegerTree(A);

        ArrayList<Integer> res = serialize(root);
        System.out.print(res);
        // Time O(N);
        // Space O(N);g
    }

    public static ArrayList<Integer> serialize(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offerLast(root);

        while (!q.isEmpty()) {

            TreeNode node = q.pollFirst();
            res.add(node.val);

            if (node.val != -1) {
                TreeNode temp = new TreeNode(-1);
                q.offerLast(node.left == null ? temp : node.left);
                q.offerLast(node.right == null ? temp : node.right);
            }

        }
        return res;
    }
}
