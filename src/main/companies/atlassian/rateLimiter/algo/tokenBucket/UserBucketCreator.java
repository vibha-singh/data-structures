package main.companies.atlassian.rateLimiter.algo.tokenBucket;

import java.util.HashMap;
import java.util.Map;

public class UserBucketCreator {

    Map<Integer, TokenBucket> map;
    public UserBucketCreator(int id, int capacity) {
        map = new HashMap<>();
        map.put(id, new TokenBucket(5,1));
    }

    void accessApplication(Integer id){
        if(map.get(id).grantAccess()) {
            System.out.println("Able to access the request");
        } else {
            System.out.println("Too many request, Please try after sometime");
        }
    }

}
