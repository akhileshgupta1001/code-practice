package programingInterviewQuestion;

public class SubArrayOfGivenArray {

	//find the subArray with  the given string
	
	public static void findSubArray(int[] arr,int sum) {
		for(int i =0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if((arr[i]+arr[j])==sum) {
					System.out.println( arr[i]+" ,"+arr[j]);
					//return;
				}
					 
			}
			
		}
	}
	
	public static void main(String[] args) {
		int[] arr= {10,15,-5,15,-10,5};
		int sum =5;
		
		findSubArray(arr, sum);
		
	}
}
