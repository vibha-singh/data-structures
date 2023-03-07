package main.geeksForGeeks;
import java.util.*;

public class A_PLUS_B_EQUALS_C_PLUS_D_IN_AN_ARRAY {
    class pair
    {
        int first, second;
        pair(int f,int s)
        {
            first = f; second = s;
        }
    };

    boolean findPairs(int arr[])
    {
        HashMap<Integer,pair> map = new HashMap<Integer,pair>();
        int n=arr.length;
        for (int i=0; i<n; ++i) {
            for (int j=i+1; j<n; ++j) {
                int sum = arr[i]+arr[j];
                if (!map.containsKey(sum))
                    map.put(sum,new pair(i,j));
                else {
                    pair p = map.get(sum);
                    System.out.println("("+arr[p.first]+", "+arr[p.second]+
                            ") and ("+arr[i]+", "+arr[j]+")");
                    return true;
                }
            }
        }
        return false;
    }

    // Testing program
    public static void main(String args[])
    {
        int arr[] = {3, 4, 7, 1, 2, 9, 8};
        A_PLUS_B_EQUALS_C_PLUS_D_IN_AN_ARRAY a = new A_PLUS_B_EQUALS_C_PLUS_D_IN_AN_ARRAY();
        a.findPairs(arr);
    }
}