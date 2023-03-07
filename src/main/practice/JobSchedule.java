package main.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * At one request id at one time one unit will start executing and others will wait so output based on the time how many requests are executing
 * Time    No of units    RequestId
 * 10001       150          1
 * 10002        2           1
 * 10002        3           2
 * 10151        50          3
 * 11000         1          2
 *
 *
 * 10001 will 150 units will be finished at 10001+150 i.e 10151 time at request id 1,
 * 10002 will start at 10151 at request id 1,
 * 10002 will start at 10002 with request id 1 and ends at 100
 * 10151 will start at 10151
 *
 *
 * Request id 1 : start time: 10001, endtime: 10151 noOfrequest 1
 * 2 : start time: 10002, end time: 10005 noOfRequest : 2
 * o/p:
 *
 *    Time      noOfRequests
 *    10001         1
 *    10002         2    10001(request id 1) and 1002 (request oid 2)
 *    10151         2    10002 (request id 1) and 10051 (request id 3)
 *    11000         1    only
 *
 */
public class JobSchedule {

    private Integer time;
    private Integer noOfUnits;
    private Integer requestId;

    public JobSchedule(Integer time, Integer noOfUnits, Integer requestId) {
        this.time = time;
        this.noOfUnits = noOfUnits;
        this.requestId = requestId;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getNoOfUnits() {
        return noOfUnits;
    }

    public void setNoOfUnits(Integer noOfUnits) {
        this.noOfUnits = noOfUnits;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public static void main(String[] args) {
        JobSchedule job1 = new JobSchedule(10001, 150, 1);
        JobSchedule job2 = new JobSchedule(10002, 2, 1);
        JobSchedule job3 = new JobSchedule(10002, 3, 2);
        JobSchedule job4 = new JobSchedule(10151, 50, 3);
        JobSchedule job5 = new JobSchedule(11000, 1, 2);

        List<JobSchedule> jobs = new ArrayList<>(List.of(job1, job2, job3, job4, job5));
       List< JobScheduleTrackTime> waitingJobs = new ArrayList<>();
        Map<Integer, JobScheduleTrackTime> currJobs = new HashMap<>();
        for (JobSchedule job : jobs ) {
            if(!currJobs.containsKey(job.getRequestId())) {
                currJobs.put(job.getRequestId(), new JobScheduleTrackTime(job.getTime(), job.getNoOfUnits()+job.getTime(), 1));
            } else {

                waitingJobs.add(new JobScheduleTrackTime(job.getTime(), job.getNoOfUnits()+job.getTime(), 1));
            }
        }



    }



}

class JobScheduleTrackTime {
    Integer startTime;
    Integer endTime;
    Integer noOfRequestExecuting;

    public JobScheduleTrackTime(Integer startTime, Integer endTime, Integer noOfRequestExecuting) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.noOfRequestExecuting = noOfRequestExecuting;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public Integer getNoOfRequestExecuting() {
        return noOfRequestExecuting;
    }

    public void setNoOfRequestExecuting(Integer noOfRequestExecuting) {
        this.noOfRequestExecuting = noOfRequestExecuting;
    }
}


