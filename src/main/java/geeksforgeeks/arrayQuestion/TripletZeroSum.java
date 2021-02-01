package geeksforgeeks.arrayQuestion;

public class TripletZeroSum {

	/*
	Given an array of distinct elements. The task is to find triplets in the
    array whose sum is zero
    Input : arr[] = {0, -1, 2, -3, 1}
    Output : (0 -1 1), (2 -3 1)
    */
	public static void trippletSum(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				for (int k = j + 1; k < arr.length; k++) {
					int sum = arr[i] + arr[j] + arr[k];
					if (sum == 0) {
						System.out.print("( " + arr[i] + " ," + arr[j] + " ," + arr[k] + " ) ");
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {0, -1, 2, -3, 1};
		TripletZeroSum.trippletSum(arr);
	}
}
