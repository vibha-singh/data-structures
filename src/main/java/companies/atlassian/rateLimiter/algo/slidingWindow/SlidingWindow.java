package companies.atlassian.rateLimiter.algo.slidingWindow;

import java.time.Instant;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class RateLimit {

    Map<String, Queue<Request>> userRequestMap = new ConcurrentHashMap<>();
    int rateLimit;

    public RateLimit(int rateLimit) {
        this.rateLimit = rateLimit;
    }

    public void addNewUser(String user) {
        Queue<Request> requests = new ConcurrentLinkedQueue<>();
        requests.add(new Request(Instant.now(), 1));
        userRequestMap.put(user,requests);
        System.out.println("New user added: "+user);
    }

    public Integer getTotalElapsedRequest(String user) {
        return userRequestMap.get(user).stream().mapToInt(Request::getCount).sum();
    }
}
