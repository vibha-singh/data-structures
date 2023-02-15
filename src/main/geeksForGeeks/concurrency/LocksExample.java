package main.geeksForGeeks.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LocksExample {
    private final Object lock = new Object();

    public void doSynchronizedTask() {
        synchronized (lock) {
            // this code will be executed by only one thread at a time
        }
    }
}

class LockExample2 {
    private final Lock lock = new ReentrantLock();

    public void doLockedTask() {
        lock.lock();
        try {
            // this code will be executed by only one thread at a time
        } finally {
            lock.unlock();
        }
    }
}
