package com.dsa.geeksforgeek.recursuion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PermutaionOfString {

    public static List<List<Integer>> permutationArray(int[] arr){
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[arr.length];
         backtracking(ans,arr,visited,new ArrayList<>());
        System.out.println(ans);
        return ans;

    }

    private static void backtracking(List<List<Integer>> ans, int[] arr, boolean[] visited,ArrayList current) {

        if(current.size()==arr.length){
            ans.add(new ArrayList<>(current));
            return;
        }

        for(int i=0;i<arr.length;i++){
            if(visited[i]==true) continue;
            current.add(arr[i]);
            visited[i]=true;
            backtracking(ans,arr,visited,current);
            current.remove(current.size()-1);
            visited[i]=false;
        }
    }


    private static List<Integer> swapList(List<Integer> arr, int start, int end) {
        while (start<end){
            int temp = arr.get(start);
            arr.set(start,arr.get(end));
            arr.set(end,temp);
            start++;
            end--;
        }
        return arr;
    }

    public static void permutation(String str,int index){

        if(index==str.length()-1){
            System.out.print(str+" ");
        }

        for (int i=index;i<str.length();i++){
            str=swap(str.toCharArray(),index,i);
            permutation(str,index+1);
            str= swap(str.toCharArray(),index,i);
        }
    }

    private static String swap(char[] arr, int start, int end) {
        while(end>start) {
            char temp = arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
        return String.valueOf(arr);
    }

    public static void main(String[] args) {
       // permutation("ABC",0);
        System.out.println(permutationArray(new int[] {1,2,3}));
    }

}
