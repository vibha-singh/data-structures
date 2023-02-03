package main.geeksForGeeks.dataStructure.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
    static class Activity implements Comparable<Activity> {
        int start;
        int end;
        Activity(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Activity o) {
            return this.end - o.end ;
        }
    }

    public static int activitySelection(int start[], int end[], int n)
    {
        // add your code here
        Activity[] activity = new Activity[n];
        for(int i = 0; i< n ;i++){
            activity[i] = new Activity(start[i], end[i]);
        }

        Arrays.sort(activity);
        int res = 1;
        Activity prev = activity[0];

        for(int curr = 1; curr<n ; curr++){
            if(activity[curr].start > prev.end){
                res++;
                prev = activity[curr];
            }
        }

        return res;
    }


}
