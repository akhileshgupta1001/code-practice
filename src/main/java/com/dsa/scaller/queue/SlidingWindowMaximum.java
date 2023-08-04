package com.dsa.scaller.queue;

import java.util.*;

public class SlidingWindowMaximum {
    //Problem Description
    //Given an array of integers A. There is a sliding window of size B, moving from the very left of the array to the very right. You can only see the B numbers in the window. Each time the sliding window moves rightwards by one position. You have to find the maximum for each window.
    //
    //Return an array C, where C[i] is the maximum value in the array from A[i] to A[i+B-1].
    //
    //Refer to the given example for clarity.
    //
    //NOTE: If B > length of the array, return 1 element with the max of the array.
    //
    //
    //
    //Problem Constraints
    //1 <= |A|, B <= 106
    //
    //
    //
    //Input Format
    //The first argument given is the integer array A.
    //
    //The second argument given is the integer B.
    //
    //
    //
    //Output Format
    //Return an array C, where C[i] is the maximum value of from A[i] to A[i+B-1].
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = [1, 3, -1, -3, 5, 3, 6, 7]
    // B = 3
    //Input 2:
    //
    // A = [1, 2, 3, 4, 2, 7, 1, 3, 6]
    // B = 6
    //
    //
    //Example Output
    //Output 1:
    //
    // [3, 3, 5, 5, 6, 7]
    //Output 2:
    //
    // [7, 7, 7, 7]
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // Window position     | Max
    // --------------------|-------
    // [1 3 -1] -3 5 3 6 7 | 3
    // 1 [3 -1 -3] 5 3 6 7 | 3
    // 1 3 [-1 -3 5] 3 6 7 | 5
    // 1 3 -1 [-3 5 3] 6 7 | 5
    // 1 3 -1 -3 [5 3 6] 7 | 6
    // 1 3 -1 -3 5 [3 6 7] | 7
    //Explanation 2:
    //
    // Window position     | Max
    // --------------------|-------
    // [1 2 3 4 2 7] 1 3 6 | 7
    // 1 [2 3 4 2 7 1] 3 6 | 7
    // 1 2 [3 4 2 7 1 3] 6 | 7
    // 1 2 3 [4 2 7 1 3 6] | 7

    public static ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        // Process the first window of size B
        for (int i = 0; i < B; i++) {
            while (!deque.isEmpty() && A.get(deque.peekLast()) <= A.get(i)) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        // Add the maximum of the first window to the ans ArrayList
        ans.add(A.get(deque.peek()));

        // Process the remaining windows
        for (int i = B; i < A.size(); i++) {
            // Remove elements from the deque that are outside the current window
            while (!deque.isEmpty() && deque.peek() <= i - B) {
                deque.removeFirst();
            }

            // Remove smaller elements from the rear until we get the maximum
            while (!deque.isEmpty() && A.get(deque.peekLast()) <=A.get(i)) {
                deque.removeLast();
            }

            // Add the current index to the rear of the deque
            deque.addLast(i);

            // Add the maximum element of the current window to the ans ArrayList
            ans.add(A.get(deque.peek()));
        }
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        slidingMaximum(new ArrayList<>(Arrays.asList(1, 3, -1, -3, 5, 3, 6, 7)),3);

       // Input 1:
        //A = [1, 3, -1, -3, 5, 3, 6, 7]
        // B = 3
        //Output 1:
        //
        // [3, 3, 5, 5, 6, 7]
    }

}
