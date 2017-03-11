// LeetCode #172 Factorial Trailing Zeroes
// Time: O(logn), Space: O(1)
/* 
Given an integer n, return the number of trailing zeroes in n!.
Note: Your solution should be in logarithmic time complexity.
*/

public class Solution {
    public int trailingZeroes(int n) {
        return n == 0 ?  0 :   n / 5 + trailingZeroes(n / 5);
    }
}

/*
Notes:
The idea is:
The ZERO comes from 10.
The 10 comes from 2 x 5
And we need to account for all the products of 5 and 2. likes 4×5 = 20 ...
So, if we take all the numbers with 5 as a factor, we'll have way more than enough 
even numbers to pair with them to get factors of 10.
Example: How many multiples of 5 are between 1 and 23? There is 5, 10, 15, and 20, 
for four multiples of 5. Paired with 2's from the even factors, this makes for four 
factors of 10, so: 23! has 4 zeros.
*/