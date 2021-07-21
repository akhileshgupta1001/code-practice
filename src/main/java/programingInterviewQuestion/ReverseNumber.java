package programingInterviewQuestion;

import java.util.Collections;

public class ReverseNumber {

	static int reverseNumber(int number) {
		int reverse = 0, rem = 0;

		while (number != 0) {
			rem = number % 10;
			reverse = reverse * 10 + rem;
			number /= 10;
		}
		return reverse;
	}

}
