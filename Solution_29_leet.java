class Solution_29_leet{
    public long maximumScore(int[][] grid) {
        int n = grid.length;
        long[][] pref = new long[n][n + 1];
        
        // Precompute prefix sums for each column
        for (int c = 0; c < n; c++) {
            for (int r = 0; r < n; r++) {
                pref[c][r + 1] = pref[c][r] + grid[r][c];
            }
        }

        // dp[height][state] where 0 is increasing, 1 is decreasing
        long[][] dp = new long[n + 1][2];

        for (int j = 1; j < n; j++) {
            long[][] nextDp = new long[n + 1][2];
            for (int currH = 0; currH <= n; currH++) {
                for (int prevH = 0; prevH <= n; prevH++) {
                    // Scenario 1: Increasing (Current pillar taller than previous)
                    long gainPrev = (currH > prevH) ? pref[j - 1][currH] - pref[j - 1][prevH] : 0;
                    nextDp[currH][0] = Math.max(nextDp[currH][0], dp[prevH][0] + gainPrev);

                    // Scenario 2: Decreasing (Current pillar shorter than previous)
                    long gainCurr = (prevH > currH) ? pref[j][prevH] - pref[j][currH] : 0;
                    nextDp[currH][1] = Math.max(nextDp[currH][1], Math.max(dp[prevH][0], dp[prevH][1]) + gainCurr);
                }
                
                // Handle the "reset" logic for currH = 0
                if (currH == 0) {
                    for (int prevH = 0; prevH <= n; prevH++) {
                        nextDp[0][0] = Math.max(nextDp[0][0], dp[prevH][1]);
                    }
                }
            }
            dp = nextDp;
        }

        long maxScore = 0;
        for (long[] row : dp) {
            maxScore = Math.max(maxScore, Math.max(row[0], row[1]));
        }
        return maxScore;
    }
}
