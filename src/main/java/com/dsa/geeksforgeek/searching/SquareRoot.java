package com.dsa.geeksforgeek.searching;

public class SquareRoot {

    public static int getSquareRoot(int number){

        int low =1;int high=number;int ans=0;
        while (low<=high){
            int mid = (low+high)/2;
            int square = mid*mid;
            if(square==number)
                return mid;
            else if (square>number) {
                high = mid-1;
            }else {
                low =mid+1;
                ans=mid;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(getSquareRoot(10));
    }
}
