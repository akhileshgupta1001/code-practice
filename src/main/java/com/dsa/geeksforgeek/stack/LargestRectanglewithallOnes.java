package com.dsa.geeksforgeek.stack;

import java.util.Stack;

//https://www.geeksforgeeks.org/maximum-size-rectangle-binary-sub-matrix-1s/
public class LargestRectanglewithallOnes {
    public static int getLongestRectangularAreaUsingSatck(int[] arr , int c){
        int result =0;
        int top ;
        int n = c;
        int current = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i =0;i<c;i++){

            while (!stack.isEmpty() && arr[stack.peek()]>= arr[i]){
                top = stack.peek();
                stack.pop();
                current = arr[top]*(stack.isEmpty()?i:i-stack.peek()-1);
                result = Math.max(result,current);
            }
            stack.add(i);
        }
        while (!stack.isEmpty()){
            top = stack.peek();
            stack.pop();
            current = arr[top]*(stack.isEmpty()?n:n-stack.peek()-1);
            result = Math.max(result,current);
        }
        return result;
    }

    public static int maxRectangle(int[][] matrix,int row, int col) {
        int res = getLongestRectangularAreaUsingSatck(matrix[0],col);

        for(int i =1;i<col;i++){

            for(int j=0;j<row;j++){
                matrix[i][j]=  matrix[i][j]+ matrix[i-1][j];
            }
            res = Math.max(res,getLongestRectangularAreaUsingSatck(matrix[i],col));
        }
        return res;
    }

    public static void main(String[] args) {
        int R = 4;
        int C = 4;

        int A[][] = {
                { 0, 1, 1, 0 },
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 0, 0 },
        };
        System.out.println(maxRectangle(A,R,C));
    }
}
