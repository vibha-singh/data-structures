package geeksForGeeks.dataStructure.strings;

import java.util.Arrays;
import java.util.Stack;

public class Larges_Rectangular_Area_in_a_Histogram {

    public static int[] findRightSmallerElement(int[] input)
    {
        // base case
        if (input == null) {
            return input;
        }

        int[] result = new int[input.length];
        Arrays.fill(result, -1);

        // create an empty stack
        Stack<Integer> s = new Stack<>();

        // do for each element
        for (int i = input.length - 1; i >= 0; i--)
        {
            // loop till we have a greater element on top or stack becomes empty.
            while (!s.empty())
            {
                // pop elements that aren't greater than the current element
                if (input[s.peek()] > input[i]) {
                    s.pop();
                }
                // the next greater element is now on the top of the stack
                else {
                    result[i] = s.peek();
                    break;
                }
            }

            // push current element into the stack
            s.push(i);
        }

        return result;
    }

    public static int[] findLeftSmallerElement(int[] input)
    {
        // base case
        if (input == null) {
            return input;
        }

        int[] result = new int[input.length];
        Arrays.fill(result, -1);

        // create an empty stack
        Stack<Integer> s = new Stack<>();

        // do for each element
        for (int i = 0; i < input.length; i++)
        {
            // loop till we have a greater element on top or stack becomes empty.
            while (!s.empty())
            {
                // pop elements that aren't greater than the current element
                if (input[s.peek()] > input[i]) {
                    s.pop();
                }
                // the next greater element is now on the top of the stack
                else {
                    result[i] = s.peek();
                    break;
                }
            }

            // push current element into the stack
            s.push(i);
        }

        return result;
    }

    public static void main(String[] args)
    {
        int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
        int[] a = findRightSmallerElement(hist);
        int[] b = findLeftSmallerElement(hist);
//        for(int i = 0; i< a.length ; i++){
//            System.out.print(a[i]);
//
//        }
//        System.out.println("");
//
//        for(int i = 0; i< a.length ; i++){
//            System.out.print(b[i]);
//        }
//        System.out.println("");
//        //15355-1-1
//        //-1-1113-15
        int max = 0;
        for(int i = 0; i< a.length ; i++){
            if(a[i] == -1) a[i] = hist.length;
          max = Math.max(max, hist[i] *(a[i] - b[i] - 1));
        }
        System.out.println(max);
    }
}
