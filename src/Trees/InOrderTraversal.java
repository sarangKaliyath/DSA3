package Trees;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
Given a binary tree, return the inorder traversal of its nodes' values.

Problem Constraints
1 <= number of nodes <= 10^5

Input Format
First and only argument is root node of the binary tree, A.

Output Format
Return an integer array denoting the inorder traversal of the given binary tree.

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
Output 1: [1, 3, 2]
Output 2: [6, 1, 3, 2]

Example Explanation:
Explanation 1: The Inorder Traversal of the given tree is [1, 3, 2].
Explanation 2: The Inorder Traversal of the given tree is [6, 1, 3, 2].
 */
public class InOrderTraversal {

    public  static  void main (String [] args){

        ArrayList<Integer > A = new ArrayList<>(Arrays.asList(1, 6, 2, null, null, 3, null));
        BuildIntegerTree treeBuilder = new BuildIntegerTree();
        TreeNode root = treeBuilder.BuildIntegerTree(A);

        ArrayList<Integer> res = new ArrayList<>();
        inOrderTraversal(root, res);
        System.out.println(res);
        // Time O(N);
        // Space O(Height of Tree);
    }

    public  static  void inOrderTraversal(TreeNode root, ArrayList<Integer> res){
        if(root == null) return;
        inOrderTraversal(root.left, res);
        res.add(root.val);
        inOrderTraversal(root.right, res);
    }
}
