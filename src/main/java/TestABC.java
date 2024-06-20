public class TestABC {
    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        // Hardcoded input values
        int T = 4; // Number of test cases
        int[] lengths = {1, 2, 4,6}; // Lengths for each test case

        for (int t = 0; t < T; t++) {
            int N = lengths[t];
            int result = countInterestingNames(N);
            System.out.println("Number of interesting names of length " + N + ": " + result);
        }
    }

    private static int countInterestingNames(int N) {
        if (N == 1) {
            return 26;
        }

        // Initialize the dp array
        int[][] dp = new int[N + 1][26];

        // Base case: one string of length 1 for each character
        for (int j = 0; j < 26; j++) {
            dp[1][j] = 1;
        }

        // Fill the dp table
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 26; j++) {
                for (int k = 0; k < 26; k++) {
                    if (j != k) {  // Ensure no even-length palindromes
                        dp[i][j] = (dp[i][j] + dp[i - 1][k]) % MOD;
                    }
                }
            }
        }

        // Sum up all the valid strings of length N
        int totalInterestingNames = 0;
        for (int j = 0; j < 26; j++) {
            totalInterestingNames = (totalInterestingNames + dp[N][j]) % MOD;
        }

        return totalInterestingNames;
    }
}