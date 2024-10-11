package LinkedList;

import java.util.LinkedList;

/*
Problem Description
Given a singly linked list A and an integer B, reverse the nodes of the list B at a time and return the modified linked list.

Problem Constraints
1 <= |A| <= 10^3
B always divides A

Input Format
The first argument of input contains a pointer to the head of the linked list.
The second argument of input contains the integer, B.

Output Format
Return a pointer to the head of the modified linked list.

Example Input

Input 1:
 A = [1, 2, 3, 4, 5, 6]
 B = 2

Input 2:
 A = [1, 2, 3, 4, 5, 6]
 B = 3

Example Output
Output 1: [2, 1, 4, 3, 6, 5]
Output 2: [3, 2, 1, 6, 5, 4]

Example Explanation

Explanation 1:
 For the first example, the list can be reversed in groups of 2.
    [[1, 2], [3, 4], [5, 6]]
 After reversing the K-linked list
    [[2, 1], [4, 3], [6, 5]]

Explanation 2:
 For the second example, the list can be reversed in groups of 3.
    [[1, 2, 3], [4, 5, 6]]
 After reversing the K-linked list
    [[3, 2, 1], [6, 5, 4]]
 */
public class KReverseLinkedList {

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5, 6};
        int B = 2;

        ListNode A = new ListNode(0);

        ListNode head = A;

        for (int i = 0; i < arr.length; i++) {
            head.next = new ListNode(arr[i]);
            head = head.next;
        }

        head = A.next;

        ListNode reverseList = ReverseList(head, B);
        // Time O(N);
        // Space O(N/B);

        PrintList(reverseList);
    }

    public static ListNode ReverseList(ListNode head, int B) {

        if (head == null) return null;

        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        int count = 0;

        while (current != null && count < B) {

            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;

        }

        if (next != null) {
            head.next = ReverseList(next, B);
        }

        return prev;
    }

    public static void PrintList(ListNode A) {
        ListNode current = A;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

}
