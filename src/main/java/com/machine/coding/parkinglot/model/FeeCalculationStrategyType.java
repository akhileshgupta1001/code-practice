package com.machine.coding.parkinglot.model;

import java.util.Arrays;

public class FeeCalculationStrategyType {
    public static double findMaxAverage(int[] nums, int k) {
        double ans = 0.0;
        int sum = 0;

        // Calculate the sum of the first k elements
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        ans = (double) sum / k; // Update the initial ans

        // Update sum and ans for remaining subarrays of length k
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k]; // Update the sum by adding the current element and subtracting the element k positions back

            ans = Math.max(ans, (double) sum / k); // Update the ans if a higher average is found
        }

        return ans;
    }

    public static int maxVowels(String s, int k) {

        int ans =0;
       // StringBuilder sb = new StringBuilder(s);
        String vowels ="aeiou";



        for(int i=0;i<=s.length()-k;i++){
           String sub = s.substring(i,i+k);
            int vowelCount =0;
           for(int j=0;j<sub.length();j++){
               if(vowels.indexOf(sub.charAt(j))!=-1){
                   vowelCount++;
               }
           }
           ans = Math.max(ans,vowelCount);
           System.out.println("String : "+sub+" , vowel count : "+vowelCount);
        }
        return ans;

    }
    public static int compress(char[] chars) {
        int index = 0;  // current position to write in the array
        int i = 0;      // current position to read from the array

        while (i < chars.length) {
            int count = 1;
            char currentChar = chars[i];

            // Count consecutive occurrences of the current character
            while (i + 1 < chars.length && chars[i] == chars[i + 1]) {
                count++;
                i++;
            }

            // Write the current character to the array
            chars[index++] = currentChar;

            // Write the count if it is greater than 1
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[index++] = c;
                }
            }

            i++;  // move to the next character
        }
        System.out.println("Arrays : "+ Arrays.toString(chars));
        return index;
    }

    public static int solve(int[] A, int B) {
        int n = A.length;
        int target= B;
        int[][] dp = new int[n][target+1];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        System.out.println(isSubSet(n-1,target,A,dp)==true?1:0);
        return 1;
    }

    public static boolean isSubSet(int index, int target, int[] A, int[][] dp){
        if (target == 0) return true;

        if (dp[index][target] != -1) {
            return dp[index][target] == 0 ? false : true;
        }

        if (index == 0) {
            dp[index][target] = A[index] == target ? 1 : 0;
            return dp[index][target] == 1;
        }

        boolean notTaken = isSubSet(index-1,target,A,dp);
        boolean taken = false;
        if(A[index]<=target){
            taken = isSubSet(index,target-A[index],A,dp);
        }
        dp[index][target] = (notTaken|| taken )?1:0;

        return (notTaken|| taken );
    }
    public static void main(String[] args) {
       // findMaxAverage(new int[]{1,12,-5,-6,50,3},4);
        //maxVowels("weallloveyou",7);
        char[] charArray = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};

       // compress(charArray);

        solve(new int[]{1,2,3,4,5},100);
    }
}
