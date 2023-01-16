package com.dsa.geeksforgeek.matrix;

public class FindTheNumberInSortedMatrix {

    //https://www.geeksforgeeks.org/search-element-sorted-matrix/
    public static boolean getElement(int[][] arr,int rowSize, int columnSize,int searchElement){

       int startIndex=0;
       int endIndex= rowSize-1;
       while (startIndex >=0 && startIndex< rowSize &&  endIndex>=0 && endIndex< columnSize){

           if(arr[startIndex][endIndex]==searchElement){
              return true;
           }
           // traverse left row
           else if(arr[startIndex][endIndex]>searchElement){
                endIndex--;
           }
           // traverse current column in bottom
           else {
               startIndex++;
           }
       }
       return false;
    }

    public static void main(String[] args) {
        int n = 4, m = 5, x = 123;
        int mat[][] = {{0, 6, 8, 9,    11},
                      {20, 22, 28, 29, 31},
                      {36, 38, 50, 61, 63},
                      {64, 66, 100, 122, 128}};

        System.out.println(getElement(mat, n, m, x));
    }
}
