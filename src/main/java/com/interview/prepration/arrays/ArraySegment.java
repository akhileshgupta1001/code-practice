package com.interview.prepration.arrays;

public class ArraySegment {

	// Check if a key is present in every segment of size k in an array

	// Given an array arr[] and size of array is n and one another key x, and give
	// you a segment size k. The task is to find that the key x present in every
	// segment of size k in arr[]

	/*
	 * Example Input : arr[] = { 3, 5, 2, 4, 9, 3, 1, 7, 3, 11, 12, 3} x = 3 k = 3
	 * Output : Yes
	 * There are 4 non-overlapping segments of size k in the array, 
	 * {3,5, 2}, {4, 9, 3}, {1, 7, 3} and {11, 12, 3}. 3 is present all segments. 
	 * 
	 * Input
	 * : arr[] = { 21, 23, 56, 65, 34, 54, 76, 32, 23, 45, 21, 23, 25} x = 23 k = 5
	 * Output :Yes 
	 * There are three segments and last segment is not full {21, 23,
	 * 56, 65, 34}, {54, 76, 32, 23, 45} and {21, 23, 25}. 23 is present all window.
	 * 
	 * Input :arr[] = { 5, 8, 7, 12, 14, 3, 9} x = 8 k = 2 Output : No
	 */
	
	public static boolean findXinKwindowSize(int arrLength, int[] arr, int key, int segmentSize) {
		int i;
		for (i = 0; i < arrLength; i = i + segmentSize) {
			for (int j = 0; j < segmentSize; j++) {
				if (i + j < arrLength && arr[i + j] == key)
					break;

				if (j == key)
					return false;
				if (i + j >= arrLength)
					return false;
			}
		}
		if (i >= arrLength)
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		int arr[] = new int[] { 3, 5, 2, 4, 9, 3, 1, 7, 3, 11, 12, 3};
		int[] arr2=new int[] { 5, 8, 7, 12, 14, 3, 9};
		//System.out.println(findXinKwindowSize(arr.length, arr, 3, 3));
		System.out.println(findXinKwindowSize(arr2.length, arr2, 8, 2));

	}
}
