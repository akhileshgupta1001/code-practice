package com.dsa.geeksforgeek.stack;

import java.util.*;

public class NextGreaterElement {

    // Find the Previous Greater element from reverse
    // Reverse the number

    //Input: arr[] = [ 4 , 5 , 2 , 25 ]
    //Output:  4      –>   5
    //               5      –>   25
    //               2      –>   25
    //              25     –>   -1
    //Explanation: except 25 every element has an element greater than them present on the right side
    //
    //Input: arr[] = [ 13 , 7, 6 , 12 ]
    //Output:  13      –>    -1
    //                7       –>     12
    //                6       –>     12
    //               12      –>     -1
    //Explanation: 13 and 12 don’t have any element greater than them present on the right side

    public static List<Integer> getNGE(int[] arr){
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<arr.length-1;i++){
            int count =0;
            for(int j = i+1;j< arr.length;j++){
                if(arr[i]<arr[j]){
                    count++;
                    list.add(arr[j]);
                    break;
                }
            }
            if(count==0)
                list.add(-1);
        }
        System.out.println("Result : "+ list);
        return list;
    }

    public static List getNextGreaterElement(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        System.out.println(Arrays.toString(result));

        //System.out.println("Previous : "+list);
       // Collections.reverse(list);
       // Arrays.asList(result).forEach(System.out::print);
        return  Arrays.asList(result);
    }

    public static void main(String[] args) {
       // System.out.println(getNextGreaterElement(new int[]{5,15,10,8,6,12,9,18})); // [15, 18, 12, 12, 12, 18, 18]
        System.out.println(getNextGreaterElement(new int[]{13 , 7, 6 , 12 })); // [15, 18, 12, 12, 12, 18, 18]

    }

}
