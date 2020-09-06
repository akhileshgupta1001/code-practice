package Practice.Algorithm;

public class MathUtil {
	
	public static void printArray(int arr[]) {
		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
	
	//Reverse using swapping methods
	public static int[] reverse(int[] arr) {
		for (int i = 0; i < arr.length/2; i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length-1 - i] = temp;
		}
		return arr;
	}
	
	/*Function to reverse arr[] from index start to end*/
	public static int[] rvereseArray(int arr[], int start, int end) 
	{ 
	    while (start < end) { 
	        int temp = arr[start]; 
	        arr[start] = arr[end]; 
	        arr[end] = temp; 
	        start++; 
	        end--; 
	    } 
	    return arr;
	} 
}
