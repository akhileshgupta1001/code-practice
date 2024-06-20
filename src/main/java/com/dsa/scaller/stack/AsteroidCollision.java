package com.dsa.scaller.stack;

//https://leetcode.com/problems/asteroid-collision/description/?envType=study-plan-v2&envId=leetcode-75
//Example 1:
//
//Input: asteroids = [5,10,-5]
//Output: [5,10]
//Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
//Example 2:
//
//Input: asteroids = [8,-8]
//Output: []
//Explanation: The 8 and -8 collide exploding each other.
//Example 3:
//
//Input: asteroids = [10,2,-5]
//Output: [10]
//Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>(); // Create a stack to simulate asteroid collisions

        // Traverse each asteroid in the input array
        for (int asteroid : asteroids) {
            // Check if the current asteroid is positive (moving right) or the stack is empty or the top asteroid in the stack is negative (moving left)
            if (asteroid > 0 || stack.isEmpty() || stack.peek() < 0) {
                stack.push(asteroid); // If any of the above conditions are true, add the current asteroid to the stack
            } else {
                // Handle collision when the current asteroid is negative (moving left) and the top asteroid in the stack is positive (moving right)
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) {
                    stack.pop(); // Remove smaller positive asteroids destroyed by the current negative asteroid
                }
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid); // If the stack is empty or the top asteroid is negative after collision, add the current asteroid to the stack
                } else if (stack.peek() == Math.abs(asteroid)) {
                    stack.pop(); // If the top asteroid is destroyed by the current asteroid, remove it from the stack
                }
            }
        }

        // Convert the remaining asteroids in the stack to an array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        System.out.println("Arrays : "+ Arrays.toString(result));
        // Return the array containing the remaining asteroids after all collisions
        return result;
    }

    public static void main(String[] args) {
        new AsteroidCollision().asteroidCollision(new int[]{5,10,-5});
    }
}
