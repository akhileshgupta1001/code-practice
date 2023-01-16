package com.dsa.geeksforgeek.paytm;

public class Tringle {

    public static void getPrintTringle(String str){

        for(int i =0;i<str.length();i++){
            for(int j =0;j<=i;j++){
                System.out.print(str.charAt(j)+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        getPrintTringle("AKHILESH");
    }
}
