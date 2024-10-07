package LinkedList;

/*
Problem Description
You are given A which is the head of a linked list. Print the linked list in space separated manner.
Note : The last node value must also be succeeded by a space and after printing the entire list you should print a new line

Problem Constraints
1 <= size of linked list <= 10^5
1 <= value of nodes <= 10^9

Input Format
The first argument A is the head of a linked list.

Output Format
You dont need to return anything

Example Input
Input 1:
A = 1 -> 2 -> 3
Input 2:
A = 4 -> 3 -> 2 -> 1

Example Output

Output 1: 1 2 3
Output 2: 4 3 2 1

Example Explanation
For Input 1:
We print the given linked list

For Input 2:
We print the given linked list

 */

class  ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val){
        this.val = val;
        this.next = null;
    }

    /*
    * In Java, it is common practice to place each class in its own file, especially for larger projects.
    * However, for smaller project's its okay to keep the classes in the same file, provided that,
    * only one class is declared as public i.e. the ListNode class must not be marked public.
    * */
}
public class PrintLinkedList {

    public  static void main (String [] args){

        int [] arr = {1, 2, 3};

        ListNode head= new ListNode(1);
        ListNode current = head;

        for(int i = 1; i < arr.length; i++){
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        PrintList(head);
        // Time O( Number of Nodes) -> i.e. O(N);
        // Space O(1);
    }

    public  static  void PrintList(ListNode head){

        ListNode temp = head;

        while (temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

        System.out.println();

    }
}
