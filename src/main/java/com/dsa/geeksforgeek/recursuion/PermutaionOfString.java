package com.dsa.geeksforgeek.recursuion;

public class PermutaionOfString {

    public static void permutation(String str,int index){

        if(index==str.length()-1){
            System.out.print(str+" ");
        }

        for (int i=index;i<str.length();i++){
            str=swap(str.toCharArray(),index,i);
            permutation(str,index+1);
            str= swap(str.toCharArray(),index,i);
        }
    }

    private static String swap(char[] arr, int start, int end) {
        while(end>start) {
            char temp = arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
        return String.valueOf(arr);
    }

    public static void main(String[] args) {
        permutation("ABC",0);
    }
}
