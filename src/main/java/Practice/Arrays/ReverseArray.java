package Practice.Arrays;

import java.util.Arrays;

public class ReverseArray {


    public static int[] reverse(int[] arr){
        return swap(arr,0,arr.length-1);
    }

    private static int[] swap(int[] arr, int start, int end) {

        while (start<= end){
            int temp= arr[start];
            arr[start] = arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
        return arr;
    }

    public static void main(String[] args) {
        Arrays.stream(reverse( new int[]{1,2,3,4,5})).forEach( data-> System.out.print(data+" "));
    }
}
