package com.dsa.scaller.hasing;

import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeSet;

public class FlipAndFindNearest {
    //Problem Description
    //Given a binary string A of size N. There are Q queries given by the 2-D array B of size Q x 2.
    //
    //Each query has 2 integers :-
    //
    //First integer denotes the type of query. Type of query can be either 1 or 2.
    //Second integer denotes index x.
    //If type = 1, Flip the value at index x.
    //
    //If type = 2, Find the index of the nearest 1 to the left or right of index x in the array. If there are multiple indices has the same distance from x, return the index with the lower value. If there is no occurrence of 1 in the array, return -1.
    //
    //Note :
    //We use 1-based indexing
    //
    //
    //
    //Problem Constraints
    //1 <= N <= 105
    //
    //1 <= Q <= 105
    //
    //1 <= B[i][0] <= 2
    //
    //1 <= B[i][1] <= N
    //
    //
    //
    //Input Format
    //First argument A is a string.
    //
    //Second argument B is a 2D array of integers describing the queries.
    //
    //
    //
    //Output Format
    //Return an array of integers denoting the answers to each query of type 2.
    //
    //
    //
    //Example Input
    //Input 1:
    //A = "10010"
    //B = [[1, 2]
    //     [2, 3]]
    //Input 2:
    //A = "010000100"
    //B = [[2, 5]
    //     [1, 7]
    //     [2, 9]]
    //
    //
    //Example Output
    //Output 1:
    //[2]
    //Output 2:
    //[7, 2]
    //
    //
    //Example Explanation
    //For Input 1:
    //After first query, A = "11010".
    //For second query, X = 3. Both index 2 and index 4 are at the same
    //distance but we choose the lower index.
    //For Input 2:
    //For first query, the index 2 is at a distance 3 and index 7 is at a distance 2. So we choose
    //index 7.
    //After second query, A = "010000000"
    //For third query, the only index with '1' is 2.
    public int[] solve(String A, int[][] B) {
        TreeSet<Integer> ts = new TreeSet<>();

        int n = A.length();
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '1') {
                ts.add(i + 1);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < B.length; i++) {
            int type = B[i][0];
            int indexValue = B[i][1];
            if (type == 1) {
                if (ts.contains(indexValue)) {
                    ts.remove(indexValue);
                } else {
                    ts.add(indexValue);
                }
            } else {
                int nearestLeftIndex = Integer.MIN_VALUE;
                int nearestRightIndex = Integer.MAX_VALUE;
                if (ts.ceiling(indexValue) != null) {
                    nearestRightIndex = ts.ceiling(indexValue);
                }
                if (ts.floor(indexValue) != null) {
                    nearestLeftIndex = ts.floor(indexValue);
                }

                if (nearestLeftIndex == Integer.MIN_VALUE && nearestRightIndex == Integer.MAX_VALUE) {
                    ans.add(-1);
                } else if (nearestLeftIndex != Integer.MIN_VALUE && (indexValue - nearestLeftIndex) <= (nearestRightIndex - indexValue)) {
                    ans.add(nearestLeftIndex);
                } else {
                    ans.add(nearestRightIndex);
                }
            }
        }
        // System.out.println("ans ="+ans);
        int[] result = new int[ans.size()];
        //int j = 0;
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }

    public static int[] nearestOnes(String A, int[][] B) {
        int n = A.length();
        int[] result = new int[B.length];

        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> rightStack = new Stack<>();

        int leftOne = -1;
        int rightOne = n;

        // Process the input string A and build the leftStack and rightStack
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '1') {
                leftOne = i;
            }
            leftStack.push(leftOne);
        }

        for (int i = n - 1; i >= 0; i--) {
            if (A.charAt(i) == '1') {
                rightOne = i;
            }
            rightStack.push(rightOne);
        }

        System.out.println("Left stack : "+leftStack);
        System.out.println("Right stack : "+rightStack);


        for (int i = 0; i < B.length; i++) {
            int queryType = B[i][0];
            int x = B[i][1];

            if (queryType == 1) {
                // Flip the value at index x
                char[] AChars = A.toCharArray();
                AChars[x - 1] = (AChars[x - 1] == '0') ? '1' : '0';
                A = new String(AChars);
            } else {
                // Find the nearest 1 to the left and right of index x
                int leftDistance = x - leftStack.get(x - 1);
                int rightDistance = rightStack.get(x - 1) - x;

                if (leftDistance <= rightDistance) {
                    result[i] = leftStack.get(x - 1) + 1;
                } else {
                    result[i] = rightStack.get(x - 1) + 1;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String A1 = "10010";
        int[][] B1 = {{1, 2}, {2, 3}};
        int[] output1 = nearestOnes(A1, B1);
        for (int num : output1) {
            System.out.print(num + " "); // Output: 2
        }

        System.out.println();

        String A2 = "010000100";
        int[][] B2 = {{2, 5}, {1, 7}, {2, 9}};
        int[] output2 = nearestOnes(A2, B2);
        for (int num : output2) {
            System.out.print(num + " "); // Output: 7 2
        }
    }


}
