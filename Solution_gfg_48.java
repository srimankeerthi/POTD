class Solution_gfg_48 {
    static int optimalKeys(int n) {
        // According to the constraints 1 <= n <= 70
        // If n is small, the max 'A's is just n
        if (n <= 6) {
            return n;
        }

        // dp[i] will store the maximum 'A's using i keystrokes
        int[] dp = new int[n + 1];

        // Base cases for n 1 to 6
        for (int i = 1; i <= 6; i++) {
            dp[i] = i;
        }

        // Fill the DP table for values from 7 to n
        for (int i = 7; i <= n; i++) {
            // For a given i, check all possible breakpoints j
            // We need at least 3 keys for Ctrl+A, Ctrl+C, Ctrl+V
            // So j can go up to i-3
            for (int j = i - 3; j >= 1; j--) {
                // Number of 'A's = dp[j] * (multiplier)
                // Multiplier = (i - j - 1) 
                // (e.g., if i=7 and j=4: multiplier is 7-4-1 = 2 pastes + original = 3x)
                int val = dp[j] * (i - j - 1);
                if (val > dp[i]) {
                    dp[i] = val;
                }
            }
        }

        return dp[n];
    }
}
