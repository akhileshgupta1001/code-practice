package com.dsa.geeksforgeek.recursuion;

public class TowerOfHenoi {
    // number of movments of disc = 2^n-1
    static void tower(int discSize, char A, char B, char C) {

        if (discSize == 1) {
            System.out.println("Move 1 disc from " + A + " to " + C);
            return;
        }
        tower(discSize - 1, A, C, B);
        System.out.println("Move " + discSize + " from " + A + " to " + B);
        tower(discSize - 1, B, A, C);
    }

    public static void main(String[] args) {
        tower(5,'A','B','C');
    }
}
