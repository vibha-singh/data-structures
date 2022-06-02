package leetcode;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 *
 */

public class Median_of_Two_Sorted_Arrays_4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int x = nums1.length;
        int y = nums2.length;

        int low = 0;
        int high = x;
        while(low <= high){
            int partX = (low + high) /2;
            int partY = (x+y+1)/2 - partX;

            int leftX = (partX == 0)? Integer.MIN_VALUE : nums1[partX -1];
            int rightX = (partX == x)? Integer.MAX_VALUE : nums1[partX];

            int leftY = (partY == 0) ? Integer.MIN_VALUE : nums2[partY -1];
            int rightY = (partY == y) ? Integer.MAX_VALUE : nums2[partY];

            if(leftX <= rightY && leftY <= rightX ){
                if ((x + y) % 2 == 0) {
                    return ((double)Math.max(leftX, leftY) + Math.min(rightX, rightY))/2;
                } else {
                    return (double)Math.max(leftX, leftY);
                }
            } else if(leftX > rightY){
                high = partX -1;
            } else {
                low = partX +1;
            }

        }

        return -1;

    }



}
