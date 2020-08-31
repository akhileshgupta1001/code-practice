package Practice.Algorithm;

import java.util.Arrays;

public class HelperUtility {
    public  static  int getLargestNumber(int[] arr){
        Arrays.sort(arr);
        return arr[arr.length-1];
    }
    public  static  int smallestNumber(int [] arr){
        Arrays.sort( arr );
        return arr[0];
    }
}
