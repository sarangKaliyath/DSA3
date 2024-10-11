package LinkedList;

/*
Problem Description
Given a linked list A, remove the B-th node from the end of the list and return its head.
For example, given linked list: 1->2->3->4->5, and B = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.
NOTE: If B is greater than the size of the list, remove the first node of the list.
Try doing it using constant additional space.

Problem Constraints
1 <= |A| <= 10^6

Input Format
The first argument of input contains a pointer to the head of the linked list.
The second argument of input contains the integer B.

Output Format
Return the head of the linked list after deleting the B-th element from the end.

Example Input
Input 1:
A = 1->2->3->4->5
B = 2
Input 2:
A = 1
B = 1

Example Output
Output 1: 1->2->3->5
Output 2:

Example Explanation

Explanation 1:
In the first example, 4 is the second last element.
Explanation 2:
In the second example, 1 is the first and the last element.


 */
public class RemoveNthNodeFromListEnd {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        int B = 5;

        ListNode A = new ListNode(1);
        ListNode copy = A;

        for (int i = 1; i < arr.length; i++) {
            copy.next = new ListNode(arr[i]);
            copy = copy.next;
        }

        printList(A);

        deleteAtK(A, B);
        // Time O(N);
        // Space O(1);
    }

    public  static  void deleteAtK(ListNode head, int B){

        ListNode current = head;

        int len = 0;

        while (current != null){
            len++;
            current = current.next;
        }

        current = head;

        if(B >= len){
            current = current.next;
        }
        else {
            int pos = len - B;
            int currentPos = 0;

            while(currentPos < pos - 1){
                currentPos++;
                current = current.next;
            }

            if(len == 1){
                current = current.next;
            }
            else {
                current.next = current.next.next;
                current = head;
            }

        }

        printList(current);
    }
    public static void printList(ListNode head) {
        ListNode current = head;

        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
