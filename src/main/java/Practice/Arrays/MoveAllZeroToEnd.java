package Practice.Arrays;

import java.util.Arrays;

public class MoveAllZeroToEnd {

    private static int[] swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }
    public static void moveAllZeroToEnd(int[] arr){

        for(int i =0;i<arr.length;i++){
            if(arr[i]==0){
                for(int j=i+1;j< arr.length;j++){
                    if (arr[j] !=0)
                        arr=swap(arr,i,j);
                }
            }
        }
        Arrays.stream(arr).forEach(data-> System.out.println(data+" "));
    }

    public static void moveAllZeroToEnd(int[] arr,int size){
        int count =0;
        for(int i =0;i<arr.length;i++){
                    if (arr[i] !=0) {
                        arr = swap(arr, i, count);
                        count++;
                    }

        }
        Arrays.stream(arr).forEach(data-> System.out.println(data+" "));
    }
    public static void main(String[] args) {
     // moveAllZeroToEnd(new int[]{8, 0, 5, 0, 10});
        int[] arr =new int[]{8, 0, 5, 0, 10};
        moveAllZeroToEnd(arr,arr.length-1);
    }
}
