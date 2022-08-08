package com.dsa.geeksforgeek.string;

public class MultiplyString {
    public static  String multiply(String num1,String num2){
        int pos[] = new int[num1.length()+num2.length()];
        for(int i=num1.length()-1;i>=0;i--){
            for(int j=num2.length()-1;j>=0;j--){
                int mul = (num1.charAt(i)-'0')* (num2.charAt(j)-'0');
                int p1 = i+j;int p2 = i+j+1;
                int sum = mul + pos[p2];

                pos[p1] =pos[p1]+sum/10;
                pos[p2] =sum%10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int data:pos){
            if(!(sb.length() ==0 && data==0)) sb.append(data);
        }

        return sb.length()==0?"0" : sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(multiply("123","456"));

    }
}
