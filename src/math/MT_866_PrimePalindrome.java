package math;
/*
866. Prime Palindrome
Given an integer n, return the smallest prime palindrome greater than or equal to n.

An integer is prime if it has exactly two divisors: 1 and itself. Note that 1 is not a prime number.

For example, 2, 3, 5, 7, 11, and 13 are all primes.
An integer is a palindrome if it reads the same from left to right as it does from right to left.

For example, 101 and 12321 are palindromes.
The test cases are generated so that the answer always exists and is in the range [2, 2 * 108].



Example 1:

Input: n = 6
Output: 7
Example 2:

Input: n = 8
Output: 11
Example 3:

Input: n = 13
Output: 101


Constraints:

1 <= n <= 108
 */
public class MT_866_PrimePalindrome {
    public int primePalindrome(int n) {
        System.out.println(isPrime(3));
        if(n <= 2) return 2;
        if(n <= 3) return 3;
        if(n <= 5) return 5;
        if(n <= 7) return 7;
        if(n <= 11) return 11;
        for(int i = 1; i < 100000000; i++){
            String str = Integer.toString(i);
            String rev = new StringBuilder(str.substring(0, str.length()-1)).reverse().toString();
            Integer val = Integer.parseInt(str + rev);
            if(val >= n && isPrime(val)) return val;
        }
        return -1;
    }
    public boolean isPrime(int n){
        if(n <= 1) return false;
        if(n == 2) return true;
        if(n % 2 == 0) return false;
        for(int i = 3; i * i <= n; i += 2){
            /*
            Check loop condition:
                i = 3
                i * i = 9
                9 <= 3 (false)
             */
            if(n % i == 0) return false;
        }
        return true;
    }
}
