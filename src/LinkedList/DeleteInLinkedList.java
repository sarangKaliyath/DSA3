package LinkedList;

/*
Problem Description
You are given the head of a linked list A and an integer B. Delete the B-th node from the linked list.
Note : Follow 0-based indexing for the node numbering.

Problem Constraints
1 <= size of linked list <= 10^5
1 <= value of nodes <= 10^9
0 <= B < size of linked list

Input Format
The first argument A is the head of a linked list.
The second argument B is an integer.

Output Format
Return the head of the linked list after deletion

Example Input
Input 1:
A = 1 -> 2 -> 3
B = 1
Input 2:
A = 4 -> 3 -> 2 -> 1
B = 0

Example Output
Output 1:
1 -> 3
Output 2:
3 -> 2 -> 1

Example Explanation
For Input 1:
The linked list after deletion is 1 -> 3.
For Input 2:
The linked list after deletion is 3 -> 2 -> 1.

 */
public class DeleteInLinkedList {

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};
        int B = 0;

        ListNode A = new ListNode(4);
        ListNode copy = A;

        for (int i = 1; i < arr.length; i++) {
            copy.next = new ListNode(arr[i]);
            copy = copy.next;
        }

        copy = A;

//        deleteLink(copy, B);
        // Time O(B);
        // Space O(1);

        second(copy, B);
        // Time O(B);
        // Space O(1);
    }
    public static void deleteLink(ListNode A, int B) {

        ListNode copy = A;

        if (B == 0) {
            A = A.next;
            copy = A;
        } else {
            int val = 0;

            while (val < B - 1) {
                copy = copy.next;
                val++;
            }

            copy.next = copy.next.next;
            copy = A;
        }


        while (copy != null) {
            System.out.print(copy.val);
            copy = copy.next;
        }

    }

    public  static  void second(ListNode head, int B){
        ListNode current = head;

        if(B == 0){
            head = head.next;
        }
        else {
            for(int i = 1; i < B && current.next != null; i++){
                current = current.next;
            }

            current.next = current.next.next;
        }

        current = head;

        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
