package Practice.Arrays;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = new int[]{8, 7, 8, 6, 8, 6, 6, 6, 6};
        // index=3 , 6
        System.out.println(majorityElement(arr));
    }

    private static int majorityElement(int[] arr) {
    int max =0;

     for(int i =0;i<arr.length;i++){
         int count =0;
         for(int j=i;j<arr.length;j++){
             if(arr[i]==arr[j]){
                 count++;
                 max = Math.max(max,count);
             }
         }
         if(max> arr.length/2)
             return i;
     }
     return -1;
    }
}
