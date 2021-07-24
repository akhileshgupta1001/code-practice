package programingInterviewQuestion;

public class Factorial {

	public static int findFactorial(int n) {
		int sum = 1;
		if (n == 0 || n == 1)
			return sum;

		for (int i = 1; i <= n; i++) {
			sum = sum * i;
		}
		return sum;
	}

	public static int factorial(int n) {
		if (n == 0 || n == 1)
			return 1;
		return n * factorial(n - 1);
	}

	public static void main(String[] args) {
		System.out.println(factorial(5));
	}
}
