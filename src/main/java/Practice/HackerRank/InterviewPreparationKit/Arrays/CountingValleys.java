package Practice.HackerRank.InterviewPreparationKit.Arrays;

public class CountingValleys {

	public static int countingValleys(int steps, String path) {
		int countValley = 0;
		int result = 0;
		for (int i = 0; i < steps; i++) {

			if (path.charAt(i) == 'U') {
				countValley++;
			} else if (path.charAt(i) == 'D') {
				countValley--;
			}

			if (countValley == 0 && path.charAt(i) == 'U') {
				result++;
			}

		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(countingValleys(8, "UDDDUDUU"));
	}

}
