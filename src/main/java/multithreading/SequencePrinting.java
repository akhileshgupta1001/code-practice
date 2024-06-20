package multithreading;

public class SequencePrinting {
    static Object lock = new Object();
    static int counter = 1;
    static int n = 5;

    public static void main(String[] args) {
        Thread[] threads = new Thread[n];
        for (int i = 0; i < n; i++) {
            final int threadIndex = i;
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    for (int j = 0; j < n; j++) {
                        synchronized (lock) {
                            while (counter % n != threadIndex) {
                                try {
                                    lock.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            System.out.println("Thread " + threadIndex + " " + counter++);
                            lock.notifyAll();
                        }
                    }
                }
            });
            threads[i].start();
        }
    }

}
