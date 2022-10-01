package com.dsa.geeksforgeek.dyanmic.programing;

public class MaximumSumWithNoTwoConsecutive {

    //{1,10,2}  // 10
    //{8,7,6,10} // 18
    //{10,5,15,20,2,30} // 60

    // Time -> 2exp(n)
    public static int getMaxValue(int[] arr , int size){

        if(size==1) return arr[0];
        else if(size==2) return Math.max(arr[0],arr[1]);

        return Math.max(getMaxValue(arr,size-1),getMaxValue(arr,size-2)+arr[size-1]);

    }

    public static int getMaxValueUsingDP(int[] arr , int size){
        if(size==1) return arr[0];
        int[] dp = new int[size+1];
        dp[1]=arr[0];
        dp[2] = Math.max(arr[0],arr[1]);
        for(int i=3;i<=size;i++){
            dp[i]= Math.max(dp[i-1],dp[i-2]+arr[i-1]);
        }

        return dp[size];
    }

    /// Best solution
    public static int getMaxValueBest(int[] arr , int size){
      if(size==1)  return arr[0];
      int prev_first = arr[0];
      int prev_second = Math.max(arr[0],arr[1]);
      int res  = prev_second;
      for(int i =3;i<=size;i++){
          res = Math.max(prev_second,prev_first+arr[i-1]);
          prev_first=prev_second;
          prev_second=res;
      }
      return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10,5,15,20,2,30};
        System.out.println(getMaxValueBest(arr,arr.length));
    }
}
