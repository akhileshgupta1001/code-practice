package com.dsa.geeksforgeek.arrays;

import java.util.LinkedHashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/find-winner-election-votes-represented-candidate-names/
public class ElectionWinner {

    /*
   Input:  votes[] = {“john”, “johnny”, “jackie”, “johnny”, “john”, “jackie”, “jamie”, “jamie”, “john”, “johnny”, “jamie”, “johnny”, “john”}
Output: John
Explanation: We have four Candidates with name as ‘John’, ‘Johnny’, ‘jamie’, ‘jackie’. The candidates John and Johny get maximum votes. Since John is alphabetically smaller.

Input: votes[] = {“virat”, “rohit”, “rishabh”, “rohit”, “virat”, “rohit”}
Output: rohit
Explanation: We have three Candidates with name as ‘virat’, ‘rohit’, ‘rishabh’. rohit get maximum votes.
     */
    public static String[] winner(String arr[], int n)
    {
        Map<String,Integer> map = new LinkedHashMap<>();

        for(int i=0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        int max =0;
        String result="";
        for(Map.Entry<String,Integer> entry: map.entrySet()){

            if(entry.getValue()>max){
                max = entry.getValue();
                result = entry.getKey();
            }else if(entry.getValue()==max){
                int k = result.compareTo(entry.getKey());
                if(k>0){
                    result = entry.getKey();
                }
            }
        }
        return new String[]{result,String.valueOf(max)};
    }
}
