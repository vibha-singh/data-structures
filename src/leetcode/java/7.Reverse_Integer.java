package leetcode;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 *
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 *
 *
 *
 * Example 1:
 *
 * Input: x = 123
 * Output: 321
 * Example 2:
 *
 * Input: x = -123
 * Output: -321
 * Example 3:
 *
 * Input: x = 120
 * Output: 21
 */
public class Reverse_Integer_7 {
    public int reverse(int x) {
        boolean isNegative = false;
        if (x < 0){
            isNegative = true;
            x = -x;
        }
        long ans = 0;
        while(x>0){
            ans = (ans*10) + x%10;
            x = x/10;
        }
        if(isNegative){
            ans = -ans;
        }
        if(Integer.MIN_VALUE<=ans && ans<=Integer.MAX_VALUE){
            return (int)ans;
        }
        return 0;

    }
}
