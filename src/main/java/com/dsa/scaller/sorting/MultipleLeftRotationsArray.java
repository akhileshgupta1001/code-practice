package com.dsa.scaller.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class MultipleLeftRotationsArray {
    //Problem Description
    //Given an array of integers A and multiple values in B, which represents the number of times array A needs to be left rotated.
    //
    //Find the rotated array for each value and return the result in the from of a matrix where ith row represents the rotated array for the ith value in B.
    //
    //
    //
    //Problem Constraints
    //1 <= length of both arrays <= 2000 -10^9 <= A[i] <= 10^9 0 <= B[i] <= 2000
    //
    //
    //Input Format
    //The first argument given is the integer array A.
    //The second argument given is the integer array B.
    //
    //
    //Output Format
    //Return the resultant matrix.
    //
    //
    //Example Input
    //Input 1:
    //
    //    A = [1, 2, 3, 4, 5]
    //    B = [2, 3]
    //
    //Input 2:
    //
    //
    //    A = [5, 17, 100, 11]
    //    B = [1]
    //
    //
    //
    //
    //Example Output
    //Output 1:
    //
    //    [ [3, 4, 5, 1, 2]
    //     [4, 5, 1, 2, 3] ]
    //
    //
    //Output 2:
    //
    //
    //    [ [17, 100, 11, 5] ]
    //
    //
    //
    //Example Explanation
    //for input 1 -> B[0] = 2 which requires 2 times left rotations
    //
    //1: [2, 3, 4, 5, 1]
    //
    //2: [3, 4, 5, 1, 2]
    //
    //B[1] = 3 which requires 3 times left rotation
    //
    //1: [2, 3, 4, 5, 1]
    //
    //2: [3, 4, 5, 1, 2]
    //
    //2: [4, 5, 1, 2, 4]

    public ArrayList<Integer> revrse(ArrayList<Integer> A, int start, int end){
        while(start<end){
            int temp= A.get(start);
            A.set(start,A.get(end));
            A.set(end,temp);
            start++;
            end--;
        }
        return A;
    }
    public  ArrayList<Integer> rotate(ArrayList<Integer> A, int k, int n){
        k = k % n;
        System.out.println("Original Array : "+A);
        revrse(A,0,n-1);
        System.out.println("After reversing: "+A);
        revrse(A,0,k);
        System.out.println(A);
        revrse(A,k+1,n-1);
        System.out.println(A);
        return A;
    }
    public ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<ArrayList<Integer>>  ans = new ArrayList<ArrayList<Integer>> ();
        for(Integer data : B){
            ans.add(rotate(new ArrayList<>(A),data,A.size()));

        }
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
       MultipleLeftRotationsArray multipleLeftRotationsArray = new MultipleLeftRotationsArray();
       multipleLeftRotationsArray.solve(new ArrayList(Arrays.asList(1, 2, 3, 4, 5)),new ArrayList<>(Arrays.asList(2,3)));
    }
}
