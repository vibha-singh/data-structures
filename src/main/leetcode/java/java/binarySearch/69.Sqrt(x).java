package main.leetcode.java.java.binarySearch;

/**69. Sqrt(x)
 Easy

 4139

 3309

 Add to List

 Share
 Given a non-negative integer x, compute and return the square root of x.

 Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.

 Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.



 Example 1:

 Input: x = 4
 Output: 2
 Example 2:

 Input: x = 8
 Output: 2
 Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.


 Constraints:

 0 <= x <= 231 - 1
 **/
class SquareRoot {
    public int mySqrt(int x) {
        if(x< 0)
            return -1;
        else if(x== 0)
            return 0;
        else if( x < 4)
            return 1;

        int low = 1;
        int high = x;

        while(low < high){
            int mid = low + (high-low)/2;

            if(x/mid == mid){
                return mid;
            } else if(x/mid > mid){
                low = mid +1;
            } else{
                high = mid;
            }
        }

        return low -1;

    }
}