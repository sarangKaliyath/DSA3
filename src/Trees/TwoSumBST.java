package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*
Problem Description
Given a binary search tree A, where each node contains a positive integer,
and an integer B, you have to find whether there exist two different nodes X and Y such that X.value + Y.value = B.
Return 1 to denote that two such nodes exist. Return 0, otherwise.

Problem Constraints
1 <= size of tree <= 100000
1 <= B <= 10^9

Input Format
First argument is the head of the tree A.
Second argument is the integer B.

Output Format
Return 1 if such a pair can be found, 0 otherwise.

Example Input:
Input 1:
         10
         / \
        9   20
B = 19

Input 2:
          10
         / \
        9   20
B = 40

Example Output:
Output 1: 1
Output 2: 0

Example Explanation:
Explanation 1: 10 + 9 = 19, Hence 1 is returned.
Explanation 2: No such pair exists.

 */
public class TwoSumBST {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(10, 9, 20));
        int B = 19;

        BuildIntegerTree treeBuilder = new BuildIntegerTree();
        TreeNode root = treeBuilder.BuildIntegerTree(A);

        boolean res = firstApproach(root, B);
        System.out.println(res ? 1 : 0);
        // Time O(N);
        // Space(N);

        int out = optimized(root, B);
        System.out.println(out);
        // Time O(N);
        // Space O(Height of Tree);
    }

    public static int optimized(TreeNode A, int B) {
        Stack<TreeNode> minStack = new Stack<TreeNode>();
        Stack<TreeNode> maxStack = new Stack<TreeNode>();
        TreeNode lRoot = A;
        TreeNode rRoot = A;

        while (((minStack.size() > 0) || lRoot != null) || (maxStack.size() > 0) || rRoot != null) {
            if (lRoot != null || rRoot != null) {
                if (lRoot != null) {
                    minStack.push(lRoot);
                    lRoot = lRoot.left;
                }
                if (rRoot != null) {
                    maxStack.push(rRoot);
                    rRoot = rRoot.right;
                }
            } else {
                if (minStack.size() == 0 || maxStack.size() == 0) break;
                TreeNode minNode = minStack.peek();
                TreeNode maxNode = maxStack.peek();

                int sum = minNode.val + maxNode.val;
                if (minNode == maxNode) return 0;
                else if (sum == B) return 1;
                else if (sum < B) lRoot = (minStack.pop()).right;
                else rRoot = (maxStack.pop()).left;
            }
        }
        return 0;
    }


    public static boolean firstApproach(TreeNode root, int B) {
        ArrayList<Integer> res = new ArrayList<>();

        createInOrderArray(root, res);

        int leftPointer = 0;
        int rightPointer = res.size() - 1;

        while (leftPointer < rightPointer) {
            long sum = (long) res.get(leftPointer) + res.get(rightPointer);
            if (sum == B) return true;
            else if (sum < B) leftPointer++;
            else rightPointer--;
        }
        return false;
    }

    public static void createInOrderArray(TreeNode root, ArrayList<Integer> res) {
        if (root == null) return;
        createInOrderArray(root.left, res);
        res.add(root.val);
        createInOrderArray(root.right, res);
    }
}
