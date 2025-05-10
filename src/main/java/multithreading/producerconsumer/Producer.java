package multithreading.producerconsumer;

import java.util.Queue;

public class Producer  implements Runnable{
    private Queue<Object> queue;
    private String name;
    private int size;

    public Producer(Queue<Object> queue,  int size,String name){
        this.queue=queue;
        this.name=name;
        this.size=size;
    }

    @Override
    public void run() {
        while (true){
            if(queue.size()<size) {
                System.out.println(name + "is producing an element & size is " + queue.size());
                queue.add(new Object());
            }
        }
    }
}
