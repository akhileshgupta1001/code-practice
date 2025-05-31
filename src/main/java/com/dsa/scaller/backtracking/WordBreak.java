package main.java.com.dsa.scaller.backtracking;

//https://www.scaler.com/academy/mentee-dashboard/class/366860/assignment/problems/23?navref=cl_tt_lst_sl

import java.util.*;

public class WordBreak {
    //Given a string A and a dictionary of words B, determine if A can be segmented into a space-separated sequence of one or more dictionary words.
    //
    //Input Format:
    //
    //The first argument is a string, A.
    //The second argument is an array of strings, B.
    //Output Format:
    //
    //Return 0 / 1 ( 0 for false, 1 for true ) for this problem.
    //Constraints:
    //
    //1 <= len(A) <= 6500
    //1 <= len(B) <= 10000
    //1 <= len(B[i]) <= 20
    //Examples:
    //
    //Input 1:
    //    A = "myinterviewtrainer",
    //    B = ["trainer", "my", "interview"]
    //
    //Output 1:
    //    1
    //
    //Explanation 1:
    //    Return 1 ( corresponding to true ) because "myinterviewtrainer" can be segmented as "my interview trainer".
    //
    //Input 2:
    //    A = "a"
    //    B = ["aaa"]
    //
    //Output 2:
    //    0
    //
    //Explanation 2:
    //    Return 0 ( corresponding to false ) because "a" cannot be segmented as "aaa".

    //T.C ( N* 2^n )
    // S.C
    public static int wordBreak(String A, List<String> B) {

        if(A.length()==0) return 1;

        for(int i=1;i<=A.length();i++){
            String sub = A.substring(0,i);
            if(B.contains(sub)){
                if(wordBreak(A.substring(i),B)==1){
                    return 1;
                }
            }
        }
        return 0;
    }

