package programingInterviewQuestion;

public class BinarySearch {
	
	//normal
	 static int binarySearch(int[] arr, int serachElement) {
		int start = 0;
		int last = arr.length - 1;
		while (start <= last) {
			int mid = (start + last) / 2;

			if (arr[mid] == serachElement)
				return mid;
			else if (serachElement < arr[mid])
				last =mid-1;
			else
				start=mid+1;

		}
		return -1;
	}

		// first ocuurence 
	 static int binarySearchAtFirstOccurence(int[] arr, int serachElement) {
		int start = 0;
		int last = arr.length - 1;
		while (start <= last) {
			int mid = (start + last) / 2;

			if (arr[mid] == serachElement)
				return mid;
			else if (serachElement < arr[mid])
				last =mid-1;
			else
				start=mid+1;

		}
		return -1;
	}
	public static void main(String[] args) {
		int[] arr = {1,6,7,9,11,13,15};
		System.out.println(binarySearch(arr, 11));
		}
}
