package LinkedList;

/*
Problem Description
Reverse a linked list A from position B to C.
NOTE: Do it in-place and in one-pass.

Problem Constraints
1 <= |A| <= 10^6
1 <= B <= C <= |A|

Input Format
The first argument contains a pointer to the head of the given linked list, A.
The second argument contains an integer, B.
The third argument contains an integer C.

Output Format
Return a pointer to the head of the modified linked list.

Example Input
Input 1:
 A = 1 -> 2 -> 3 -> 4 -> 5
 B = 2
 C = 4

Input 2:
 A = 1 -> 2 -> 3 -> 4 -> 5
 B = 1
 C = 5

Example Output
Output 1: 1 -> 4 -> 3 -> 2 -> 5
Output 2: 5 -> 4 -> 3 -> 2 -> 1

Example Explanation:
Explanation 1:
 In the first example, we want to reverse the highlighted part of the given linked list : 1 -> 2 -> 3 -> 4 -> 5
 Thus, the output is 1 -> 4 -> 3 -> 2 -> 5
Explanation 2:
 In the second example, we want to reverse the highlighted part of the given linked list : 1 -> 4 -> 3 -> 2 -> 5
 Thus, the output is 5 -> 4 -> 3 -> 2 -> 1
 */
public class ReverseLinkedList2 {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        int B = 2;
        int C = 4;

        ListNode A = new ListNode(0);
        ListNode copy = A;

        for (int i = 0; i < arr.length; i++) {
            copy.next = new ListNode(arr[i]);
            copy = copy.next;
        }
        copy = A.next;

        PrintList(copy);

        optimized(copy, B, C);
    }

    public static void optimized(ListNode head, int B, int C) {

        if (head == null || B == C) {
            PrintList(head);
        } else {

            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode prev = dummy;

            for (int i = 1; i < B; i++) {
                prev = prev.next;
            }

            ListNode current = prev.next;
            ListNode next = current.next;

            for (int i = 0; i < C - B; i++) {
                current.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = current.next;
            }

            dummy = dummy.next;

            PrintList(dummy);
        }
        // Time O(N);
        // Space O(1);
    }


    public static void bruteForce(ListNode head, int B, int C) {

        // Gives Correct output but is invalid approach,
        // Since it's not an inPlace reversal;

        ListNode current = head;

        int count = 1;
        while (count < B) {
            count++;
            current = current.next;
        }

        ListNode copy = current;

        while (B < C) {

            int runner = B;

            while (runner < C) {
                runner++;
                copy = copy.next;
            }

            int temp = current.val;
            current.val = copy.val;
            copy.val = temp;

            current = current.next;
            copy = current;
            B++;
            C--;
        }

        PrintList(head);
        // Time O(N^2);
        // Space O(1);
    }

    public static void PrintList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
