package com.dsa.scaller.matrix;

import InterviewQuestion.CustomArrayList;

import java.util.ArrayList;
import java.util.Arrays;

public class TransaposeMatrix {
    public static ArrayList<ArrayList<Integer>> transpose(ArrayList<ArrayList<Integer>> A){
        int row = A.size();
        int col = A.size()>0?A.get(0).size():0;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for(int i=0;i<col;i++){
            ArrayList<Integer> matrix = new ArrayList<>();
            for(int j=0;j<row;j++){
                // System.out.println(A.get(j));
                // System.out.println()
                matrix.add(A.get(j).get(i));
            }
            ans.add(matrix);
        }
        return ans;

    }
    public static ArrayList<ArrayList<Integer>>  solve(ArrayList<ArrayList<Integer>> A) {
        return transpose(A);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(1,2,3));
        ArrayList<Integer> arrayList2 = new ArrayList<>(Arrays.asList(4,5,6));
        ArrayList<Integer> arrayList3 = new ArrayList<>(Arrays.asList(7,8,9));
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        arr.add(arrayList1);
        arr.add(arrayList2);
        arr.add(arrayList3);
        solve(arr);


    }
}
