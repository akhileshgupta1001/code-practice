package programingInterviewQuestion;

public class Permutation {

	// swap, permutation,swap
	public static void permutation(String data, int start, int end) {

		if (start == end)
			System.out.print(data + " ");

		for (int i = start; i <= end; i++) {
			data =swap(data.toCharArray(), start, i);
			permutation(data, start+1, end);
			data=swap(data.toCharArray(), start, i);
		}
	}

	private static String swap(char[] arr, int start, int end) {
		 while(end>start) {
			 char temp = arr[start];
			 arr[start]=arr[end];
			 arr[end]=temp;
			 start++;
			 end--;
		 }
		return String.valueOf(arr);
	}

	public static void main(String[] args) {
		permutation("abc",0,2);
	}
}
