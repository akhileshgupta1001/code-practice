class Counter {
    private int count = 0;

    public synchronized void increment() throws InterruptedException {
        while (count >= 10) {
            wait();
        }
        count++;
        System.out.println("Incremented: " + count);
        notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
        while (count <= 0) {
            wait();
        }
        count--;
        System.out.println("Decremented: " + count);
        notifyAll();
    }

    public synchronized int getCount() {
        return count;
    }
}

class Incrementer implements Runnable {
    private final Counter counter;

    public Incrementer(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000);
                counter.increment();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Incrementer interrupted");
        }
    }
}

class Decrementer implements Runnable {
    private final Counter counter;

    public Decrementer(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1500); // Simulate time taken for a decrement operation
                counter.decrement();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Decrementer interrupted");
        }
    }
}




public class Test2 {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Incrementer incrementer = new Incrementer(counter);
        Decrementer decrementer = new Decrementer(counter);

        Thread incrementerThread = new Thread(incrementer);
        Thread decrementerThread = new Thread(decrementer);

        incrementerThread.start();
        decrementerThread.start();
    }
}
