package com.dsa.scaller.recursion;

import java.util.ArrayList;

public class Combinations {
    static ArrayList<ArrayList<Integer>> ans;

    public static ArrayList<ArrayList<Integer>> combine(int A, int B) {
        ans = new ArrayList<>();
        ArrayList<Integer> cur = new ArrayList<>();
        solve(1, cur, A, B);
        return ans;
    }

    static void solve(int idx, ArrayList<Integer> cur, int A, int B) {
        if (cur.size() == B) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        if (idx == A + 1)
            return;
        // Include current element
        cur.add(idx);
        solve(idx + 1, cur, A, B);
        cur.remove(cur.size() - 1);
        // Don't include current element
        solve(idx + 1, cur, A, B);
    }

    public static void main(String[] args) {
        System.out.println(combine(3,2));
    }

}
