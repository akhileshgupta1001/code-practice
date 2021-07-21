package programingInterviewQuestion;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateFromString {

	// Using distinct
	static String removeDuplicateCharUsingDistinct(String data) {
		StringBuilder sb = new StringBuilder();
		data.chars().distinct().forEach(stream -> sb.append((char) stream));
		return sb.toString();
	}

	// Using indexOf
	static void removeDuplicateCharUsingIndexOf(String data) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<data.length();i++) {
			if(data.indexOf((char) data.charAt(i),i+1)==-1) {
				sb.append(data.charAt(i));
			}
		}
		System.out.println(sb);
	}
	
	//logic
	static void removeDuplicate(String data) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<data.length();i++) {
			boolean repeted= false;
			for (int j = i+1; j < data.length(); j++) {
				if(data.charAt(i)==data.charAt(j)) {
					repeted=true;
					break;
				}
			}
			if(!repeted) 
				sb.append(data.charAt(i));
		}
		System.out.println(sb);
	}
	
	static void removeDuplicateCharUsingSet(String data) {
		Set<Character> ans = new LinkedHashSet<Character>();
		for (int i = 0; i < data.length(); i++) {
			ans.add(data.charAt(i));
		}
		System.out.println(ans);
	}

	public static void main(String[] args) {
		String name= "Akhilesh";
		 removeDuplicateCharUsingSet("Akhilesh");
		System.out.println(removeDuplicateCharUsingDistinct("Akhilesh"));
		removeDuplicateCharUsingIndexOf(name);
		removeDuplicate(name);
	}
}
