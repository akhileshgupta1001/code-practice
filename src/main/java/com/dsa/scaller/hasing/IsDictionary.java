package com.dsa.scaller.hasing;

import java.util.ArrayList;
import java.util.HashMap;

public class IsDictionary {
    //Problem Description
    //Surprisingly, in an alien language, they also use English lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
    //
    //Given an array of words A of size N written in the alien language, and the order of the alphabet denoted by string B of size 26, return 1 if and only if the given words are sorted lexicographically in this alien language else, return 0.
    //
    //
    //
    //Problem Constraints
    //1 <= N, length of each word <= 105
    //
    //Sum of the length of all words <= 2 * 106
    //
    //
    //
    //Input Format
    //The first argument is a string array A of size N.
    //
    //The second argument is a string B of size 26, denoting the order.
    //
    //
    //
    //Output Format
    //Return 1 if and only if the given words are sorted lexicographically in this alien language else, return 0.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = ["hello", "scaler", "interviewbit"]
    // B = "adhbcfegskjlponmirqtxwuvzy"
    //Input 2:
    //
    // A = ["fine", "none", "no"]
    // B = "qwertyuiopasdfghjklzxcvbnm"
    //
    //
    //Example Output
    //Output 1:
    //
    // 1
    //Output 2:
    //
    // 0
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // The order shown in string B is: h < s < i for the given words. So return 1.
    //Explanation 2:
    //
    // "none" should be present after "no". Return 0.

    public int solve(ArrayList<String> A, String B) {
        char[] arr = B.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<B.length();i++){
            map.put(arr[i],i);
        }
        for(int i=1;i<A.size();i++){
            String first = A.get(i-1);
            String second = A.get(i);
            int min = Math.min(first.length(),second.length());
            int flag =0;
            for(int j=0;j<min;j++){
                if((map.get(first.charAt(j)) > map.get(second.charAt(j)))){
                    return 0;
                }else if(map.get(first.charAt(j)).equals(map.get(second.charAt(j)))){
                    continue;
                }else{
                    flag =1;
                    break;
                }
            }
            // all chacter matches till min index and
            if(flag==0 && first.length()>second.length()){
                return 0;
            }
        }
        return 1;
    }
}
