package com.dsa.geeksforgeek.practice;

import java.sql.SQLOutput;
import java.util.Arrays;

public class ConvertArrayIntoZigZagFashion {

    //O(nlogn)
    public static  void zigzag(int[] arr){

        Arrays.sort(arr);
        for(int i =1;i< arr.length-1;i=i+2){
            int temp = arr[i];
            arr[i]= arr[i+1];
            arr[i+1] =temp;
        }
//1
//3
//2
//6
//4
//8
//7
        //System.out.println(Arrays.asList(arr));
       Arrays.stream(arr).forEach(System.out::println);
    }

    public static  void zigzag2(int[] arr){


        for(int i =0;i< arr.length-1;i++){
          if(i%2==0 && arr[i]>arr[i+1]){
              int temp = arr[i];
              arr[i]=arr[i+1];
              arr[i+1]= temp;
          }else if(i%2==1 && arr[i]<arr[i+1]){
              int temp = arr[i];
              arr[i]=arr[i+1];
              arr[i+1]= temp;
          }
        }
//1
//3
//2
//6
//4
//8
//7
        //System.out.println(Arrays.asList(arr));
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 4, 3, 7, 8, 6, 2, 1 };
        zigzag(arr);
    }
}
