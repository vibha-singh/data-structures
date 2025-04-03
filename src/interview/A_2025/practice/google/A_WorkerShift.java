package interview.A_2025.practice.google;

import java.util.*;

/**
 * You are given a list of worker shifts, where each shift is
 * represented as a list [name, start, end]. The name is a string
 * representing the worker's name, start is an integer representing the
 * start time of the shift, and end is an integer representing the end
 * time of the shift. The goal is to generate a schedule that shows the
 * intervals of time and the workers present during each interval.
 *
 * Example:
 * Given the input:
 * [["Abby", 10, 100], ["Ben", 50, 70], ["Carla", 60, 70],
 * ["David", 120, 300]]
 *
 * The output should be:
 * [[10, 50, ["Abby"]], [50, 60, ["Abby", "Ben"]],
 * [60, 70, ["Abby", "Ben", "Carla"]], [70, 100, ["Abby"]],
 * [120, 300, ["David"]]]
 *
 * Steps to solve the problem:
 * 1. Collect all unique time points: We need to identify all the start and end times from the shifts.
 * 2. Sort these time points: This will help us in creating intervals.
 * 3. Iterate through the sorted time points: For each interval, determine which workers are present.
 * 4. Build the schedule: For each interval, store the start time, end time, and the list of workers present.
 */
public class A_WorkerShift {
    public static void main(String[] args) {

        List<List<Object>> inputs = new ArrayList<>();
        inputs.add(Arrays.asList("Abby", 10, 100));
        inputs.add(Arrays.asList("Ben", 50, 70));
        inputs.add(Arrays.asList("Carla", 60, 70));
        inputs.add(Arrays.asList("David", 120, 300));

        // Step 1: Collect all unique time points
        Set<Integer> timePoints = new TreeSet<>();
        for (List<Object> shift : inputs) {
            timePoints.add((Integer) shift.get(1)); // start time
            timePoints.add((Integer) shift.get(2)); // end time
        }

        // Step 2: Sort the time points
        List<Integer> sortedTimePoints = new ArrayList<>(timePoints);

        // Step 3: Iterate through the sorted time points and build the schedule
        List<List<Object>> schedule = new ArrayList<>();
        for (int i = 0; i < sortedTimePoints.size() - 1; i++) {
            int start = sortedTimePoints.get(i);
            int end = sortedTimePoints.get(i + 1);

            // Determine which workers are present in this interval
            List<String> workersPresent = new ArrayList<>();
            for (List<Object> shift : inputs) {
                String name = (String) shift.get(0);
                int shiftStart = (Integer) shift.get(1);
                int shiftEnd = (Integer) shift.get(2);

                if (shiftStart <= start && shiftEnd >= end) {
                    workersPresent.add(name);
                }
            }

            // Add the interval and the workers present to the schedule
            List<Object> interval = new ArrayList<>();
            interval.add(start);
            interval.add(end);
            interval.add(workersPresent);
            schedule.add(interval);
        }

        System.out.println( schedule);
    }


}



