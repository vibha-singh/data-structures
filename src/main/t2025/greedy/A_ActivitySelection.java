package main.t2025.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 1. Activity Selection Problem
 * Problem: Given a set of activities with start and finish times, select the maximum number of activities that can be performed by a single person, assuming they can only work on one activity at a time.
 *
 * Greedy Choice: Always pick the activity with the earliest finish time.
 */
public class A_ActivitySelection {
    public static void main(String[] args) {
        Activity[] activities = {
                new Activity(1, 2),
                new Activity(3, 4),
                new Activity(0, 6),
                new Activity(5, 7),
                new Activity(8, 9),
                new Activity(5, 9)
        };

        List<Activity> result = selectActivities(activities);
        for (Activity a : result) {
            System.out.println("Activity: [" + a.start + ", " + a.end + "]");
        }


    }

    private static List<Activity> selectActivities(Activity[] activities) {
        List<Activity> result = new ArrayList<>();
        Arrays.sort(activities, Comparator.comparingInt(a -> a.end));
        result.add(activities[0]);

        int lastFinish = activities[0].end;
        for(int i = 1; i< activities.length; i++) {
            if(activities[i].start >= lastFinish) {
                result.add(activities[i]);
                lastFinish = activities[i].end;
            }
        }
        return result;
    }
}

class Activity {
    int start;
    int end;
    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
