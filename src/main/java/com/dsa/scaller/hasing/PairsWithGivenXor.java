package com.dsa.scaller.hasing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PairsWithGivenXor {
    //Problem Description
    //Given an integer array A containing N distinct integers.
    //
    //Find the number of unique pairs of integers in the array whose XOR is equal to B.
    //
    //NOTE:
    //
    //Pair (a, b) and (b, a) is considered to be the same and should be counted once.
    //
    //
    //Problem Constraints
    //1 <= N <= 105
    //
    //1 <= A[i], B <= 107
    //
    //
    //
    //Input Format
    //The first argument is an integer array A.
    //
    //The second argument is an integer B.
    //
    //
    //
    //Output Format
    //Return a single integer denoting the number of unique pairs of integers in the array A whose XOR is equal to B.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = [5, 4, 10, 15, 7, 6]
    // B = 5
    //Input 2:
    //
    // A = [3, 6, 8, 10, 15, 50]
    // B = 5
    //
    //
    //Example Output
    //Output 1:
    //
    // 1
    //Output 2:
    //
    // 2
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // (10 ^ 15) = 5
    //Explanation 2:
    //
    // (3 ^ 6) = 5 and (10 ^ 15) = 5

    public int solve(ArrayList<Integer> A, int B) {
        Set<Integer> set = new HashSet<>();

        int N = A.size();
        int count = 0;
        for (int i = 0; i < N; i++) {
      // A[i]^A[j]=B which means A[j]=A[i]^B;
            // Hence, checking if A[j] present in the set
            if (set.contains(A.get(i) ^ B)) count++;
//Add the current element to the set
            set.add(A.get(i));
        }
        return count;
    }

    public int solve(ArrayList<String> A, String B) {
        char[] arr = B.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < B.length(); i++) {
            map.put(arr[i], i);
        }

        for (int i = 1; i < A.size(); i++) {
            String first = A.get(i - 1);
            String second = A.get(i);
            int min = Math.min(first.length(), second.length());
            int flag = 0;
            for (int j = 0; j < min; j++) {
                if (!(map.get(first.charAt(j)) < map.get(second.charAt(j)))) {
                    return 0;
                } else if (map.get(first.charAt(j)) == map.get(second.charAt(j))) {
                    continue;
                } else {
                    flag = 1;
                    break;
                }
            }
            // all chacter matches till min index and
            if (flag == 0 && first.length() > second.length()) {
                return 0;
            }

        }

        return 1;
    }
}
