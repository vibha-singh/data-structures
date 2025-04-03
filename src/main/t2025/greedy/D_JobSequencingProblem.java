package main.t2025.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 5. Job Sequencing Problem
 * Problem: Given a set of jobs with deadlines and profits, schedule the jobs to maximize profit. Each job takes 1 unit of time.
 *
 * Greedy Choice: Always pick the job with the highest profit that can be scheduled before its deadline.
 */
public class D_JobSequencingProblem {
    public static void main(String[] args) {
        Job[] jobs = {
                new Job(1, 2, 100),
                new Job(2, 1, 19),
                new Job(3, 2, 27),
                new Job(4, 1, 25),
                new Job(5, 3, 15)
        };

        System.out.println("Maximum profit: " + maxProfit(jobs));
    }

    private static int maxProfit(Job[] jobs) {
        Arrays.sort(jobs, (a,b) -> Integer.compare(b.profit,a.profit));
        int maxDeadline = Integer.MIN_VALUE;
        for(Job job: jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }
        boolean[] schedule = new boolean[maxDeadline + 1];
        int totalProfit = 0;
        for(Job job : jobs) {
            for(int i = job.deadline; i>=0; i--) {
                if(!schedule[i] ){
                    schedule[i] = true;
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        return totalProfit;
    }

}

class Job{
    int id, deadline, profit;

    public Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}
