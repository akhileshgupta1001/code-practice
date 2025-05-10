package com.dsa.scaller.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NextPermutation {
    static ArrayList<Integer> reverse(ArrayList<Integer> A, int start, int end) {
        while (start < end) {
            int temp = A.get(start);
            A.set(start, A.get(end));
            A.set(end, temp);
            start++;
            end--;
        }
        return A;
    }

    public static ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {
        System.out.println("Original Array : "+A);
        int index = -1;
        int n = A.size();
        for (int i = n - 2; i >= 0; i--) {
            if (A.get(i + 1) > A.get(i)) {
                index = i;
                System.out.println("Index i = "+i+" , elem "+ A.get(index));
                break;
            }
        }

        if (index == -1) {
            Collections.reverse(A);
            return A;
        }

        for (int i = n - 1; i > index; i--) {
            if (A.get(i) > A.get(index)) {
                System.out.println("Swaping i = "+i +" , elem "+A.get(i));
                Collections.swap(A, i, index);
                break;
            }
        }
        System.out.println("Array "+ A);


        reverse(A, index+1, n-1);
        return A;
    }



    public static void main(String[] args) {
        System.out.println(nextPermutation(new ArrayList<>(Arrays.asList(1,2,3))));
       // System.out.println(nextPermutation(new ArrayList<>(Arrays.asList(2,1,5,4,3,0,0))));
    }
}
