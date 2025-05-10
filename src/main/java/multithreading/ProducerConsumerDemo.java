package multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerDemo {
    public static void main(String[] args) {

        Object currentObject = new Object();
        Queue<Integer> queue = new LinkedList<>();
        int size=10;

        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                while (true) {
                    synchronized (currentObject) {
                        try {
                            while(queue.size()==size)
                                currentObject.wait();

                            queue.add(count++);
                            currentObject.notifyAll();
                            Thread.sleep(100);
                            System.out.println("Momos Producer size = " + queue.size());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                          //  throw new RuntimeException(e);
                        }
                    }
                }
            }
        });

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (currentObject) {
                        try {
                            while(queue.size()==0)
                                currentObject.wait();

                            queue.remove();
                            currentObject.notifyAll();
                            Thread.sleep(500);
                            System.out.println("Momos Consumer size = " + queue.size());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                           // throw new RuntimeException(e);
                        }

                    }
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
