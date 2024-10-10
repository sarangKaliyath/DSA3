package LinkedList;

import java.util.*;

/*
Problem Description
    You are given a linked list A
    Each node in the linked list contains two pointers: a next pointer and a random pointer
    The next pointer points to the next node in the list
    The random pointer can point to any node in the list, or it can be NULL
    Your task is to create a deep copy of the linked list A
    The copied list should be a completely separate linked list from the original list,
    but with the same node values and random pointer connections as the original list
    You should create a new linked list B, where each node in B has the same value as the corresponding node in A
    The next and random pointers of each node in B should point to the corresponding nodes in B (rather than A)

Problem Constraints
0 <= |A| <= 10^6

Input Format
The first argument of input contains a pointer to the head of linked list A.

Output Format
Return a pointer to the head of the required linked list.

Example Input
Given list
  1 -> 2 -> 3
with random pointers going from
  1 -> 3
  2 -> 1
  3 -> 1

Example Output
  1 -> 2 -> 3
with random pointers going from
  1 -> 3
  2 -> 1
  3 -> 1

Example Explanation
You should return a deep copy of the list.
The returned answer should not contain the same node as the original list,
but a copy of them. The pointers in the returned list should not link to any node in the original input list
 */
class RandomListNode {
    int label;
    RandomListNode next;
    RandomListNode random;

    public RandomListNode(int x) {
        this.label = x;
        this.next = null;
        this.random = null;
    }
}

public class CopyList {
    public static void main(String[] args) {
        // Input array with node labels and their random pointer mapping
        int[][] arr = {{1, 3}, {2, 1}, {3, 1}};

        // Create the linked list from the array
        RandomListNode head = createRandomList(arr);

        // Print the list to verify
        printList(head);

        createDeepCopyFirstApproach(head);
        // Time O(N);
        // Space O(N);

        deepCopyOptimized(head);
        // Time O(N);
        // Space O(1);
    }

    public static void createDeepCopyFirstApproach(RandomListNode head) {

        RandomListNode head2 = new RandomListNode(head.label);

        HashMap<RandomListNode, RandomListNode> hm = new HashMap<>();

        RandomListNode current1 = head;
        RandomListNode current2 = head2;

        hm.put(current1, current2);

        while (current1.next != null) {

            current2.next = new RandomListNode(current1.next.label);
            hm.put(current1.next, current2.next);
            current1 = current1.next;
            current2 = current2.next;
        }

        current1 = head;
        current2 = head2;

        while (current1 != null) {
            current2.random = hm.get(current1.random);
            current1 = current1.next;
            current2 = current2.next;
        }
        System.out.println("Deep Copy");
        printList(head2);
    }

    public static void deepCopyOptimized(RandomListNode head) {


        RandomListNode current = head;

        while (current != null) {

            RandomListNode tempNode = new RandomListNode(current.label);

            tempNode.next = current.next;

            current.next = tempNode;

            current = tempNode.next;
        }

        current = head;

        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        RandomListNode head2 = head.next;
        RandomListNode temp1 = head;
        RandomListNode temp2 = head2;

        while (temp1 != null) {
            temp1.next = temp1.next.next;

            if (temp2.next != null) {
                temp2.next = temp2.next.next;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        System.out.println("Optimized");
        printList(head2);
    }


    // Function to create a linked list from the input array
    public static RandomListNode createRandomList(int[][] arr) {
        if (arr.length == 0) {
            return null; // Return null if the array is empty
        }

        // HashMap to store label to node mapping
        HashMap<Integer, RandomListNode> nodeMap = new HashMap<>();

        // Create all nodes and store them in the map
        RandomListNode head = new RandomListNode(arr[0][0]);
        nodeMap.put(arr[0][0], head);

        RandomListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            RandomListNode newNode = new RandomListNode(arr[i][0]);
            current.next = newNode;
            nodeMap.put(arr[i][0], newNode);
            current = newNode;
        }

        // Assign random pointers using the second element of each pair in arr
        current = head;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][1] != -1) {
                current.random = nodeMap.get(arr[i][1]);
            }
            current = current.next;
        }

        return head;
    }

    // Helper function to print the list with next and random pointers
    public static void printList(RandomListNode head) {
        RandomListNode current = head;
        while (current != null) {
            int randomLabel = current.random != null ? current.random.label : -1;
            System.out.println("Node " + current.label + " -> next: " +
                    (current.next != null ? current.next.label : "null") +
                    ", random: " + randomLabel);
            current = current.next;
        }
    }

}
