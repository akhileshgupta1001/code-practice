package Practice.binarySearch;

public class RotatedAndSortedArray {

    public static int getBinarySearch(int[] arr, int key, int start, int end){
        while(start<=end){
            int middle = (start+end)/2;
            if(arr[middle]== key){
                return middle;
            }else if(arr[middle]<arr[key]){
                start = middle+1;
            }else {
                end = middle-1;
            }
        }
        return -1;
    }

    public static int getMinimumElementIndex(int arr[], int key){
        int low =0;
        int high = arr.length;
        int n = arr.length;
        while (low<= high){
            int mid = (low+high)/2;
            int prev = (mid-1+n)%n;
            int next = (mid+1)%n;
            if(arr[prev]>=arr[mid] && arr[next] >=arr[mid]){
                return mid;
            } else if(low<arr[mid]){
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        return -1;
    }


    public static int getIndex(int[] arr, int key){
        int startingIndex= getMinimumElementIndex(arr,key);
        System.out.println("Starting index : "+ startingIndex);
        return Math.max(getBinarySearch(arr,key,0,startingIndex-1)
                ,getBinarySearch(arr,key,startingIndex+1,arr.length-1));

    }

    public static void main(String[] args) {
        System.out.println(getIndex(new int[]{5, 6, 7, 8, 9, 10, 1, 2, 3},3));
    }
}
