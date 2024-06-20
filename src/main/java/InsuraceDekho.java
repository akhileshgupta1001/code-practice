public class InsuraceDekho {
    //[] any random
    // [ 1,2,3,4,2]
    // [1,3,4,2,2]



    // arr-> [10,11,12,9,8,7,6,5,4,2,1] , -> 12
    // [10,9,8,12,13,14,15] -> 8
    // [ 1, 2,3, 4, 5] -> -1
    // [10,11,12,9]


    // piv = arr[mid-1] <arr[mid] && arr[mid]> arr[mid+1]
    // inside (arr[mid]<arr[mid-1]  && arr[mid]<arr[mid+1])


    // left -> arr[mid-1] <arr[mid] , left =Mid+1;


    // right    right = mid-1;

    // n = 7 , l =0, h = 6 , mid = 3, arr[mid] =12 , arr[mid-1] = 8, arr[mid+1]=13
    // l= mid+1 = 4 , h = 6 , mid = 5 , arr[mid]= 14, arr[mid-1]= 13, arr[mid+1]=15
    // l =6 , h=6 , m=6,  mid = 6,  ans = -1;






    // low =0 , h = 5  mid = 2  , arr[mid] = 12 , arr[mid-1] <arr[mid] , low =mid+1



    // n = 10 , l =0, h = 9 , mid = 4, arr[mid] =8 , arr[mid-1] = 9, arr[mid+1] = 6
    // l = 0 , h = 3 , mid = 1 , arr[mid] = 11, arr[mid-1] = 10, arr[mid+1] = 12
    // l = 1+1 =2 , h = 3 , mid = 2, arr[mid] = 12, arr[mid-1] = 11, arr[mid+1] = 9 ,  ans = 12



    // n = 11 , l =0, h = 10 , mid = 5, arr[mid] =7 , arr[mid-1] = 8, arr[mid+1] = 6
    // l = 0 , h = 4 , mid = 2 , arr[mid] = 12, arr[mid-1] = 11, arr[mid+1] = 9 , ans = 12



    /*
    public static int findPeakElement(int[] arr){
        int low =0;
        int high = arr.length-1;

        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid-1] <arr[mid] && arr[mid]>arr[mid+1]){
                return arr[mid];
            }
        }
    }

     */


}
