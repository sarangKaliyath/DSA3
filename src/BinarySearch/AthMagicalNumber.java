package BinarySearch;

import java.util.ArrayList;
import java.util.Collections;

/*
Problem Description
You are given three positive integers, A, B, and C.
Any positive integer is magical if divisible by either B or C.
Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.
Note: Ensure to prevent integer overflow while calculating.

Problem Constraints
1 <= A <= 10^9
2 <= B, C <= 40000

Input Format
The first argument given is an integer A.
The second argument given is an integer B.
The third argument given is an integer C.

Output Format
Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.

Example Input

Input 1:
 A = 1
 B = 2
 C = 3
Input 2:
 A = 4
 B = 2
 C = 3

Example Output

Output 1: 2
Output 2: 6

Example Explanation

Explanation 1:
 1st magical number is 2.
Explanation 2:
 First four magical numbers are 2, 3, 4, 6 so the 4th magical number is 6.

 */
public class AthMagicalNumber {

    public static void main(String[] args) {

        int A = 807414236;
        int B = 3788;
        int C = 38141;

        int res = findNumber(A, B, C);
        System.out.println(res);
        // Time O(log ( A * min(B, C));
        // Space O(1);
    }

    public static int findNumber(int A, int B, int C) {

        int MOD = (int) Math.pow(10, 9) + 7;

        long lcm = B * (C / gcd(B, C));

        long left = 1;
        long right = (long) A * Math.min(B, C);
        long ans = 0;

        while (left <= right){

            long mid = left + ((right - left) / 2);

            long count = (mid / B) + (mid / C) - (mid / lcm);

            if(count >= A){
                ans = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }

        return (int) (ans % MOD);
    }

    public static long gcd(long x, long y) {
        if (y == 0) return x;
        return gcd(y, x % y);
    }

}
