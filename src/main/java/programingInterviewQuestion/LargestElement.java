package programingInterviewQuestion;

public class LargestElement {

	public static void findSecondLarget(int[] arr){
		int max=0,secondMax=0;
		for(int i=0;i<arr.length;i++) {
			
			if(arr[i]>max) {
				secondMax= max;
				max=arr[i];
			}else if(arr[i]>secondMax) {
				secondMax=arr[i];
			}
		}
		
		System.out.println("Second Max:: "+secondMax);
	}
	
	
	public static void main(String[] args) {
		int arr[] = {1,6,9,15};
		int max = arr[0];
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>max)
				max=arr[i];
		}
		findSecondLarget(arr);
		
		//System.out.println(max);
		

		
	}
}
