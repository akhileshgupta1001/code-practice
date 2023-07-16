package com.dsa.scaller.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Contest2 {
    public int solve(int[] A) {
        if(A.length==1) return 1;
        ArrayList<Integer> org = new ArrayList<>();
        Arrays.sort(A);
        Arrays.stream(A).forEach(data->org.add(data));

        int ans =0;
        for(int i=0;i<org.size();i++){
            if(Math.abs(A[i]-org.get(i))==1) continue;

            if(Math.abs(A[i]-org.get(i))==1){
                ans++;
            }else{
                break;
            }
        }
        if(ans ==0) return -1;
        return ans==1?1:ans-1;
    }

    public static int[] solve2(int[] A, int[] B) {
        //int sum =0;
        int mod = (int) 1e9+7;
        for(int i=1;i<A.length;i++){
            A[i]= (A[i-1] % mod +A[i] % mod) %mod;
        }
        int ans[] =new int[B.length];

        for(int i=0;i<B.length;i++){
            int data = B[i];
            int start=0;
            int end = A.length-1;
            while (start<end){
                if(data>A[end]){
                    ans[i]= end+1;
                    break;
                }else if(data<A[end]){
                    end--;
                }else{
                    start++;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(solve2(new int[]{23,36,58,59},new int[]{3,207,62,654,939,680,760}));
    }
}
