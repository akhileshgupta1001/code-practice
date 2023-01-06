package com;

public class PrintEvenOdd {
     int counter=1;
    static int N ;

    public void printEven() throws InterruptedException {
        synchronized (this) {
            while (counter < N) {
                while (counter % 2 == 1) {
                    wait();
                }
                System.out.println(Thread.currentThread().getName() + " " + counter);
                counter++;
                notify();
            }
        }
    }
    public void printOdd() throws InterruptedException {
        synchronized (this) {
            while (counter < N) {
                while (counter % 2 == 0) {
                    wait();
                }
                System.out.println(Thread.currentThread().getName() + " " + counter);
                counter++;
                notify();
            }
        }
    }

    public static void main(String[] args) throws Exception{
        N =10;
        PrintEvenOdd printEvenOdd = new PrintEvenOdd();
      Thread even=  new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    printEvenOdd.printEven();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
      even.setName("Even");

        Thread odd=   new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    printEvenOdd.printOdd();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        odd.setName("Odd");
        even.start();
        odd.start();
    }


}
