/**
 * 
 */
package geeksforgeeks.arrayQuestion;

import Practice.Algorithm.MathUtil;

/**
 * @author Akhilesh
 *
 *Program for array rotation
 */
public class RotateArray {

	//Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.
	// eg Input arr[] = [1, 2, 3, 4, 5, 6, 7], d = 2, n =7
	// solution arr[] = [3, 4, 5, 6, 7, 1, 2]
	
	public static int[] rotate(int arr[],int indexOfElementForRotation, int sizeOfArray) {
		//indexOfElementForRotation = indexOfElementForRotation >= 1 ?indexOfElementForRotation-1:indexOfElementForRotation;
		  int ar[] = new int[arr.length];
		  int j = 0;
		for(int i=indexOfElementForRotation; i<arr.length;i++) {
			ar[j] = arr[i];
			 j++;
		}
		for(int i = 0;i<indexOfElementForRotation;i++) {
			ar[j]= arr[i];
			j++;
		}
		return ar;
	}
	
	public static int[] leftRotateOneByOne(int[] arr) {
		   
		int temp = arr[0];
		int i ;
		for(i=0;i<arr.length-1;i++) {
			arr[i]=arr[i+1];
		}
		arr[i]=temp;
		return arr;
	}
	
	public static int[] leftRotate(int[] arr , int indexOfRotation) {
		for(int i =0;i<indexOfRotation;i++)
			arr = leftRotateOneByOne(arr);
		return arr;
	}
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5, 6, 7};
		MathUtil.printArray(rotate(arr, 2, 7));
		
		MathUtil.printArray(leftRotate(arr, 2));
	}
}
