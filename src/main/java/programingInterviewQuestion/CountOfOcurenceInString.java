package programingInterviewQuestion;

import java.util.LinkedHashMap;
import java.util.Map;

public class CountOfOcurenceInString {

	// by using map
	public static void count(String data) {
		String s = data.replace(" ", "");
		Map<Character, Integer> frequecyCount = new LinkedHashMap<Character, Integer>();
		for (char c : s.toCharArray()) {
			if (frequecyCount.containsKey(c))
				frequecyCount.put(c, frequecyCount.get(c) + 1);
			else
				frequecyCount.put(c, 1);
		}
		System.out.println(frequecyCount);
	}

	public static void countOccurance(String data) {
		String s = data.replace(" ", "");

		while (s.length() > 0) {
			char c = s.charAt(0);
			System.out.print(c + ":" + frequencyCount(s, c)+" ");
			s = s.replace("" + c, "");
		}
	}

	//logic
	private static int frequencyCount(String s, char c) {
		int count = 0;
		while (s.indexOf(c) != -1) {
			count++;
			s = s.substring(s.indexOf(c) + 1);
		}
		return count;
	}
	
	//
	private static void frequencyCount(String input) {
		input= input.replace(" ", "");
		int arr[] = new int[26];
		
		for (int i = 0; i < input.length(); i++) {
			// Upper case condition
			if (input.charAt(i) >= 65 && input.charAt(i) <= 90)
				arr[input.charAt(i) - 65]++;
			else if(input.charAt(i)>=97 && input.charAt(i)<= 122)
				arr[input.charAt(i)-97]++;
		}
		for(int i =0;i<arr.length;i++) {
			if(arr[i]>0) {
				System.out.println((char)(i+65)+":"+arr[i]);
			}
		}
		
	}
	
	private static void frequencyCount2(String input) {
		input = input.replace(" ", "");
		int arr[] = new int[Character.MAX_VALUE];
		for (int i = 0; i < input.length(); i++) {
			// Upper case condition
			arr[input.charAt(i)]++;
		}
		for (int i = 0; i < input.length(); i++) {
			System.out.println(input.charAt(i) + ":" + arr[input.charAt(i)]);
		}

	}
	public static void main(String[] args) {
		count("AkhileshH");
		countOccurance("Akhilesh");
		System.out.println();
		frequencyCount2("Akhilesh");
	}

}
