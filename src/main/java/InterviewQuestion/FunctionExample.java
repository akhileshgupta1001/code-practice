package InterviewQuestion;

import java.util.function.Function;

public class FunctionExample {

	public static void main(String[] args) {
		//Write a function to find length of given input string.
		Function<String, Integer> lengthFunction= input->input.length();
		System.out.println(lengthFunction.apply("Akhilesh"));
	}
}
