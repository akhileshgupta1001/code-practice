package com.dsa.geeksforgeek.searching;

public class SquareRoot {

    // Note : A number is greater than 4 and smaller than 9 => sqrt 2

    //complexity : O(Sqrt(n))
    public static int getSquareRootFlor(int number){
        int i=1;
        while (i*i<= number){
            i++;
        }
        return i-1;
    }
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
       // System.out.println(getSquareRoot(10));
        System.out.println(getSquareRootFlor(10));
    }
}
