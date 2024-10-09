package LinkedList;

/*
Problem Description
You are given A which is the head of a linked list. Also given is the value B and position C.
Complete the function that should insert a new node with the said value at the given position.
Notes:
    In case the position is more than length of linked list, simply insert the new node at the tail only.
    In case the pos is 0, simply insert the new node at head only.
    Follow 0-based indexing for the node numbering.

Problem Constraints
0 <= size of linked list <= 10^5
1 <= value of nodes <= 10^9
1 <= B <= 10^9
0 <= C <= 10^5

Input Format
The first argument A is the head of a linked list.
The second argument B is an integer which denotes the value of the new node
The third argument C is an integer which denotes the position of the new node

Output Format
Return the head of the linked list

Example Input
Input 1:
A = 1 -> 2
B = 3
C = 0

Input 2:
A = 1 -> 2
B = 3
C = 1

Example Output
Output 1: 3 -> 1 -> 2
Output 2: 1 -> 3 -> 2

Example Explanation
For Input 1:
The new node is add to the head of the linked list
For Input 2:
The new node is added after the first node of the linked list

 */
//class  ListNode {
//    public int val;
//    public ListNode next;
//
//    public  void ListNode(int val){
//        this.val = val;
//        this.next = null;
//    }
//}
public class InsertInLinkedList {

    public static void main(String[] args) {

        int[] A = {6, 3, 3, 6, 7, 8, 7, 3, 7};
        int B = 3;
        int C = 5;

        ListNode head = new ListNode(6);

        ListNode tempInitial = head;

        for (int i = 1; i < A.length; i++) {
            tempInitial.next = new ListNode(A[i]);
            tempInitial = tempInitial.next;
        }


        int len = findListLen(head);

        if(C > len) C = len;

        ListNode insertNode = new ListNode(B);

        if(C == 0){
            insertNode.next = head;
            head = insertNode;
        }
        else {

            ListNode current = head;

            for(int i = 1; i < C; i++){
                current = current.next;
            }

            insertNode.next = current.next;
            current.next = insertNode;
        }

        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

        // Time O(N);
        // Space O(1);
    }

    public static int findListLen(ListNode A){
        int len = 0;
        ListNode copyList = A;
        while(copyList != null){
            len++;
            copyList = copyList.next;
        }
        return len;
    }

}
