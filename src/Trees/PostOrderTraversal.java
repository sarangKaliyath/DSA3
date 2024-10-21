package Trees;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
Given a binary tree, return the Postorder traversal of its nodes values.

Problem Constraints
1 <= number of nodes <= 10^5

Input Format
First and only argument is root node of the binary tree, A.

Output Format
Return an integer array denoting the Postorder traversal of the given binary tree.

Example Input:
Input 1:
   1
    \
     2
    /
   3

Input 2:
   1
  / \
 6   2
    /
   3

Example Output:
Output 1: [3, 2, 1]
Output 2: [6, 3, 2, 1]

Example Explanation:
Explanation 1:
 The Preorder Traversal of the given tree is [3, 2, 1].
Explanation 2:
 The Preorder Traversal of the given tree is [6, 3, 2, 1].
 */
public class PostOrderTraversal {

    public static  void main (String [] args){

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 6, 2, null, null, 3, null));

        BuildIntegerTree treeBuilder = new BuildIntegerTree();
        TreeNode root = treeBuilder.BuildIntegerTree(A);

        ArrayList<Integer> res = new ArrayList<>();
        postOrderTraversal(root, res);
        System.out.println(res);
    }

    public static  void postOrderTraversal(TreeNode root, ArrayList<Integer> res){
        if(root == null) return;
        postOrderTraversal(root.left, res);
        postOrderTraversal(root.right, res);
        res.add(root.val);
    }
}
