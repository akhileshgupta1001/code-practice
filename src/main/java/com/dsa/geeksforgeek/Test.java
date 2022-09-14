package com.dsa.geeksforgeek;

public class Test {
    public static int getLongestString(String str){
        int result =0;
        String data = "";
        for(int i =0;i<str.length();i++){
            boolean isVisted[] = new boolean[256];
            for(int j=i;j<str.length();j++){

                if(isVisted[str.charAt(j)]==true) {
                    data ="";
                    break;
                }
                else {
                    isVisted[str.charAt(j)]=true;
                    data = data+str.charAt(j);
                    result = Math.max(result,j-i+1);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(getLongestString("abac"));
     ;
    }
}
