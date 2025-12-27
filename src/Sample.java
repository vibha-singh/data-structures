/**
 * Rotated sorted array:
 * 1,2,3,4,5
 *
 * i/p: 4,5,1,2,3 (distinct integers)
 *      0,1,2.3.4
 *
 *      5-1/2 = 2
 *      if(valueToFind < arr[mid])  //4 <1
 *
 *      else if(valueToFind > arr[mid])
 *
 *      else
 *       return mid
 *
 *
 * index of 4
 *
 * index of 2
 * o/p: 3
 */

public class Sample {
    public static void main(String args[]) {
        /**
         * left, right
         */
        int[] arr = {4,5,1,2,3};
        int valueToFind = 2;
        System.out.println(findIndexOfElement1(arr, 5));
        System.out.println(findIndexOfElement1(arr, 4));
        System.out.println(findIndexOfElement1(arr, 2));
        System.out.println(findIndexOfElement1(arr, 3));

    }

    public static Integer findIndexOfElement(int[] arr, int valueToFind){
        int leftMid, rightMid;
        int currMid = (arr.length -1) /2;
//        System.out.println(currMid);
        while(currMid > 0 && currMid <arr.length) {
            if(valueToFind > arr[currMid]){
                leftMid = currMid/2;
                if(arr[leftMid] > valueToFind )
                    currMid = leftMid;
                else if(arr[leftMid] < valueToFind){

                }
            } else if(valueToFind < arr[currMid]) {
                rightMid = (arr.length - currMid)/2;
                if(arr[rightMid] < valueToFind )
                    currMid = rightMid;
            } else
                return currMid;
        }

        //left= 0, right= length-1
        // left<= right
        /**
         * mid = ((left + right) - 1)/2
         *
         *
         */

        return -1;

    }

    public static Integer findIndexOfElement1(int[] arr, int valueToFind){
       int left = 0, right = arr.length -1, mid ;
       while(left <= right) {
           mid = (left+right) / 2;
           if(arr[mid] == valueToFind) {
               return mid;
           }else if(arr[left] <= arr[mid]) {
               if(arr[left] <= valueToFind && valueToFind < arr[mid]){
                   right = mid -1;
               } else
                    left = mid +1;
           } else {
               if(arr[mid] < valueToFind && valueToFind <= arr[right]){
                   left = mid +1;
               } else
                   right = mid -1;
           }
       }
        return -1;
    }
}
