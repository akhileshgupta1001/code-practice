package com.dsa.scaller.prime;

import java.util.ArrayList;
import java.util.Arrays;

public class FindAllPrimes {

    public static int[] solve(int A) {
        boolean[] prime = new boolean[A + 1];
        Arrays.fill(prime, true);
        for (int i = 2; i * i <= A; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= A; j = j + i) {
                    prime[j] = false;
                }
            }
        }
        System.out.println("*****************");
        for (int i = 2; i < prime.length; i++) {
            System.out.println(i+ " : "+prime[i]);
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 2; i <= A; i++) {
            if (prime[i])
                ans.add(i);
        }
        System.out.println(ans);
        return ans.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        solve(49);
    }
}
