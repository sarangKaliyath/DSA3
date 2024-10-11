package LinkedList;

/*
Problem Description
Given a sorted linked list, delete all duplicates such that each element appears only once.

Problem Constraints
0 <= length of linked list <= 10^6

Input Format
First argument is the head pointer of the linked list.

Output Format
Return the head pointer of the linked list after removing all duplicates.

Example Input
Input 1: 1->1->2
Input 2: 1->1->2->3->3

Example Output
Output 1: 1->2
Output 2: 1->2->3

Example Explanation

Explanation 1:
 Each element appear only once in 1->2.

 */
public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {

        int [] arr = {2, 3};

        ListNode A = new ListNode(1);

        ListNode head = A;

        for(int i = 0; i < arr.length; i++){
            head.next = new ListNode(arr[i]);
            head = head.next;
        }

        head = A;

        deleteRepeated(head);
        // Time O(N);
        // Space O(1);
    }

    public  static  void deleteRepeated(ListNode head){

        ListNode prev = head;
        ListNode current = head;

        while (current != null){
            if((prev.val != current.val)){
                prev.next = current;
                prev = current;
            }
            else current = current.next;
        }

        if(prev != null){
            prev.next = current;
        }
        current = head;
        printList(current);
    }

    public  static  void printList (ListNode head){
        ListNode current =head;
        while (current != null){
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
