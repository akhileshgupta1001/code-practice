package geeksforgeeks.arrayQuestion;

public class MaxSumArrayRotation {

	/*
	 * Find maximum value of Sum( i*arr[i]) with only rotations on given array allowed
	Input: arr[] = {1, 20, 2, 10}
	Output: 72
	We can 72 by rotating array twice.
	{2, 10, 1, 20}
	20*3 + 1*2 + 10*1 + 2*0 = 72
	*/
	
	public static int maxSum(int[] arr) {
		int[] newArray = new int[arr.length];
		for(int i = 0;i<arr.length;i++) {
			newArray[i]= arrayMultiplicationWithDigit(rotateArrayOneByOne(arr)); 
		}
		return findMaxInArray(newArray);
	}
	
	public static int findMaxInArray(int[] arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (max < arr[i])
				max = arr[i];
		}
		return max;
	}

	public static int arrayMultiplicationWithDigit(int arr[]) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + i * arr[i];
		}
		return sum;
	}

	public static int[] rotateArrayOneByOne(int arr[]) {
		int i;
		int temp = arr[0];
		for (i = 0; i < arr.length - 1; i++) {
			arr[i] = arr[i + 1];
		}
		arr[i] = temp;
		return arr;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {1, 20, 2, 10};
		System.out.println(maxSum(arr));
	}
}
