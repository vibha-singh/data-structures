package main.companies.atlassian.rateLimiter.algo.slidingWindow;

import java.time.Instant;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SlidingWindow  {

    Queue<Long> queue ;
    int bucketCapacity;
    int timeWindow;

    public SlidingWindow(int bucketCapacity, int timeWindow) {
        queue = new ConcurrentLinkedQueue<>();
        this.bucketCapacity = bucketCapacity;
        this.timeWindow = timeWindow;
    }

    public synchronized boolean grantAccess() {
        Long currentTime = System.currentTimeMillis();
        checkAndUpdateQueue(currentTime);
        if(queue.size() < bucketCapacity) {
            queue.offer(currentTime);
            return  true;
        }
        return false;
    }

    private void checkAndUpdateQueue(Long currentTime) {
        if(queue.isEmpty()) return;
        long calculatedTime = (currentTime - queue.peek())/1000;

        while (calculatedTime >= timeWindow) {
            queue.poll();
            if (queue.isEmpty()) break;
            calculatedTime = (currentTime - queue.peek())/1000;
        }

    }
}
