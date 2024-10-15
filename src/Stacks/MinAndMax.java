package Stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*
Problem Description
Given an array of integers A.
The value of an array is computed as the difference between the maximum
element in the array and the minimum element in the array A.
Calculate and return the sum of values of all possible subArrays of A modulo 10^9+7.

Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 1000000

Input Format
The first and only argument given is the integer array A.

Output Format
Return the sum of values of all possible subArrays of A modulo 109+7.

Example Input
Input 1: A = [1]
Input 2: A = [4, 7, 3, 8]

Example Output:
Output 1: 0
Output 2: 26

Example Explanation

Explanation 1:
Only 1 subArray exists. Its value is 0.

Explanation 2:
value ( [4] ) = 4 - 4 = 0
value ( [7] ) = 7 - 7 = 0
value ( [3] ) = 3 - 3 = 0
value ( [8] ) = 8 - 8 = 0
value ( [4, 7] ) = 7 - 4 = 3
value ( [7, 3] ) = 7 - 3 = 4
value ( [3, 8] ) = 8 - 3 = 5
value ( [4, 7, 3] ) = 7 - 3 = 4
value ( [7, 3, 8] ) = 8 - 3 = 5
value ( [4, 7, 3, 8] ) = 8 - 3 = 5
sum of values % 10^9+7 = 26

 */
public class MinAndMax {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(994390, 986616, 976849, 979707, 950477, 968402, 992171, 937674, 933065, 960863, 980981, 937319, 951236, 959547, 991052, 991799, 992213, 941294, 978103, 997198, 960759, 988476, 963517, 980366, 921767, 979757, 977912, 983761, 981869, 947454, 930202, 999086, 973538, 999798, 996446, 944001, 974217, 951595, 942688, 975075, 970973, 970130, 897109, 927660, 862233, 997130, 986068, 954098, 978175, 889682, 988973, 996036, 969675, 985751, 977724, 881538, 988613, 924230, 906475, 915565, 986952, 975702, 994316, 964011, 986848, 983699, 949076, 989673, 981788, 929094, 988310, 926471, 994763, 999736, 980762, 973560, 996622, 934475, 998365, 966255, 998697, 998700, 911868, 983245, 996382, 996992, 953142, 994104, 987303, 853837, 960626, 904203, 998063, 977596, 977868, 996012, 946345, 949255, 988138, 996298, 954933, 965036, 886976, 998628, 990878, 953725, 916744, 985233, 919661, 970903, 986066));
        int n = A.size();

        bruteForce(A, n);
        // Time O(N^2);
        // Space O(1);
        optimized(A, n);
        // Time O(N);
        // Space O(N);
    }

    public static void bruteForce(ArrayList<Integer> A, int n) {

        int ans = 0;

        for (int i = 0; i < n; i++) {

            int minVal = A.get(i);
            int maxVal = A.get(i);

            for (int j = i; j < n; j++) {

                minVal = Math.min(minVal, A.get(j));
                maxVal = Math.max(maxVal, A.get(j));
                ans += maxVal - minVal;

            }
        }
        System.out.println(ans);
        // Time O(N + N + N);
        // Space O(N + N + N);
    }

    public static void optimized(ArrayList<Integer> A, int n) {

        int MOD = (int) Math.pow(10, 9) + 7;
        int[] greaterToLeft = findNearestGreaterToLeft(A, n);
        int[] greaterToRight = findNearestGreaterToRight(A, n);
        int[] smallerToLeft = findNearestSmallerToLeft(A, n);
        int[] smallerToRight = findNearestSmallerToRight(A, n);

        long ans = 0;

        for (int i = 0; i < n; i++) {
            long maxContribution = (long) (i - greaterToLeft[i]) * (greaterToRight[i] - i) % MOD;
            long minContribution = (long) (i - smallerToLeft[i]) * (smallerToRight[i] - i) % MOD;

            ans = (ans + (A.get(i) * (maxContribution - minContribution + MOD) % MOD)) % MOD;
        }

        System.out.print(ans);
    }

    public static int[] findNearestGreaterToLeft(ArrayList<Integer> A, int n) {

        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && A.get(stack.peek()) <= A.get(i)) {
                stack.pop();
            }

            if (stack.isEmpty()) res[i] = -1;
            else res[i] = stack.peek();

            stack.push(i);
        }
        return res;
        // Time O(N);
        // Space O(N);
    }

    public static int[] findNearestGreaterToRight(ArrayList<Integer> A, int n) {

        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && A.get(stack.peek()) <= A.get(i)) {
                stack.pop();
            }

            if (stack.isEmpty()) res[i] = n;
            else res[i] = stack.peek();

            stack.push(i);
        }
        return res;
        // Time O(N);
        // Space O(N);
    }

    public static int[] findNearestSmallerToLeft(ArrayList<Integer> A, int n) {

        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && A.get(stack.peek()) >= A.get(i)) {
                stack.pop();
            }
            if (stack.isEmpty()) res[i] = -1;
            else res[i] = stack.peek();

            stack.push(i);
        }
        return res;
        // Time O(N);
        // Space O(N);
    }

    public static int[] findNearestSmallerToRight(ArrayList<Integer> A, int n) {

        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && A.get(stack.peek()) >= A.get(i)) {
                stack.pop();
            }

            if (stack.isEmpty()) res[i] = n;
            else res[i] = stack.peek();

            stack.push(i);
        }
        return res;
        // Time O(N);
        // Space O(N);
    }
}
