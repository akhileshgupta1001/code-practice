package com.dsa.geeksforgeek.practice;

public class Permutation {

    public static void permute(String data, int index){
        if(index == data.length()-1){
            System.out.println(data+" ");
        }

            for(int i =index;i<data.length();i++){
                data = swap(data.toCharArray(),index, i);
                permute(data,index+1);
                data = swap(data.toCharArray(),index,i);
            }
    }

    public static String swap(char[] data, int low , int high){

        while(low< high){
            char temp = data[low];
            data[low] = data[high];
            data[high] = temp;
            low++;
            high--;

        }
        return String.valueOf(data);
    }

    public static void main(String[] args) {
        permute("ABA",0);
    }
}
