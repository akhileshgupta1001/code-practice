package com.dsa.scaller.binarysearch.practice;

//https://leetcode.com/problems/koko-eating-bananas/
public class KokoEatingBananas {

//    Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
//
//Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
//
//Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
//
//Return the minimum integer k such that she can eat all the bananas within h hours.
//
// 
//
//Example 1:
//
//Input: piles = [3,6,7,11], h = 8
//Output: 4
//Example 2:
//
//Input: piles = [30,11,23,4,20], h = 5
//Output: 30
//Example 3:
//
//Input: piles = [30,11,23,4,20], h = 6
//Output: 23
// 
//
//Constraints:
//
//1 <= piles.length <= 104
//piles.length <= h <= 109
//1 <= piles[i] <= 109

    public int minEatingSpeed(int[] piles, int h) {
        long low = 1;
        long high = 0;
        for (int i = 0; i < piles.length; i++) {
            high += piles[i];
        }

        long ans = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (isEatingPossible(piles, mid, h)) {
                high = mid - 1;
                ans = mid;
            } else {
                low = mid + 1;
            }
        }
        return (int) ans;
    }

    private boolean isEatingPossible(int[] piles, long mid, int h) {
        long time = 0;
        for (int i = 0; i < piles.length; i++) {
            time += (long) Math.ceil(piles[i] * 1.0 / mid);
        }
        return time <= h;
    }


}
