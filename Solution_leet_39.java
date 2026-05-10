class Solution_leet_39{
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n];
        
        // Initialize dp array with -1 (unreachable)
        for (int i = 1; i < n; i++) {
            dp[i] = -1;
        }
        dp[0] = 0; // Starting point

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                // Check if index i is reachable and if jump to j is within target
                if (dp[i] != -1 && Math.abs(nums[j] - nums[i]) <= target) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }
        
        return dp[n - 1];
    }
}
