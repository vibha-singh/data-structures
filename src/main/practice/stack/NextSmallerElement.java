package main.practice.stack;

import java.util.Stack;

public class NextSmallerElement {
    public static void main(String[] args) {
        int [] arr = {4,5,2,25};
        Stack<Integer> st = new Stack<>();
        int n = arr.length-1;
        st.push(arr[n]);
        arr[n] = -1;
        for(int i = n-1; i>=0; i--) {
            int currValue = arr[i];
            while(!st.isEmpty() && st.peek() >= currValue) st.pop();
            arr[i] = st.isEmpty() ? -1 : st.peek();
            st.push(currValue);
        }

        for(int i = 0; i<=n; i++) {
            System.out.print(arr[i] +" ");
        }

    }
}
