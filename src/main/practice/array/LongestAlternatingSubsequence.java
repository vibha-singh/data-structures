package main.practice.array;

/**
 *A sequence {x1, x2, .. xn} is alternating sequence if its elements satisfy one of the following relations :
 * x1 < x2 > x3 < x4 > x5..... or  x1 >x2 < x3 > x4 < x5.....
 * Your task is to find the longest such sequence.
 *
 * Input: nums = {1,5,4}
 * Output: 3
 * Explanation: The entire sequenece is a
 * alternating sequence.
 */
public class LongestAlternatingSubsequence {
    public static void main(String[] args) {
        int [] arr = {1,17,5,10,13,15,10,5,16,8};
        System.out.println(alternatingMaxLength(arr));

    }

    public static int alternatingMaxLength(int[] nums)
    {
        int mi=1;
        int ma=1;
        for(int i = 1; i<nums.length; i++){
            if (nums[i]<nums[i-1])
                mi = ma+1;
            else if (nums[i]>nums[i-1])
                ma = mi+1;
        }
        return Math.max(mi,ma);
    }
}
