package com.dsa.scaller.hasing;

import java.util.HashSet;
import java.util.Set;

public class ColourFullNumber {
    public static int colorful(int A) {
        Set<Integer> set = new HashSet<>();
        String str = String.valueOf(A);
        for (int i = 0; i < str.length(); i++) {
            // String s= "";
            for (int j = i; j < str.length(); j++) {
                int sum = 1;
                for (int k = i; k <= j; k++) {
                    sum = sum * Integer.parseInt(String.valueOf(str.charAt(k)));
                }
                if (set.contains(sum)) return 0;
                set.add(sum);
            }
        }
        System.out.println(set);
        return 1;
    }

    public static int colorful2(int A) {
        Set<Integer> set = new HashSet<>();
        String str = String.valueOf(A);
        for (int i = 0; i < str.length(); i++) {
             int  product= 1;
            for (int j = i; j < str.length(); j++) {
                product = product*Integer.parseInt(String.valueOf(str.charAt(j)));
                if (set.contains(product)) return 0;
                set.add(product);
            }


        }
       // System.out.println(set);
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(colorful2(23));
    }
}
