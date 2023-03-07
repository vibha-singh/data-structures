package main.companies.atlassian.rateLimiter.algo.leakyBucket;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class LeakyBucket {
    BlockingQueue<Integer> queue;

    public LeakyBucket(int capacity) {
        this.queue = new LinkedBlockingDeque<>(capacity);
    }

    public boolean grantAccess(int noOfRequest) {
        if(queue.remainingCapacity() > 0){
            queue.add(noOfRequest);
            return true;
        }
        return false;
    }
}
