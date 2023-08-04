package com.dsa.scaller.queue;

import java.util.LinkedList;
import java.util.Queue;

public class PerfectNumbers {

    public int solve(int A) {
        if(A<=2) return A;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        int i=3;
       // System.out.print(queue);

        while (i<=A){
            int data = queue.remove();
            int a= data * 10+1;
            int b = a+1;
            queue.add(a);
            queue.add(b);
          //  System.out.print(a + ", "+b+" ,");

            if(i==A) return a;
            if(i+1==A) return b;
            i+=2;
        }

        return 0;
    }
    public static void main(String[] args) {
        PerfectNumbers perfectNumber = new PerfectNumbers();
        System.out.println(perfectNumber.solve(3));

//1,2,11, 12 ,21, 22 ,111, 112 ,121, 122 ,
        ////11, 22 ,111 ,121

    }
}
