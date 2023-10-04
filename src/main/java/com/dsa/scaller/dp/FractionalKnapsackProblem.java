package com.dsa.scaller.dp;

//Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.
//
//Also given an integer C which represents knapsack capacity.
//
//Find out the maximum total value that we can fit in the knapsack. If the maximum total value is ans, then return ⌊ans × 100⌋ , i.e., floor of (ans × 100).
//
//NOTE:
//
//You can break an item for maximizing the total value of the knapsack
//
//
//Problem Constraints
//1 <= N <= 105
//
//1 <= A[i], B[i] <= 103
//
//1 <= C <= 103
//
//
//
//Input Format
//First argument is an integer array A of size N denoting the values on N items.
//
//Second argument is an integer array B of size N denoting the weights on N items.
//
//Third argument is an integer C denoting the knapsack capacity.
//
//
//
//Output Format
//Return a single integer denoting the maximum total value of A such that sum of the weights of this subset is smaller than or equal to C.
//
//
//
//Example Input
//Input 1:
//
// A = [60, 100, 120]
// B = [10, 20, 30]
// C = 50
//Input 2:
//
// A = [10, 20, 30, 40]
// B = [12, 13, 15, 19]
// C = 10
//
//
//Example Output
//Output 1:
//
// 24000
//Output 2:
//
// 2105
//
//
//Example Explanation
//Explanation 1:
//
//Taking the full items with weight 10 and 20 and 2/3 of the item with weight 30 will give us
//the maximum value i.e 60 + 100 + 80 = 240. So we return 24000.
//Explanation 2:
//
//Taking 10/19 the fourth item gives us the maximum value i.e. 21.0526. So we return 2105.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FractionalKnapsackProblem {
}
class Item {
    int value;
    int weight;

    public Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

class ItemComparator implements Comparator<Item> {
    @Override
    public int compare(Item i1, Item i2) {
        double perUnitVal1 = (i1.value * 1.0) / i1.weight;
        double perUnitVal2 = (i2.value * 1.0) / i2.weight;
        /*if (perUnitVal2 > perUnitVal1) return 1;
        return -1;*/
        return Double.compare(perUnitVal2, perUnitVal1);
    }
}

 class Solution {
    public int solve(int[] A, int[] B, int C) {
        ArrayList<Item> items = new ArrayList<Item>();
        for (int i = 0; i < A.length; i++) {
            items.add(new Item(A[i], B[i]));
        }

        Collections.sort(items, new ItemComparator());

        int total = 0;
        for (int i = 0; i < items.size(); i++) {
            Item it = items.get(i);
            if (C > 0 && it.weight <= C) {
                total += it.value * 100;
                C -= it.weight;
            } else if (C > 0) {
                double val = (double) (C * it.value * 100) / (double) it.weight;
                total += (int) val;
                break;
            }
        }

        return total;
    }
}

