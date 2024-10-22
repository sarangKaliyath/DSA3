package Trees;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*
Problem Description
Given a binary tree A. Check whether it is possible to partition the tree to two trees
which have equal sum of values after removing exactly one edge on the original tree.

Problem Constraints
1 <= size of tree <= 100000
0 <= value of node <= 10^9

Input Format
First and only argument is head of tree A.

Output Format
Return 1 if the tree can be partitioned into two trees of equal sum else return 0.

Example Input:
Input 1:
                5
               /  \
              3    7
             / \  / \
            4  6  5  6

Input 2:
                1
               / \
              2   10
                  / \
                 20  2

Example Output:
Output 1: 1
Output 2: 0

Example Explanation

Explanation 1:
 Remove edge between 5(root node) and 7:
        Tree 1 =                                               Tree 2 =
                        5                                                     7
                       /                                                     / \
                      3                                                     5   6
                     / \
                    4   6
        Sum of Tree 1 = Sum of Tree 2 = 18

Explanation 2:
 The given Tree cannot be partitioned.

 */
public class EqualTreePartition {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(6, 9, 4, null, null, 8, null, null, 3, null, null));
        BuildIntegerTree treeBuilder = new BuildIntegerTree();
        TreeNode root = treeBuilder.BuildIntegerTree(A);

        int res = firstApproach(root);
        System.out.println(res);
        // Time O(N);
        // Space O(N);

        int res2 = betterApproach(root);
        System.out.println(res2);
        // Time O(N):
        // Space O(N);
    }

    public static int betterApproach(TreeNode root) {
        long totalSum = getJustSum(root);
        if ((totalSum & 1) > 0) return 0;
        return check(root, totalSum >> 1) ? 1 : 0;
    }

    public static boolean check(TreeNode root, long sum) {
        if (root == null) return false;
        if (check(root.left, sum) || check(root.right, sum)) return true;
        return getJustSum(root) == sum;
    }

    public static long getJustSum(TreeNode root) {
        if (root == null) return 0;
        return (long) root.val + getJustSum(root.left) + getJustSum(root.right);
    }

    //****************************************************************************

    public static int firstApproach(TreeNode root) {
        HashSet<Long> hs = new HashSet<>();
        long totalSum = getHsSum(root, hs);
        if ((totalSum & 1) > 0) return 0;
        return hs.contains(totalSum >> 1) ? 1 : 0;
    }

    public static long getHsSum(TreeNode root, HashSet<Long> hs) {
        if (root == null) return 0;
        long sum = (long) root.val + getHsSum(root.left, hs) + getHsSum(root.right, hs);
        hs.add(sum);
        return sum;
    }
}
