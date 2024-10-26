package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/*
Problem Description
You are given an integer array A denoting the Level Order Traversal of the Binary Tree.
You have to Deserialize the given Traversal in the Binary Tree and return the root of the Binary Tree.
NOTE: In the array, the NULL/None child is denoted by -1.

Problem Constraints
1 <= number of nodes <= 10^5
-1 <= A[i] <= 10^5

Input Format
Only argument is an integer array A denoting the Level Order Traversal of the Binary Tree.

Output Format:
Return the root node of the Binary Tree.

Example Input:
Input 1: A = [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]
Input 2: A = [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]

Example Output:
Output 1:
           1
         /   \
        2     3
       / \
      4   5

Output 2:
            1
          /   \
         2     3
        / \ .   \
       4   5 .   6

Example Explanation

Explanation 1:
 Each element of the array denotes the value of the node. If the val is -1 then it is the NULL/None child.
 Since 3, 4 and 5 each has both NULL children, we have represented that using -1.

Explanation 2:
 Each element of the array denotes the value of the node. If the val is -1 then it is the NULL/None child.
 Since 3 has left child as NULL while 4 and 5 each has both NULL children.
 */
public class DeserializeBinaryTree {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1};
        TreeNode root = deserialize(A, A.length);
        // Time O(N);
        // Space O(N);
        printTree(root);
    }

    public static TreeNode deserialize(int[] A, int n) {
        if (n == 0) return null;

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offerLast(new TreeNode(A[0]));
        int i = 1;
        TreeNode root = q.peekFirst();

        while (!q.isEmpty() && i < n) {
            TreeNode node = q.pollFirst();
            if (A[i] != -1) {
                TreeNode leftNode = new TreeNode(A[i]);
                node.left = leftNode;
                q.offerLast(leftNode);
            }
            if (A[i + 1] != -1) {
                TreeNode rightNode = new TreeNode(A[i + 1]);
                node.right = rightNode;
                q.offerLast(rightNode);
            }
            i += 2;
        }
        return root;
    }

    public static void printTree(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offerLast(root);
        TreeNode last = root;

        while (!q.isEmpty()) {
            TreeNode node = q.pollFirst();
            res.add(node.val);
            if (node.left != null) q.offerLast(node.left);
            if (node.right != null) q.offerLast(node.right);

            if (last == node) {
                System.out.println(res);
                res = new ArrayList<>();
                last = q.peekLast();
            }
        }
    }
}
