package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

/*
Problem Description
Given a Binary Search Tree(BST) A. If there is a node with value B present in the tree delete it and return the tree.
Note - If there are multiple options, always replace a node by its in-order predecessor

Problem Constraints
2 <= No. of nodes in BST <= 10^5
1 <= value of nodes <= 10^9
Each node has a unique value

Input Format
The first argument is the root node of a Binary Search Tree A.
The second argument is the value B.

Output Format
Delete the given node if found and return the root of the BST.

Example Input:
Input 1:
            15
          /    \
        12      20
        / \    /  \
       10  14  16  27
      /
     8

     B = 10

Input 2:
            8
           / \
          6  21
         / \
        1   7

     B = 6

Example Output:
Output 1:
            15
          /    \
        12      20
        / \    /  \
       8  14  16  27

Output 2:
            8
           / \
          1  21
           \
            7

Example Explanation:
Explanation 1:Node with value 10 is deleted
Explanation 2: Node with value 6 is deleted

 */
public class DeleteANodeInBST {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(15, 12, 20, 12, 14, 16, 27, 8));
        int B = 12;

        BuildIntegerTree treeBuilder = new BuildIntegerTree();
        TreeNode root = treeBuilder.BuildIntegerTree(A);

        TreeNode res = deleteNode(root, B);
        // Time O(H);
        // Space O(H);
        printLevel(res);
    }

    public static TreeNode deleteNode(TreeNode root, int B) {

        if (root == null) return null;

        if (B < root.val) root.left = deleteNode(root.left, B);
        else if (B > root.val) root.right = deleteNode(root.right, B);
        else {
            if (root.left == null && root.right == null) return null;
            else if (root.left == null || root.right == null) {
                if (root.left != null) return root.left;
                return root.right;
            } else {
                TreeNode temp = root.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                root.val = temp.val;
                root.left = deleteNode(root.left, temp.val);
            }
        }
        return root;
    }

    public static void printLevel(TreeNode root) {
        if (root == null) return;

        ArrayList<Integer> res = new ArrayList<>();
        TreeNode last = root;

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offerLast(root);

        while (!q.isEmpty()) {
            TreeNode node = q.pollFirst();
            res.add(node.val);
            if (node.left != null) q.offerLast(node.left);
            if (node.right != null) q.offerLast(node.right);

            if (node == last) {
                System.out.println(res);
                res = new ArrayList<>();
                last = q.peekLast();
            }
        }
    }
}
