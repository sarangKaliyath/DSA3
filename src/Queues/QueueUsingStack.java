package Queues;
import java.util.*;
/*
Problem Description
Implement a First In First Out (FIFO) queue using stacks only.
The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
Implement the UserQueue class:
void push(int X) : Pushes element X to the back of the queue.
int pop() : Removes the element from the front of the queue and returns it.
int peek() : Returns the element at the front of the queue.
boolean empty() : Returns true if the queue is empty, false otherwise.
NOTES:
You must use only standard operations of a stack, which means only push to top,
peek/pop from top, size, and is empty operations are valid.
Depending on your language, the stack may not be supported natively.
You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.

Problem Constraints
1 <= X <= 10^9

At most 1000 calls will be made to push, pop, peek, and empty function.
All the calls to pop and peek are valid. i.e. pop and peek are called only when the queue is non-empty.

Example Input

Input 1:
 1) UserQueue()
 2) push(20)
 3) empty()
 4) peek()
 5) pop()
 6) empty()
 7) push(30)
 8) peek()
 9) push(40)
 10) peek()

Input 2:
 1) UserQueue()
 2) push(10)
 3) push(20)
 4) push(30)
 5) pop()
 6) pop()

Example Output

Output 1:
 false
 20
 20
 true
 30
 30

Output 2:
 10
 20

Example Explanation

Explanation 1:
 Queue => 20
 Queue => -
 Queue => 30
 Queue => 30, 40

Explanation 2:
 Queue => 10
 Queue => 10, 20
 Queue => 10, 20, 30
 Queue => 20, 30
 Queue => 30

 */
public class QueueUsingStack {
    private static final Stack<Integer> stack1 = new Stack<>();
    private static final Stack<Integer> stack2 = new Stack<>();

    QueueUsingStack() {

    }

    /** Push element X to the back of queue. */
    static void push(int X) {
        stack1.push(X);
        // Time O(1);
    }

    /** Removes the element from in front of queue and returns that element. */
    static int pop() {
        if(stack2.isEmpty()) move();
        return stack2.pop();
        //Time O(1);
    }

    /** Get the front element of the queue. */
    static int peek() {
        if(stack2.isEmpty()) move();
        return stack2.peek();
        // Time O(1);
    }

    /** Returns whether the queue is empty. */
    static boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
        // Time O(1);
    }

    static void move(){
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        /*
            If stack2 is not empty, the top element is popped in constant time.
            If stack2 is empty, the elements from stack1 are moved to stack2,
            which takes O(n) time for n elements. However,
            each element will be moved from stack1 to stack2 only once during the lifetime of the queue,
            so this results in an amortized O(1) time for each operation.
         */
    }
}
