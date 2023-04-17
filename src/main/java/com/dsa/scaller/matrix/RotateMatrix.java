package com.dsa.scaller.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RotateMatrix {
    //Problem Description
    //You are given a n x n 2D matrix A representing an image.
    //
    //Rotate the image by 90 degrees (clockwise).
    //
    //You need to do this in place.
    //
    //Note: If you end up using an additional array, you will only receive partial score.
    //
    //
    //
    //Problem Constraints
    //1 <= n <= 1000
    //
    //
    //
    //Input Format
    //First argument is a 2D matrix A of integers
    //
    //
    //
    //Output Format
    //Return the 2D rotated matrix.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // [
    //    [1, 2],
    //    [3, 4]
    // ]
    //Input 2:
    //
    // [
    //    [1, 2, 3],
    //    [4, 5, 6],
    //    [7, 8, 9]
    // ]
    //
    //
    //Example Output
    //Output 1:
    //
    // [
    //    [3, 1],
    //    [4, 2]
    // ]
    //Output 2:
    //
    // [
    //    [7, 4, 1],
    //    [8, 5, 2],
    //    [9, 6, 3]
    // ]
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // After rotating the matrix by 90 degree:
    // 1 goes to 2, 2 goes to 4
    // 4 goes to 3, 3 goes to 1
    //Explanation 2:
    //
    // After rotating the matrix by 90 degree:
    // 1 goes to 3, 3 goes to 9
    // 2 goes to 6, 6 goes to 8
    // 9 goes to 7, 7 goes to 1
    // 8 goes to 4, 4 goes to 2

    public static ArrayList<ArrayList<Integer>> transpose(ArrayList<ArrayList<Integer>> A){
        int row = A.size();
        int col = A.size()>0?A.get(0).size():0;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int c=0;c<col;c++){
            ArrayList<Integer> mat = new ArrayList<>();
            for(int r=0;r<row;r++){
                mat.add(A.get(r).get(c));
            }
            ans.add(mat);
        }
        return ans;
    }
    public static void solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> transpose = transpose(A);
        System.out.println(transpose);
        int row = A.size();
        int col = A.size()>0?A.get(0).size():0;
        for(int i=0;i<row;i++){
            ArrayList<Integer> mat = transpose.get(i);
            Collections.reverse(mat);
            A.set(i,mat);
        }
        System.out.println(transpose);
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
