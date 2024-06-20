package com.dsa.scaller.matrix;

import java.util.ArrayList;
import java.util.Arrays;

public class AntiDigonal {
    //Give a N * N square matrix A, return an array of its anti-diagonals. Look at the example for more details.
    //
    //
    //Problem Constraints
    //1<= N <= 1000
    //1<= A[i][j] <= 1e9
    //
    //
    //Input Format
    //Only argument is a 2D array A of size N * N.
    //
    //
    //Output Format
    //Return a 2D integer array of size (2 * N-1) * N, representing the anti-diagonals of input array A.
    //The vacant spaces in the grid should be assigned to 0.
    //
    //
    //Example Input
    //Input 1:
    //1 2 3
    //4 5 6
    //7 8 9
    //Input 2:
    //
    //1 2
    //3 4
    //
    //
    //Example Output
    //Output 1:
    //1 0 0
    //2 4 0
    //3 5 7
    //6 8 0
    //9 0 0
    //Output 2:
    //
    //1 0
    //2 3
    //4 0
    //
    //
    //Example Explanation
    //For input 1:
    //The first anti diagonal of the matrix is [1 ], the rest spaces shoud be filled with 0 making the row as [1, 0, 0].
    //The second anti diagonal of the matrix is [2, 4 ], the rest spaces shoud be filled with 0 making the row as [2, 4, 0].
    //The third anti diagonal of the matrix is [3, 5, 7 ], the rest spaces shoud be filled with 0 making the row as [3, 5, 7].
    //The fourth anti diagonal of the matrix is [6, 8 ], the rest spaces shoud be filled with 0 making the row as [6, 8, 0].
    //The fifth anti diagonal of the matrix is [9 ], the rest spaces shoud be filled with 0 making the row as [9, 0, 0].
    //For input 2:
    //
    //The first anti diagonal of the matrix is [1 ], the rest spaces shoud be filled with 0 making the row as [1, 0, 0].
    //The second anti diagonal of the matrix is [2, 4 ], the rest spaces shoud be filled with 0 making the row as [2, 4, 0].
    //The third anti diagonal of the matrix is [3, 0, 0 ], the rest spaces shoud be filled with 0 making the row as [3, 0, 0].
    public static ArrayList<ArrayList<Integer>> antiDigonal(ArrayList<ArrayList<Integer>> A){
        int row = A.size();
        int col = A.size()>0?A.get(0).size():0;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for(int c=0;c<col;c++){
            int i=0;
            int j=c;
            ArrayList<Integer> mat = new ArrayList<>();
            while(i<row && j>=0){
                System.out.println(A.get(i).get(j));
                mat.add(A.get(i).get(j));
                i++;
                j--;
            }
            int zero = row-1-i+1;
            while(zero>0){
                mat.add(0);
                zero--;
            }

            ans.add(mat);
        }

        for(int r=1;r<row;r++){
            int i=r;
            int j=col-1;
            int count=0;
            ArrayList<Integer> mat = new ArrayList<>();
            while(i<row && j>=0){
                mat.add(A.get(i).get(j));
                i++;
                j--;
                count++;
            }
            int zero = row-1-count+1;
            while(zero>0){
                mat.add(0);
                zero--;
            }
            ans.add(mat);
        }
        System.out.println(ans);

        return ans;

    }
    public static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        return antiDigonal(A);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(1,2));
        ArrayList<Integer> arrayList2 = new ArrayList<>(Arrays.asList(3,4));
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        arr.add(arrayList1);
        arr.add(arrayList2);
        diagonal(arr);

    }

}
