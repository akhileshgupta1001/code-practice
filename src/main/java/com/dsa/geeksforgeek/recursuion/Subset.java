package com.dsa.geeksforgeek.recursuion;

public class Subset {
    static void subset(String str, String current,int start){

        if(start== str.length()){
            System.out.print(current+" ");
            return;
        }

        subset(str,current,start+1);
        subset(str, current+str.charAt(start), start+1);

    }
    public static void main(String[] args) {
        subset("ABC","",0);
    }
}
