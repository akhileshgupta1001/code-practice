package programingInterviewQuestion;

public class Palindrom {

	public static boolean isPalindrom(String data) {

		char[] arr = data.toCharArray();
		int start = 0;
		int end = data.length() - 1;
		while (arr[start++] != arr[end--]) {
			return false;
		}

		return true;
	}

	public static boolean isPalindromUsingRecursion(char[] data, int start, int end) {
		
		if(start>=end)
			return true;
		
		if (data[start] != data[end])
			return false;
		return isPalindromUsingRecursion(data, start + 1, end - 1);
	}

	public static void main(String[] args) {
		String daat1 = "AKhilesh";
		String daat2 = "ABBA";
		System.out.println(isPalindromUsingRecursion
				(daat1.toCharArray(), 0, daat1.length() - 1));
		System.out.println(isPalindromUsingRecursion
				(daat2.toCharArray(), 0, daat2.length() - 1));
	}

}
