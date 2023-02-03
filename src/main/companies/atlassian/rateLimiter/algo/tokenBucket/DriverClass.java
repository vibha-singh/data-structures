package main.companies.atlassian.rateLimiter.algo.tokenBucket;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DriverClass {

    public static void main(String[] args) {
        UserBucketCreator userBucketCreator = new UserBucketCreator(1, 5);
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for(int i = 0 ; i< 5; i++) {
            executorService.execute(()->{
                userBucketCreator.accessApplication(1);
            });
        }

        executorService.shutdown();
    }
}
