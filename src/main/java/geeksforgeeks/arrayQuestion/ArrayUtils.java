package geeksforgeeks.arrayQuestion;

import java.util.Arrays;

public class ArrayUtils {
	
	public static void printArray(int[] arr) {
		Arrays.stream(arr).forEach(iteam -> System.out.print(iteam+" "));
	}
	
	public static int[] reverseArray(int[] arr, int startIndex,int endIndex) {
		
		 while(endIndex>startIndex) {
			 int temp = arr[startIndex];
			 arr[startIndex]=arr[endIndex];
			 arr[endIndex]=temp;
			 startIndex++;
			 endIndex--;
		 }
		 return arr;
	}
}
