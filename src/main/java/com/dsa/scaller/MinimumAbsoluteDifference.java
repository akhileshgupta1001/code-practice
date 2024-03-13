package com.dsa.scaller;

import java.util.Arrays;

public class MinimumAbsoluteDifference {


        public static int minimumAbsoluteDifference(int[][] prices, int k) {
            int numCategories = prices.length;
            int numProducts = prices[0].length;

            if (numCategories == 0 || numProducts == 0) {
                return 0;
            }

            int maxPrice = Integer.MIN_VALUE;
            for (int i = 0; i < numCategories; i++) {
                maxPrice = Math.max(maxPrice, prices[i][0]); // Selecting the only item from each category
            }

            int minAbsoluteDifference = Math.max(0, maxPrice - k);
            return minAbsoluteDifference;
        }

        public static void main(String[] args) {
            int[][] prices = {
                    {1},
                    {2},
                    {3}
            };
            int k = 100;

            System.out.println("Minimum absolute difference between selected items: " + minimumAbsoluteDifference(prices, k));
        }


}
