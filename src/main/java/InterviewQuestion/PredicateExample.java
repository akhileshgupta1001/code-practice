package InterviewQuestion;

import java.util.function.Predicate;

public class PredicateExample {

	public static void main(String[] args) {
		
		Predicate<Integer> p = number-> number>10;
		System.out.println(p.test(100));
	}
}
