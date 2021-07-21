package Practice.HackerRank.InterviewPreparationKit.Arrays;

public class JumpingOnTheClouds {

	static int jumpingOnClouds(int[] c) {
		int count = 0;

		for (int i = 0; i < c.length - 1;) {

			if (i < c.length - 2 && c[i + 2] == 0) {
				i = i + 2;
				count++;
			} else {
				i++;
				count++;
			}
		}
		return count;

	}

	public static void main(String[] args) {
		System.out.println(jumpingOnClouds(new int[] { 0, 0, 1, 0, 0, 1, 0 }));
	}

}