    //String:       l   e   e   t   c   o   d   e
    //Index:    0   1   2   3   4   5   6   7   8
    //           ↓                       ↓
    //DP:      [ T,  F,  F,  F,  T,  F,  F,  F,  T ]
    //                       ↑           ↑
    //                "leet" ∈ dict   "code" ∈ dict
    public int wordBreak(String A, ArrayList<String> B) {
        boolean[] dp = new boolean[A.length()+1];
        Set<String> dict = new HashSet<>(B);
        dp[0]=true;

        for(int i=1;i<=A.length();i++){
            for(int j=0;j<i;j++){
                if (dp[j] && dict.contains(A.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[A.length()]==true?1:0;
    }

    //The problem is a classic **Word Break Problem**, and your solution uses **Dynamic Programming (DP)**. However, it **fails on large input** due to **time complexity** — particularly from checking all possible substrings.
    //
    //---
    //
    //### ✅ **What the code does (short summary)**
    //
    //The code checks whether a given string `A` can be split into words **only using the words from list `B`**.
    //
    //---
    //
    //### 📈 Time Complexity Issue
    //
    //Your code:
    //
    //```java
    //for (int i = 1; i <= A.length(); i++) {
    //    for (int j = 0; j < i; j++) {
    //        if (dp[j] && dict.contains(A.substring(j, i))) {
    //            dp[i] = true;
    //            break;
    //        }
    //    }
    //}
    //```
    //
    //* Worst case: `O(N^2)` where `N = length of A`
    //* `A.substring(j, i)` takes `O(i-j)` time
    //* So effective worst-case is **`O(N^3)`**, which causes **TLE (Time Limit Exceeded)** for large inputs
    //
    //---
    //
    //### 🧠 **Conceptual Diagram for Input**
    //
    //Let's take a **smaller example**:
    //
    //**Input**
    //
    //```
    //A = "leetcode"
    //B = ["leet", "code"]
    //```
    //
    //### 📊 DP Table Explanation
    //
    //We use a boolean array `dp[i]` to represent:
    //
    //> Can the substring `A[0...i-1]` be segmented using dictionary words?
    //
    //#### Initial:
    //
    //```text
    //A = l e e t c o d e
    //idx 0 1 2 3 4 5 6 7 8
    //dp: T F F F F F F F F  → dp[0] = true (empty string)
    //```
    //
    //#### Iteration steps:
    //
    //1. i=4, check if substring `"leet"` is in dictionary → ✅
    //
    //   ```text
    //   dp[4] = true
    //   ```
    //
    //2. i=8, check if `"code"` is in dictionary and `dp[4] == true` → ✅
    //
    //   ```text
    //   dp[8] = true
    //   ```
    //
    //### 📌 Final DP array:
    //
    //```text
    //dp: T F F F T F F F T
    //```
    //
    //So, `dp[8] == true` ⇒ can break `"leetcode"` into `"leet"` + `"code"`
    //
    //---
    //
    //### 🧩 Diagram
    //
    //```
    //"leetcode"
    //
    //|----leet----|----code----|
    //   [true]         [true]
    //     ↑              ↑
    //   dp[4]         dp[8] = true
    //```
    //
    //---
    //
    //### ⚠️ Why Your Code Fails on Large Inputs
    //
    //Let’s say:
    //
    //* A.length() = 10⁵
    //* B has hundreds of strings
    //* The inner loop checks all substrings → leads to millions of substring operations
    //
    //**Java `String.substring(j, i)` creates new strings — it's costly!**
    //
    //---
    //
    //### ✅ Optimized Approach Using Trie (or limiting substring checks)
    //
    //* Use a **Trie** for dictionary
    //* OR optimize inner loop by checking only substrings of length ≤ max word length in `B`
    //
    //Would you like an optimized version of your code that handles large inputs?


    public int wordBreakOptimised(String A, ArrayList<String> B) {
        Set<String> dict = new HashSet<>(B);
        int maxLen = 0;
        for (String word : B) {
            maxLen = Math.max(maxLen, word.length());
        }

        boolean[] dp = new boolean[A.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= A.length(); i++) {
            for (int j = Math.max(0, i - maxLen); j < i; j++) {
                if (dp[j] && dict.contains(A.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[A.length()] ? 1 : 0;
    }

    //Let's break down **why this optimized solution works**, with a **step-by-step dry run, diagram**, and **clear explanation**.
    //
    //---
    //
    //## 🔍 Problem Recap
    //
    //Given a string `A` and a dictionary of words `B`, return `1` if the string can be segmented into words from `B`, otherwise return `0`.
    //
    //---
    //
    //## ✅ Key Improvements in This Code
    //
    //```java
    //for (int j = Math.max(0, i - maxLen); j < i; j++)
    //```
    //
    //This restricts the inner loop to only check substrings of **maximum word length**, avoiding checking all `j = 0...i-1`.
    //
    //---
    //
    //## 🔑 Why This Optimization Works
    //
    //* If the longest word in dictionary `B` is length 5, we never need to check substrings longer than 5 characters.
    //* So instead of `O(N^2)` substring checks, we do only up to `O(N * maxWordLength)`.
    //
    //---
    //
    //## 🧠 Dry Run Example
    //
    //Let’s dry-run this code with an example:
    //
    //### 📌 Inputs:
    //
    //```java
    //A = "applepenapple"
    //B = ["apple", "pen"]
    //```
    //
    //### ✅ Dictionary:
    //
    //```text
    //dict = { "apple", "pen" }
    //maxLen = 5
    //```
    //
    //---
    //
    //### 💡 Concept
    //
    //Use DP array `dp[i]`:
    //
    //> `dp[i] = true` if the substring `A[0..i-1]` can be segmented using words in B
    //
    //---
    //
    //### ✅ Initialize
    //
    //```text
    //dp[0] = true // Empty string
    //dp[1...15] = false
    //```
    //
    //---
    //
    //### 🧮 Iterations
    //
    //Let's walk through some important steps.
    //
    //#### `i = 5`
    //
    //* Check `j = 0` → `A[0..5] = "apple"` → in dict ✅
    //* `dp[0] == true` ⇒ `dp[5] = true`
    //
    //#### `i = 8`
    //
    //* Check `j = 3, 4, 5`
    //* At `j = 5`, `A[5..8] = "pen"` → in dict ✅ and `dp[5] = true`
    //* ⇒ `dp[8] = true`
    //
    //#### `i = 13`
    //
    //* Check `j = 8` → `A[8..13] = "apple"` → in dict ✅ and `dp[8] = true`
    //* ⇒ `dp[13] = true`
    //
    //---
    //
    //### 📊 Final DP Array:
    //
    //| i (index) | A\[0..i-1]      | dp\[i] |
    //| --------- | --------------- | ------ |
    //| 0         | ""              | true   |
    //| 1–4       | "a"..."appl"    | false  |
    //| 5         | "apple"         | true   |
    //| 6–7       | "applep", ...   | false  |
    //| 8         | "applepen"      | true   |
    //| 9–12      | "applepena" ... | false  |
    //| 13        | "applepenapple" | true   |
    //
    //---
    //
    //## ✅ Final Result
    //
    //```java
    //return dp[13] ? 1 : 0 → 1
    //```
    //
    //---
    //
    //## 📉 Diagram
    //
    //```
    //String: "applepenapple"
    //Index:   0    5    8   13
    //         |----|----|----|
    //         "apple" "pen" "apple"
    //
    //dp[0] = true
    //dp[5] = true (apple found from 0 to 5)
    //dp[8] = true (pen found from 5 to 8)
    //dp[13] = true (apple found from 8 to 13)
    //```
    //
    //---
    //
    //## 🟢 Summary: Why This Solution Works
    //
    //| Point              | Explanation                                                     |
    //| ------------------ | --------------------------------------------------------------- |
    //| ✅ Efficient DP     | Uses `dp[i]` to store whether A\[0..i-1] is segmentable         |
    //| 🔁 Optimized Loop  | Limits `j` to only check substrings up to `maxLen`              |
    //| ⏱️ Time Complexity | `O(N * maxWordLength)` – far better than `O(N^2)`               |
    //| 🔒 Correctness     | Only sets `dp[i]` if some `dp[j]` is true and `A[j..i]` in dict |
    //
    //---
    //
    //Would you like a visual animation (frame by frame) to better understand the DP buildup?

    public static void main(String[] args) {
        //["interview","my","trainer"]
        wordBreak("myinterviewtrainer", Arrays.asList("interview","my","trainer"));
    }

}
