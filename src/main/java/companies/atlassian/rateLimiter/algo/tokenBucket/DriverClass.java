package companies.atlassian.rateLimiter.algo.leakyBucket;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DriverClass {

    public static void main(String[] args) {
        UserBucketCreator userBucketCreator = new UserBucketCreator(1, 5);
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for(int i = 0 ; i< 10; i++) {
            executorService.execute(()->{
                userBucketCreator.accessApplication(1);
            });
        }

        executorService.shutdown();
    }
}
