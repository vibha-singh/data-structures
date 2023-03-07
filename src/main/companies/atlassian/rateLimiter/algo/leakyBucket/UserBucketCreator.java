package main.companies.atlassian.rateLimiter.algo.leakyBucket;

import java.util.HashMap;
import java.util.Map;

public class UserBucketCreator {

    Map<Integer, LeakyBucket> map;
    public UserBucketCreator(int id, int capacity) {
        map = new HashMap<>();
        map.put(id, new LeakyBucket(capacity));
    }

    void accessApplication(Integer id){
        if(map.get(id).grantAccess(1)) {
            System.out.println("Able to access the request");
        } else {
            System.out.println("Too many request, Please try after sometime");
        }
    }

}
