package com.dsa.scaller.queue;

import java.util.LinkedList;
import java.util.Queue;

public class PerfectNumbers {

    //Problem Description
    //Given an integer A, you have to find the Ath Perfect Number.
    //
    //A Perfect Number has the following properties:
    //
    //It comprises only 1 and 2.
    //The number of digits in a Perfect number is even.
    //It is a palindrome number.
    //For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.
    //
    //
    //
    //Problem Constraints
    //1 <= A <= 100000
    //
    //
    //
    //Input Format
    //The only argument given is an integer A.
    //
    //
    //
    //Output Format
    //Return a string that denotes the Ath Perfect Number.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = 2
    //Input 2:
    //
    // A = 3
    //
    //
    //Example Output
    //Output 1:
    //
    // 22
    //Output 2:
    //
    // 1111
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    //First four perfect numbers are:
    //1. 11
    //2. 22
    //3. 1111
    //4. 1221
    //Return the 2nd Perfect number.
    //Explanation 2:
    //
    //First four perfect numbers are:
    //1. 11
    //2. 22
    //3. 1111
    //4. 1221
    //Return the 3rd Perfect number.



    public String solve(int A) {
        Queue<String> queue = new LinkedList<>();
        queue.add("11");
        queue.add("22");

        for (int i = 1; i < A; i++) {
            String current = queue.poll();
            int n = current.length();

            String first = current.substring(0, n / 2) + "11" + current.substring(n / 2);
            String second = current.substring(0, n / 2) + "22" + current.substring(n / 2);
            queue.add(first);
            queue.add(second);
        }
        return queue.isEmpty() ? "" : queue.poll();
    }

    public static void main(String[] args) {
        PerfectNumbers perfectNumber = new PerfectNumbers();
        System.out.println(perfectNumber.solve(3));

//1,2,11, 12 ,21, 22 ,111, 112 ,121, 122 ,
        ////11, 22 ,111 ,121

    }
}
