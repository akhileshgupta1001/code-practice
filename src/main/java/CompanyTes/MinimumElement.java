package CompanyTes;

public class MinimumElement {


    public static int getMinimumElement(int[] arr, int startIndex, int lastIndex,int min) {

        if (min > arr[startIndex])
            min = arr[startIndex];
        if (startIndex == lastIndex - 1)
            return min;

        return getMinimumElement(arr, startIndex + 1, lastIndex,min);
    }

    public static void main(String[] args) {
     int[] arr = new int[]{1,5,6,0,2};
        System.out.println(getMinimumElement(arr,0,arr.length-1,arr[0]));
    }
}
