package main.geeksForGeeks.concurrency;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2); // allow 2 threads to access the resource at a time
        for(int i = 0; i<5; i++) {
            new Thread(new Worker(semaphore)).start();
        }
    }
}

class Worker implements Runnable{
    private Semaphore semaphore;
    public Worker(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire(); // wait for a permit to be available
            System.out.println("Thread "+Thread.currentThread().getName() +" starts working...");
            Thread.sleep(1000);
            System.out.println("Thread "+Thread.currentThread().getName()+" stops working... ");
            semaphore.release(); // Releases a permit, returning it to the semaphore.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
