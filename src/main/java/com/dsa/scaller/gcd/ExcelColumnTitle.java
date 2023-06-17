package com.dsa.scaller.gcd;

public class ExcelColumnTitle {
    public static String convertToTitle(int A) {
        String res = "";
        while (A > 0) {
            int temp = (A - 1) % 26;
            res = res + (char) ('A' + temp);
            A = (A - 1) / 26;
        }
        StringBuffer sb = new StringBuffer(res);
        sb.reverse();
        res = sb.toString();
        return res;
    }


    public static void main(String[] args) {
        System.out.println(convertToTitle(26));
    }
}
