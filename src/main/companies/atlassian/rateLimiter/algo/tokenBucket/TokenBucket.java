package main.companies.atlassian.rateLimiter.algo.tokenBucket;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class TokenBucket {
    private int bucketCapacity;
    private int refreshRate;
    private AtomicInteger currentCapacity;
    private AtomicLong lastUpdatedTime;

    public TokenBucket(int bucketCapacity, int refreshRate) {
        this.bucketCapacity = bucketCapacity;
        this.refreshRate = refreshRate;
        this.currentCapacity.getAndSet(bucketCapacity);
        this.lastUpdatedTime.getAndSet(System.currentTimeMillis());
    }

    public boolean grantAccess() {
        refreshBucket();
        if(currentCapacity.get() > 0){
            currentCapacity.decrementAndGet();
            return true;
        }
        return false;
    }

    void refreshBucket() {
        long currentTime = System.currentTimeMillis();
        int additionalToken = (int)((currentTime - lastUpdatedTime.get()) /1000 *refreshRate);
        int currCapacity = Math.min(currentCapacity.get() + additionalToken, bucketCapacity);
        currentCapacity.getAndSet(currCapacity);
        lastUpdatedTime.getAndSet(currentTime);
    }
}
