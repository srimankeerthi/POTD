class Solution_leet_52 {
    public int maxSum(int n) {
        // Base case: for 0, 1, 2, 3, breaking them down will always yield a smaller sum.
        if (n < 12) {
            return n;
        }
        
        // DP array to store the maximum sum for each value up to n
        int[] dp = new int[n + 1];
        
        // Initialize the base values for which breaking down is not beneficial
        for (int i = 0; i < 12; i++) {
            dp[i] = i;
        }
        
        // Compute the maximum sum bottom-up from 12 to n
        for (int i = 12; i <= n; i++) {
            int brokenSum = dp[i / 2] + dp[i / 3] + dp[i / 4];
            dp[i] = Math.max(i, brokenSum);
        }
        
        return dp[n];
    }
}
