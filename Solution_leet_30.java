import java.util.Arrays;

class Solution_leet_30{
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        // dp[i][j][c] stores the max score at cell (i, j) with cost c
        // Initialize with -1 to represent unreachable states
        int[][][] dp = new int[m][n][k + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        // Base case: starting cell (0, 0)
        int startVal = grid[0][0];
        int startCost = (startVal == 0) ? 0 : 1;
        int startScore = startVal;

        if (startCost <= k) {
            dp[0][0][startCost] = startScore;
        } else {
            return -1; // Cannot even start
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int c = 0; c <= k; c++) {
                    if (dp[i][j][c] == -1) continue;

                    // Move Right
                    if (j + 1 < n) {
                        update(grid, dp, i, j + 1, c, dp[i][j][c], k);
                    }
                    // Move Down
                    if (i + 1 < m) {
                        update(grid, dp, i + 1, j, c, dp[i][j][c], k);
                    }
                }
            }
        }

        // Find the maximum score at the bottom-right cell within cost k
        int maxScore = -1;
        for (int c = 0; c <= k; c++) {
            maxScore = Math.max(maxScore, dp[m - 1][n - 1][c]);
        }

        return maxScore;
    }

    private void update(int[][] grid, int[][][] dp, int r, int c, int currentCost, int currentScore, int kLimit) {
        int val = grid[r][c];
        int nextCost = currentCost + (val == 0 ? 0 : 1);
        int nextScore = currentScore + val;

        if (nextCost <= kLimit) {
            dp[r][c][nextCost] = Math.max(dp[r][c][nextCost], nextScore);
        }
    }
}
