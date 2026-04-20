class Solution_gfg_21{
    public int derangeCount(int n) {
        // Base case: if n is 1, no derangement is possible
        if (n == 1) return 0;
        // Base case: if n is 2, only 1 derangement exists [2, 1]
        if (n == 2) return 1;

        // We use long for intermediate steps to prevent overflow, 
        // though the final result for n=12 fits in an int.
        long[] dp = new long[n + 1];
        
        dp[1] = 0;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = (i - 1) * (dp[i - 1] + dp[i - 2]);
        }

        return (int) dp[n];
    }
}
