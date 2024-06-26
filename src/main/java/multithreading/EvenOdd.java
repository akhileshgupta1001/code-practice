package multithreading;

public class EvenOdd {
    int count;
    static int N;

    public  void printEven(){
        while(count<N) {
            synchronized (this) {
                if (count % 2 == 1) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Thread name : " + Thread.currentThread().getName() + " , Number : " + count);
                count++;
                notify();
            }
        }
    }
    public  void printOdd(){
        while(count<N){
            synchronized (this){
            if(count%2==0){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Thread name : "+Thread.currentThread().getName()+" , Number : "+count);
            count++;
            notify();
        }}
    }

    public static void main(String[] args) {
        N=20;
        EvenOdd evenOdd= new EvenOdd();
        Thread evenThread=
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        evenOdd.printEven();
                    }
                },"Even");
        Thread oddThread=   new Thread(new Runnable() {
            @Override
            public void run() {
                evenOdd.printOdd();
            }
        },"Odd");

    evenThread.start();
    oddThread.start();
    }

    /*
    int counter=1;
    static int  N;

    public void oddNumber(){
        synchronized (this){
            while (counter<N){
                while (counter %2==0){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print(Thread.currentThread().getName()+" "+counter);
                System.out.println();
                counter++;
                notify();
            }
        }
    }

    public void printEven(){
        synchronized (this){
            while (counter<N){
                while (counter%2==1){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print(Thread.currentThread().getName()+" "+counter);
                System.out.println();
                counter++;
                notify();
            }
        }
    }

    public static void main(String[] args) {
        N =10;
        EvenOdd evenOdd = new EvenOdd();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
            evenOdd.printEven();
            }
        },"Even");
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                evenOdd.oddNumber();
            }
        },"Odd");
        thread1.start();;
        thread2.start();
    }

     */
}
