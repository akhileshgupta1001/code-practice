package multithreading;

class Processor{
    int num;
    boolean isValueSet=false;

    public synchronized void  put(int num){
        while (isValueSet){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.isValueSet=true;
        this.num=num;
        System.out.println("Put : "+num);
        notify();
    }

    public synchronized void  get(){
        while (!isValueSet){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Get : "+num);
        this.isValueSet=false;
        notify();
    }
}

class Producer implements Runnable{
    private Processor processor;
    public Producer(Processor processor){
        this.processor=processor;
        Thread thread= new Thread(this,"Producer");
        thread.start();
    }
    @Override
    public void run() {
      int i=0;
      while(true){
          processor.put(i++);
      }
    }
}

class Consumer implements Runnable{
    private Processor processor;
    public Consumer(Processor processor){
        this.processor=processor;
        Thread thread= new Thread(this,"Consumer");
        thread.start();
    }
    @Override
    public void run() throws RuntimeException {
        int i=0;
        while(true){
            processor.get();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class ProducerConsumer {
    public static void main(String[] args) {
        Processor processor= new Processor();
        new Producer(processor);
        new Consumer(processor);
    }
}
