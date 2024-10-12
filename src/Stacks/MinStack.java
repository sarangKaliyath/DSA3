package Stacks;

import java.util.*;

/*
Problem Description
Design a stack that supports push, pop, top, and retrieve the minimum element in constant time.
    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.

NOTE:
    All the operations have to be constant time operations.
    getMin() should return -1 if the stack is empty.
    pop() should return nothing if the stack is empty.
    top() should return -1 if the stack is empty.

Problem Constraints
1 <= Number of Function calls <= 10^7

Input Format
Functions will be called by the checker code automatically.

Output Format
Each function should return the values as defined by the problem statement.

Example Input
Input 1:
push(1)
push(2)
push(-2)
getMin()
pop()
getMin()
top()

Input 2:
getMin()
pop()
top()

Example Output
Output 1: -2 1 2
Output 2: -1 -1

Example Explanation:
Explanation 1:
Let the initial stack be : []
1) push(1) : [1]
2) push(2) : [1, 2]
3) push(-2) : [1, 2, -2]
4) getMin() : Returns -2 as the minimum element in the stack is -2.
5) pop() : Return -2 as -2 is the topmost element in the stack.
6) getMin() : Returns 1 as the minimum element in stack is 1.
7) top() : Return 2 as 2 is the topmost element in the stack.

Explanation 2:
Let the initial stack be : []
1) getMin() : Returns -1 as the stack is empty.
2) pop() :  Returns nothing as the stack is empty.
3) top() : Returns -1 as the stack is empty.


Expected Output
Enter your input as per the following guideline:
There are 1 lines in the input

Line 1 ( Corresponds to arg 1 ) : The line starts with a number numOperations, corresponding to the number of operations.
Then "numOperation" operations follow.
Each operation is either :
 * P  : Corresponds to push() in stack
 * p : Corresponds to pop()
 * t : Corresponds to top()
 * g : Corresponds to getMin() call.
Note that the function calls are made in order.


 */
public class MinStack {

    // Not Runnable;
    // Time O(1);
    // Space O(N);
    ArrayList<Integer> stack = new ArrayList<>();
    int top = -1;
    ArrayList<Integer> minStack = new ArrayList<>();

    public void push(int x) {
        top++;
        stack.add(x);

        if (minStack.size() == 0 || x <= minStack.get(minStack.size() - 1)) {
            minStack.add(x);
        }
    }

    public void pop() {
        if (top != -1) {
            if (stack.get(top).equals(minStack.get(minStack.size() - 1))) {
                minStack.remove(minStack.size() - 1);
            }
            stack.remove(top--);
        }
    }

    public int top() {
        if (top == -1) return -1;
        return stack.get(top);
    }

    public int getMin() {
        if (minStack.size() == 0) return -1;
        return minStack.get(minStack.size() - 1);
    }
}
