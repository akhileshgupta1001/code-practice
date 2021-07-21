package Practice.Arrays;

import geeksforgeeks.arrayQuestion.ArrayUtils;
import geeksforgeeks.arrayQuestion.RotateArrayClockWise;

public class ArrayRotation {
	
	//Using temp array
	public static int[] rotate(int arr[], int d) {

		int[] temp = new int[arr.length];
		int j = 0;
		for (int i = d; i < arr.length; i++) {
			temp[j] = arr[i];
			j++;
		}

		for (int i = 0; i < d; i++) {
			temp[j] = arr[i];
			j++;
		}
		return arr;

	}
	
	public static int[] leftRotateOneByOne(int[] arr){
		int temp=arr[0];
		int i ;
		for( i=0;i<arr.length-1;i++) {
			arr[i]=arr[i+1];
		}
		arr[i]=temp;
		return arr;
		
	}
	
	public static int[] rotateArrayOneByOne(int[] arr, int numberOfRotation) {
		for(int i=1;i<numberOfRotation;i++) {
			arr = leftRotateOneByOne(arr);
		}
		return arr;
	}
	
	public static int[] rotateArrayByReversalAlgo(int arr[], int rotationIndex) {
		/*
		 * rotate(arr[], d, n)
		 *  reverse(arr[], 1, d) ;
		 * reverse(arr[], d + 1, n);
		 * reverse(arr[], 1, n);
		 */
		arr = ArrayUtils.reverseArray(arr, 0, rotationIndex - 1);
		arr = ArrayUtils.reverseArray(arr, rotationIndex, arr.length - 1);
		arr = ArrayUtils.reverseArray(arr, 0, arr.length - 1);
		return arr;
	}
	
	public static void main(String[] args) {
		//ArrayUtils.printArray(rotate(new int[] {1 ,2,3,4,5,6,7},2));
		//ArrayUtils.printArray(leftRotateOneByOne(new int[] {1 ,2,3,4,5,6,7}));
		//ArrayUtils.printArray(rotateArrayOneByOne(leftRotateOneByOne(new int[] {1 ,2,3,4,5,6,7}),2));
	    //ArrayUtils.printArray(ArrayUtils.reverseArray(new int[] {1 ,2,3,4,5,6,7},0,1));
		//ArrayUtils.printArray(rotateArrayByReversalAlgo(new int[] {1 ,2,3,4,5,6,7},2));
	   // ArrayUtils.printArray(RotateArrayClockWise.shiftArray(new int[]{1, 2, 3, 4, 5}));
	}

}
