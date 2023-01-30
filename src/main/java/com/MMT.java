package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Address {
    private String pincode;
}
final class Employee{
    private int id;
    private String name ;
    private List<Address> address;

    public Employee(int id, String name, List<Address> addresses) {
        this.id = id;
        this.name = name;

        this.address  = new ArrayList<>();
        for(Address add : addresses ){
            address.add(add);
        }
        // this.address = address;
    }


}
public class MMT {
    //Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
    //
    //Since the result may be very large, so you need to return a string instead of an integer.
    //
    //Input: nums = [10,2]
    //Output: "210"
    //102,210



    // Sort -> 012 -> 210,
    // 011 -> 110
    // 10, 28  // 2810

    //1028,2810


    //2810 -> 8210
    // 2,8,1,0 => 8210
    // 7,75 => 75 7 => 775
    //3,30,34,5,9  ->  9534330

    // List <7,5,7> =>

//Given an array of meeting time intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.
//
//Input: intervals = [[0,30],[5,10],[15,20]]
    // start : 0  5  15  //
    // end : 30  10  20  // 10 20 30

    // result = 0;
    // i, j =0
    // if(start[i]<end[j]) {
    //  result ++;
    // i++;
    // } else {
    //  result --;
    // j++;
    // }


    // 0 5 10 15 20 30
    //

    public static int getMiminMettingRoom(List<List<Integer>> data,int size){
        int[] start = new int[size];
        int [] end =  new int[size];
        int i=0;
        for(List<Integer> element : data){
             start[i] = element.get(0);
             end[i] = element.get(1);
             i++;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int result =0;
        int startMeting =0;
        int endMeeting =0;
        while(size>0){
            if(start[startMeting]<end[endMeeting]){
                result++;
                startMeting++;
            }else if(start[startMeting]<end[endMeeting]){
                result--;
                endMeeting++;
            }
            size--;
        }
       return result;
    }

    public static void main(String[] args) {
        List list1 = new ArrayList<>(Arrays.asList(7,10));
        List list2 = new ArrayList<>(Arrays.asList(2,4));
      //  List list3 = new ArrayList<>(Arrays.asList(15,20));
        List list = new ArrayList(Arrays.asList(list1,list2));
        System.out.println(getMiminMettingRoom(list,list.size()));
    }

}
