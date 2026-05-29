class Solution_gfg_64 {
    // Memoization table: index can go up to 100, max possible sum is 900
    private Integer[][] dp;

    public int validGroups(String s) {
        int n = s.length();
        dp = new Integer[n][901];
        return countGroupings(s, 0, 0);
    }

    private int countGroupings(String s, int index, int prevSum) {
        // Base Case: If we reach the end of the string, we found 1 valid grouping strategy
        if (index == s.length()) {
            return 1;
        }

        // Return the result if it's already calculated
        if (dp[index][prevSum] != null) {
            return dp[index][prevSum];
        }

        int currentSum = 0;
        int totalWays = 0;

        // Try creating all possible next substrings starting from 'index'
        for (int i = index; i < s.length(); i++) {
            currentSum += s.charAt(i) - '0';

            // If the current substring's sum is valid (non-decreasing), move to the next part
            if (currentSum >= prevSum) {
                totalWays += countGroupings(s, i + 1, currentSum);
            }
        }

        // Store the result in the memoization table and return
        return dp[index][prevSum] = totalWays;
    }
}
