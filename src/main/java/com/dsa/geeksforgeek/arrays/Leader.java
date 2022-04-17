package com.dsa.geeksforgeek.arrays;

public class Leader {

    //7,10,4,10,6,5,2
    //0/p => 2,5,6,10

    public static void leader(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean leader = false;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    leader = true;
                    break;
                }
            }
            if (leader == false)
                System.out.print(arr[i] + " ");
        }
    }

    public static void leaderOptimisation(int[] arr) {
        int currentLeader = arr[arr.length - 1];
        System.out.print(currentLeader + " ");
        for (int i = arr.length - 2; i > 0; i--) {
            if (arr[i] > currentLeader) {
                currentLeader = arr[i];
                System.out.print(currentLeader + " ");
            }
        }
    }

    public static void main(String[] args) {
        //leader(new int[]{7, 10, 4, 10, 6, 5, 2});
        leaderOptimisation(new int[]{7, 10, 4, 10, 6, 5, 2});
    }
}
