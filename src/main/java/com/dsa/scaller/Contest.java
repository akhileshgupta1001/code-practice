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

    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<>(Arrays.asList(1,1,6,11,14,14,17,18,18,1))));
    }
}
