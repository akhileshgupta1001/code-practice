package com.dsa.scaller;

import java.util.ArrayList;
import java.util.Arrays;

public class Contest {
    public static Long solve(ArrayList<Integer> A) {
        long maxValue = A.get(0);
        long sum = maxValue;
        long currectMaxValue = maxValue;
        for (int i = 1; i < A.size(); i++) {
            if(A.get(i - 1) == A.get(i)){
                continue;
            }
            if (A.get(i - 1) < A.get(i)) {
                if (currectMaxValue <= A.get(i)) {
                    currectMaxValue = Math.max(currectMaxValue, A.get(i));
                    sum = sum + A.get(i);
                    maxValue = Math.max(sum, maxValue);
                    if (sum < 0) {
                        sum = 0;
                    }
                } else {
                    break;
                }

            } else {
                break;
            }
        }
        return maxValue;
    }


    public static ArrayList<Integer> solve(int A, int B) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] isPrime = new boolean[B+1];
        Arrays.fill(isPrime,true);
        for(int i=0;i<2;i++){
            isPrime[i]= false;
        }
        for(int i=2;i<=B;i++){
            if(isPrime[i]){
                for(int j=i*i;j<=B;j=j+i){
                    //if(j<=B)
                    isPrime[j] = false;
                }
                if( i>= A && isPrime[i] && ((i==3 && i%3==0) || (i%10==3))){
                    ans.add(i);
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
       // System.out.println(solve(new ArrayList<>(Arrays.asList(1,1,6,11,14,14,17,18,18,1))));
        System.out.println(solve(225,848));
    }
}
