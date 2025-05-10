package multithreading.producerconsumer;

import java.util.Queue;

public class Consumer implements Runnable{
    private Queue<Object> queue;
    private String name;
    private int size;

    public Consumer(Queue<Object> queue,  int size,String name){
        this.queue=queue;
        this.name=name;
        this.size=size;
    }

    @Override
    public void run() {
        while (true){
            if(queue.size()>0) {
                System.out.println(name + "is consuming an element & size is " + queue.size());
                queue.remove();
            }
        }
    }
}
