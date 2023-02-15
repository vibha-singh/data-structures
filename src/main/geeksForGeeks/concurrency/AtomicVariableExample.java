package main.geeksForGeeks.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariableExample {
    private final AtomicInteger count = new AtomicInteger(0);

    public void incrementCount() {
        count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }
}
