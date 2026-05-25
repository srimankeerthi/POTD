class Solution_leet_60 {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        // If the destination is not '0', it's impossible to reach.
        if (s.charAt(n - 1) != '0') {
            return false;
        }

        boolean[] dp = new boolean[n];
        dp[0] = true; // We start at index 0

        int reachableCount = 0;

        for (int i = 1; i < n; i++) {
            // Add the new element that enters the window on the right side
            if (i >= minJump && dp[i - minJump]) {
                reachableCount++;
            }
            
            // Remove the old element that exits the window on the left side
            if (i > maxJump && dp[i - maxJump - 1]) {
                reachableCount--;
            }

            // If the current character is '0' and there's a reachable index in our window
            if (s.charAt(i) == '0' && reachableCount > 0) {
                dp[i] = true;
            }
        }

        return dp[n - 1];
    }
}
