package main.geeksForGeeks.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Publisher implements Runnable{

    public static void main(String[] args) {
        BlockingQueue<Message> blockingQueue = new ArrayBlockingQueue<>(4);
        Publisher pub = new Publisher(blockingQueue);
        Consumer con = new Consumer(blockingQueue);

        Thread p = new Thread(pub);
        Thread c = new Thread(con);
        p.start();
        c.start();
    }
    BlockingQueue<Message> queue;

    public Publisher(BlockingQueue<Message> q){
        this.queue = q;
    }

    @Override
    public void run() {
        //produce messages
        for(int i=0; i<50; i++){
            Message msg = new Message(""+i);
            try {
                Thread.sleep(i);
                queue.put(msg);
                System.out.println("Produced "+msg.getMsg());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //adding exit message
        Message msg = new Message("exit");
        try {
            queue.put(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class Consumer implements Runnable{
    private BlockingQueue<Message> queue;

    public Consumer(BlockingQueue<Message> q){
        this.queue=q;
    }

    @Override
    public void run() {
        try{
            Message msg;
            //consuming messages until exit message is received
            while((msg = queue.take()).getMsg() !="exit"){
                Thread.sleep(10);
                System.out.println("Consumed "+msg.getMsg());
            }
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Message {
    String msg;
    public Message(String msg) {
        this.msg = msg;
    }

    public String getMsg(){
        return msg;
    }
}
