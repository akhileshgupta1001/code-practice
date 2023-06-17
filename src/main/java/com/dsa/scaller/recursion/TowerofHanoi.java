package com.dsa.scaller.recursion;

import java.util.ArrayList;

public class TowerofHanoi {
    static ArrayList<ArrayList<Integer>> moves = new ArrayList<ArrayList<Integer>>();

    public static ArrayList<ArrayList<Integer>> towerOfHanoi(int A) {
        tower(A, 1, 3, 2);
        System.out.println("final Ans : " + moves);
        return moves;
    }

    public static void tower(int A, int start, int end, int helper) {
        ArrayList<Integer> move = new ArrayList();
        if (A == 1) {
            move.add(A);
            move.add(start);
            move.add(end);
            moves.add(move);
            System.out.println("Moves : " + moves);
            return;
        }

        tower(A - 1, start, helper, end);
        move.add(A);
        move.add(start);
        move.add(end);
        moves.add(move);
        System.out.println("Moves : " + moves);
        tower(A - 1, helper, end, start);
    }

    public static void main(String[] args) {
        towerOfHanoi(3);
        ArrayList<Integer> ans = new ArrayList<>();
    }

}
