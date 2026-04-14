import java.util.*;

class Solution_leet_16{
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        // Step 1: Sort robots and factories by position
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));

        int n = robot.size();
        int m = factory.length;

        // dp[i][j] = min distance for first i robots using first j factories
        // Initialize with a very large value (Long.MAX_VALUE / 2 to avoid overflow)
        long[][] dp = new long[n + 1][m + 1];
        for (long[] row : dp) Arrays.fill(row, Long.MAX_VALUE / 2);
        
        // Base case: 0 robots fixed with any number of factories costs 0
        for (int j = 0; j <= m; j++) dp[0][j] = 0;

        for (int j = 1; j <= m; j++) { // For each factory
            int factoryPos = factory[j - 1][0];
            int factoryLimit = factory[j - 1][1];

            for (int i = 0; i <= n; i++) { // For each number of robots
                // Option 1: This factory repairs 0 robots
                dp[i][j] = dp[i][j - 1];

                // Option 2: This factory repairs 'k' robots (1 to limit)
                long currentDist = 0;
                for (int k = 1; k <= factoryLimit && i - k >= 0; k++) {
                    currentDist += Math.abs((long)robot.get(i - k) - factoryPos);
                    dp[i][j] = Math.min(dp[i][j], dp[i - k][j - 1] + currentDist);
                }
            }
        }

        return dp[n][m];
    }
}
