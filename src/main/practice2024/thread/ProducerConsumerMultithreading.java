package main.practice2024.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerMultithreading {
    public static void main(String[] args) {
        BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(4);
        Producer p = new Producer(bq);
        Consumer c = new Consumer(bq);

        Thread prod = new Thread(p);
        Thread cons = new Thread(c);
        prod.start();
        cons.start();
    }


}

class Producer implements Runnable {
    BlockingQueue<Integer>  bq;

    public Producer(BlockingQueue<Integer> bq) {
        this.bq = bq;
    }

    @Override
    public void run() {
        for(int i = 1; i<=50; i++) {
            try {
                bq.put(i);
                System.out.println("Produced: "+ i +" ");;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            bq.put(0000);
            System.out.println("Produced: "+ 0000 +" ");;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}

class Consumer implements Runnable {
    BlockingQueue<Integer> bq;

    public Consumer(BlockingQueue<Integer> bq) {
        this.bq = bq;
    }

    @Override
    public void run() {
        Integer num;
        try {
            while ((num = bq.take()) != 0000) {
                System.out.println("Consumed: "+ num +" ");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
