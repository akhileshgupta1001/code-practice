package multithreading;

public class PrintSeperateArrayInThread {
    static int counter =0;
    static Object lock = new Object();
    public static void main(String[] args) {
        int[] arr1= {1,2,3,4,5};
        int[] arr2={6,7,8,9,10};
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arr1.length; i++) {
                    synchronized (lock) {
                        while (counter % 2 != 0) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        System.out.print(arr1[i]+ " ");
                        counter++;
                        lock.notifyAll();
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<arr2.length;i++){
                    synchronized (lock){
                    while (counter%2 !=1){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.print(arr2[i]+" ");
                    counter++;
                    lock.notifyAll();
                }
            }
            }
        });

        thread1.start();
        thread2.start();

        }
}
