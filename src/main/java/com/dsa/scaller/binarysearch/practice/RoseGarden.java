package com.dsa.scaller.binarysearch.practice;

//https://www.codingninjas.com/studio/problems/rose-garden_2248080?utm_source=youtube&utm_medium=affiliate&utm_campaign=codestudio_Striver_BinarySeries&leftPanelTab=0
public class RoseGarden {
        public static int roseGarden(int[] arr, int r, int b) {
            // Write your code here.

            int low = Integer.MAX_VALUE;
            int high = Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; i++) {
                low = Math.min(low, arr[i]);
                high = Math.max(high, arr[i]);
            }

            int ans = -1;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (isPossibleBounqute(arr, mid, r, b)) {
                    high = mid - 1;
                    ans = mid;
                } else {
                    low = mid + 1;
                }
            }

            return ans;
        }


       public static boolean isPossibleBounqute(int[] arr, int mid, int r, int b) {
            int ans = 0;
            int count = 0;
            int maxBouteque = 0;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] <= mid) {
                    count++;
                    if (count == r) {
                        maxBouteque++;
                        count=0;
                    }
                } else {
                    count = 0;
                }
            }

            return maxBouteque >= b;

        }


    public static void main(String[] args) {
      int arr[] = new int[]{3 ,3, 6, 8, 13, 17, 6, 16};
        System.out.println(roseGarden(arr,2,2));

      }

}
