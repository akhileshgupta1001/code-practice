package com.dsa.geeksforgeek.practice;

import java.util.*;

//https://leetcode.com/problems/group-anagrams/
//Input: strs = ["eat","tea","tan","ate","nat","bat"]
//Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
public class GroupOfAnagram {

    public static List<List<String>> getAnagram(String[] arr){
        Map<String,List<String>> map = new HashMap<>();
        for(String s : arr){
            char[] data = s.toCharArray();
            Arrays.sort(data);
            String sorted = new String(data);
            if(map.containsKey(sorted)){
               map.get(sorted).add(s);
            }else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(sorted,list);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        System.out.println(getAnagram(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }

}
