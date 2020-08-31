package Practice.Algorithm;

public class BubbleSort {

    public static  void printArray(int arr[]){
        for (int num: arr) {
            System.out.print (num +" ");
        }
    }
    public  static int[] sort(int[] arr){

        for (int i =1;i<arr.length;i++){
            for (int j =0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    // swap
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        return  arr;
    }

    public static void main (String[] args) {
        int arr[] = {1,5,3,2,5,9};
        printArray ( sort ( arr ) );
    }
}
