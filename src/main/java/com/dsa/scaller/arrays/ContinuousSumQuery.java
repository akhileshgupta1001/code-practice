package com.dsa.scaller.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContinuousSumQuery {

    //Problem Description
    //There are A beggars sitting in a row outside a temple. Each beggar initially has an empty pot. When the devotees come to the temple, they donate some amount of coins to these beggars. Each devotee gives a fixed amount of coin(according to their faith and ability) to some K beggars sitting next to each other.
    //
    //Given the amount P donated by each devotee to the beggars ranging from L to R index, where 1 <= L <= R <= A, find out the final amount of money in each beggar's pot at the end of the day, provided they don't fill their pots by any other means.
    //For ith devotee B[i][0] = L, B[i][1] = R, B[i][2] = P, Given by the 2D array B
    //
    //
    //Problem Constraints
    //1 <= A <= 2 * 105
    //1 <= L <= R <= A
    //1 <= P <= 103
    //0 <= len(B) <= 105
    //
    //
    //Input Format
    //The first argument is a single integer A.
    //The second argument is a 2D integer array B.
    //
    //
    //Output Format
    //Return an array(0 based indexing) that stores the total number of coins in each beggars pot.
    //
    //
    //Example Input
    //Input 1:-
    //A = 5
    //B = [[1, 2, 10], [2, 3, 20], [2, 5, 25]]
    //
    //
    //Example Output
    //Output 1:-
    //10 55 45 25 25
    //
    //
    //Example Explanation
    //Explanation 1:-
    //First devotee donated 10 coins to beggars ranging from 1 to 2. Final amount in each beggars pot after first devotee: [10, 10, 0, 0, 0]
    //Second devotee donated 20 coins to beggars ranging from 2 to 3. Final amount in each beggars pot after second devotee: [10, 30, 20, 0, 0]
    //Third devotee donated 25 coins to beggars ranging from 2 to 5. Final amount in each beggars pot after third devotee: [10, 55, 45, 25, 25]


        public ArrayList<Integer> solve ( int A, ArrayList<ArrayList<Integer>>B){
            ArrayList<Integer> ans = new ArrayList<Integer>();

            for (int i = 0; i < A; i++) {
                ans.add(0);
            }

            for (int i = 0; i < B.size(); i++) {
                ArrayList<Integer> data = B.get(i);
                int start = data.get(0);
                int end = data.get(1);
                int val = data.get(2);
                ans.set(start - 1, ans.get(start - 1) + val);
                if (end < ans.size())
                    ans.set(end, ans.get(end) - val);
            }

            for (int i = 1; i < ans.size(); i++) {
                ans.set(i, ans.get(i) + ans.get(i - 1));
            }

            return ans;

    }

        public static void main (String[] args){
            List<Integer> list = Arrays.asList(2, 3, 6);
            List<Integer> list1 = Arrays.asList(2, 3, 4);
            //solve(5, new ArrayList<>(new ArrayList(Arrays.asList(list, list1)))));
        }
    }
