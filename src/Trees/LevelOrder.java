package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

/*
Problem Description
Given a binary tree, return the level order traversal of its nodes' values.
(i.e., from left to right, level by level).

Problem Constraints
1 <= number of nodes <= 10^5

Input Format
First and only argument is root node of the binary tree, A.

Output Format
Return a 2D integer array denoting the level order traversal of the given binary tree.

Example Input

Input 1:
    3
   / \
  9  20
    /  \
   15   7

Input 2:
   1
  / \
 6   2
    /
   3

Example Output

Output 1:
 [
   [3],
   [9, 20],
   [15, 7]
 ]

Output 2:
 [
   [1]
   [6, 2]
   [3]
 ]

Example Explanation:
Explanation 1:
 Return the 2D array. Each row denotes the traversal of each level.
 */
public class LevelOrder {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(3, 9, 20, null, 15, 7));
        BuildIntegerTree treeBuilder = new BuildIntegerTree();
        TreeNode root = treeBuilder.BuildIntegerTree(A);
        ArrayList<ArrayList<Integer>> res = leverOrderTraversal(root);
        System.out.print(res);
        // Time O(N);
        // Space O(N);
    }

    public static ArrayList<ArrayList<Integer>> leverOrderTraversal(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offerLast(root);
        TreeNode last = root;

        ArrayList<Integer> temp = new ArrayList<>();

        while (!q.isEmpty()) {
            TreeNode current = q.pollFirst();
            temp.add(current.val);

            if (current.left != null) q.offerLast(current.left);
            if (current.right != null) q.offerLast(current.right);

            if (current == last) {
                res.add(temp);
                temp = new ArrayList<>();
                last = q.peekLast();
            }
        }

        return res;
    }

}
